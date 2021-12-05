package hu.nye.progtech.torpedo.service.validator;

import hu.nye.progtech.torpedo.service.input.InputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Elérhető-e a hely.
 */
public class PositionValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionValidator.class);
    private static final String SHIP = "(0)";

    /**
     * Elérhető-e a horizontális hely.
     */
    public boolean positionAvailableHorizontal(int col1, int col2, int row, String[][] position) {
        for (int i = col1; i <= col2; i++) {
            if (position[row][i].equals(SHIP)) {
                return false;
            }
        }
        for (int i = col2; i <= col1; i++) {
            if (position[row][i].equals(SHIP)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Elérhető-e a vertikális hely.
     */
    public boolean positionAvailableVertical(int row1, int row2, int col, String[][] position) {
        for (int i = row1; i <= row2; i++) {
            if (position[i][col].equals(SHIP)) {
                return false;
            }
        }
        for (int i = row2; i <= row1; i++) {
            if (position[i][col].equals(SHIP)) {
                return false;
            }
        }
        return true;
    }
}
