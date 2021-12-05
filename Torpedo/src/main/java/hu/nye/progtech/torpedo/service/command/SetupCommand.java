package hu.nye.progtech.torpedo.service.command;

import hu.nye.progtech.torpedo.service.game.SetupPosition;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.service.validator.PositionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Felállás.
 */

public class SetupCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(SetupCommand.class);
    private final InputReader inputReader;
    private SetupPosition setupPosition;
    private PositionValidator positionValidator;

    public SetupCommand(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    /**
     * Felállása a hajóknak.
     */

    public String[][] setupShips(String[][] position) {
        System.out.println("Horizontal or vertical positioning?(h or v)");
        String choose = inputReader.scanInput();
        boolean positionAvailable;
        try {
            if (choose.equals("h")) {
                int row;
                System.out.println("Row position:");
                row = Integer.parseInt(inputReader.scanInput());
                System.out.println("First col position:");
                int col1;
                col1 = Integer.parseInt(inputReader.scanInput());
                System.out.println("Second col position:");
                int col2;
                col2 = Integer.parseInt(inputReader.scanInput());
                positionValidator = new PositionValidator();
                positionAvailable = positionValidator.positionAvailableHorizontal(col1, col2, row, position);
                setupPosition = new SetupPosition();
                if (positionAvailable) {
                    position = setupPosition.horizontal(col1, col2, row, position);
                } else {
                    System.out.println("Position already occupied!");
                }
            } else if (choose.equals("v")) {
                int col;
                System.out.println("Col position:");
                col = Integer.parseInt(inputReader.scanInput());
                System.out.println("First row position:");
                int row1;
                row1 = Integer.parseInt(inputReader.scanInput());
                System.out.println("Second row position:");
                int row2;
                row2 = Integer.parseInt(inputReader.scanInput());
                positionValidator = new PositionValidator();
                positionAvailable = positionValidator.positionAvailableVertical(row1, row2, col, position);
                setupPosition = new SetupPosition();
                if (positionAvailable) {
                    position = setupPosition.vertical(row1, row2, col, position);
                } else {
                    System.out.println("Position already occupied!");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Not acceptable parameter");
        }
        return position;
    }
}
