package hu.nye.progtech.torpedo.service.game;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcHighScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lövés helyének megjelölése.
 */

public class ShootPosition {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShootPosition.class);

    private static final String MISS = "X";
    private static final String HIT = "(X)";
    private static final String EMPTY = " ";

    /**
     * Lövés megjelölése a lövéstáblán.
     */
    public String[][] shoot(int row, int column, String[][] position, boolean isHit) {
        if (isHit) {
            position[row][column] = HIT;
            System.out.println("Hit!");
        } else {
            position[row][column] = MISS;
            System.out.println("Miss!");
        }
        return position;
    }

    /**
     * Saját táblán jelölés.
     */

    public String[][] hitOnBoard(int row, int column, String[][] position, Player player) {
        if (!position[row][column].equals(EMPTY)) {
            for (int i = 0; i < 5; i++) {
                if (position[row][column].equals("(" + i + ")")) {
                    player.setHealth(player.getHealth() - 1);
                }
            }
            position[row][column] = HIT;
        }
        return position;
    }
}
