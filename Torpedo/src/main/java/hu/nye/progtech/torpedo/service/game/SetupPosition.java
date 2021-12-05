package hu.nye.progtech.torpedo.service.game;

import hu.nye.progtech.torpedo.service.input.InputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Elhelyezés.
 */
public class SetupPosition {
    private static final Logger LOGGER = LoggerFactory.getLogger(SetupPosition.class);
    private static final String SHIP = "(0)";

    /**
     * Horizontális.
     */
    public String[][] horizontal(int col1, int col2, int row, String[][] position) {
        if (col2 > col1) {
            for (int i = col1; i <= col2; i++) {
                position[row][i] = SHIP;
            }
        } else if (col1 > col2) {
            for (int i = col2; i <= col1; i++) {
                position[row][i] = SHIP;
            }
        }
        return position;
    }

    /**
     * Vertikális.
     */
    public String[][] vertical(int row1, int row2, int col, String[][] position) {
        if (row2 > row1) {
            for (int i = row1; i <= row2; i++) {
                position[i][col] = SHIP;
            }
        } else if (row1 > row2) {
            for (int i = row2; i <= row1; i++) {
                position[i][col] = SHIP;
            }
        }
        return position;
    }
}
