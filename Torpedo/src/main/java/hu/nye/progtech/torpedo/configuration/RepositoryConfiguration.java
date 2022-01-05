package hu.nye.progtech.torpedo.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.progtech.torpedo.persistence.impl.JdbcHighScoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Adatbázis kezelése.
 */

@Configuration
public class RepositoryConfiguration {
    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/highscore", "root", "");
    }

    @Bean
    public JdbcHighScoreRepository jdbcHighScoreRepository(Connection connection) {
        return new JdbcHighScoreRepository(connection);
    }
}
