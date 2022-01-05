package hu.nye.progtech.torpedo.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.ScoreVO;
import hu.nye.progtech.torpedo.persistence.HighScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Adatbázis a score táblának.
 */

public class JdbcHighScoreRepository implements HighScoreRepository, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcHighScoreRepository.class);

    public static final String SELECT_STATEMENT = "SELECT * FROM score ORDER BY victory_count DESC;";
    public static final String INSERT_STATEMENT = "INSERT INTO score(name,victory_count) VALUES ( ?, ?);";
    public static final String UPDATE_STATEMENT = "UPDATE score SET victory_count = " +
            "(SELECT victory_count FROM score WHERE name = ?)+1 WHERE name = ?;";

    private Connection connection;

    public JdbcHighScoreRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveScore(String playerName) {
        boolean exist = false;
        ArrayList<String> names = null;
        try {
            names = selectName();
        } catch (SQLException e) {
            LOGGER.error("Exception during select names", e);
        }
        for (String name : names) {
            if (name.equals(playerName)) {
                exist = true;
                try {
                    updateScore(name);
                } catch (SQLException e) {
                    LOGGER.error("Exception during updating score", e);
                }
            }
        }
        try {
            if (!exist) {
                savingScore(playerName);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception during score save", e);
        }
    }

    @Override
    public ArrayList<ScoreVO> loadScore() {
        ArrayList<ScoreVO> scoreVOS = new ArrayList<>();
        try {
            scoreVOS = selectScore();
        } catch (SQLException e) {
            LOGGER.error("Exception during score download", e);
        }
        return scoreVOS;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    private void savingScore(String name) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        }
    }

    private ArrayList<ScoreVO> selectScore() throws SQLException {
        ArrayList<ScoreVO> scoreVOS = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int score = resultSet.getInt("victory_count");
                scoreVOS.add(new ScoreVO(name, score));
            }
        }
        return scoreVOS;
    }

    private ArrayList<String> selectName() throws SQLException {
        ArrayList<String> names = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_STATEMENT);
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
        }
        return names;
    }

    private void updateScore(String name) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        }
    }

}
