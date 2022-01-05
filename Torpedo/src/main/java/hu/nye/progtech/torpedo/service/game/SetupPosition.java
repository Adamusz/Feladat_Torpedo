package hu.nye.progtech.torpedo.service.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Elhelyezés.
 */
public class SetupPosition {
    private static final Logger LOGGER = LoggerFactory.getLogger(SetupPosition.class);

    /**
     * Horizontális.
     */
    public String[][] horizontal(int col1, int col2, int row, String[][] position, int num) {
        if (col2 > col1) {
            for (int i = col1; i <= col2; i++) {
                position[row][i] = "(" + num + ")";
            }
        } else if (col1 > col2) {
            for (int i = col2; i <= col1; i++) {
                position[row][i] = "(" + num + ")";
            }
        }
        return position;
    }

    /**
     * Vertikális.
     */
    public String[][] vertical(int row1, int row2, int col, String[][] position, int num) {
        if (row2 > row1) {
            for (int i = row1; i <= row2; i++) {
                position[i][col] = "(" + num + ")";
            }
        } else if (row1 > row2) {
            for (int i = row2; i <= row1; i++) {
                position[i][col] = "(" + num + ")";
            }
        }
        return position;
    }
}
