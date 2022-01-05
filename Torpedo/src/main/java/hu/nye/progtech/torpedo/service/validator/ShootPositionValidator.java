package hu.nye.progtech.torpedo.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lövések eredménye.
 */

public class ShootPositionValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionValidator.class);

    private static final String MISS = "X";
    private static final String HIT = "(X)";
    private static final String EMPTY = " ";

    /**
     * Lőhető-e a pozicíó.
     */

    public boolean shootable(int row, int col, String[][] position) {
        if (position[row][col].equals(MISS) || position[row][col].equals(HIT)) {
            return false;
        }
        return true;
    }

    /**
     * Találat-e.
     */

    public boolean isHit(int row, int col, String[][] position) {
        if (position[row][col].equals(EMPTY)) {
            return false;
        }
        return true;
    }

}
