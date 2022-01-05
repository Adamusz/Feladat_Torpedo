package hu.nye.progtech.torpedo.service.command;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.model.Ship;
import hu.nye.progtech.torpedo.service.game.SetupPosition;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.service.validator.PositionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Felállás.
 */

public class SetupBoard {
    private static final Logger LOGGER = LoggerFactory.getLogger(SetupBoard.class);
    private final InputReader inputReader;
    private SetupPosition setupPosition;
    private PositionValidator positionValidator;

    public SetupBoard(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    /**
     * Felállása a hajóknak.
     */

    public String[][] setupShips(String[][] position, Ship ship, int num) {
        boolean isWrong = false;
        boolean exception;
        do {
            System.out.println("Horizontal or vertical positioning?(h or v)");
            String choose;
            boolean positionAvailable;
            do {
                choose = inputReader.scanInput();
                if (choose.equals("h")) {
                    int row = 0;
                    int col = 0;
                    do {
                        exception = false;
                        try {
                            System.out.println("Row position:");
                            row = Integer.parseInt(inputReader.scanInput());
                            if (row > 9) {
                                throw new ArrayIndexOutOfBoundsException();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Wrong input");
                            exception = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            LOGGER.error("Too big! Number must be between 0 and 9");
                            exception = true;
                        }
                    } while (exception);
                    do {
                        exception = false;
                        try {
                            System.out.println("Column position:");
                            col = Integer.parseInt(inputReader.scanInput());
                            if (col > 9) {
                                throw new ArrayIndexOutOfBoundsException();
                            }
                        } catch (NumberFormatException e) {
                            LOGGER.error("Wrong input");
                            exception = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            LOGGER.error("Too big! Number must be between 0 and 9");
                            exception = true;
                        }
                    } while (exception);

                    positionValidator = new PositionValidator();
                    positionAvailable = positionValidator.positionAvailableHorizontal(col, (col + ship.getShipSize() - 1), row, position);
                    setupPosition = new SetupPosition();
                    if (positionAvailable) {
                        position = setupPosition.horizontal(col, (col + ship.getShipSize() - 1), row, position, num);

                        isWrong = false;
                    } else {
                        System.out.println("Position not available!");
                        isWrong = true;
                    }


                } else if (choose.equals("v")) {
                    int col = 0;
                    int row = 0;
                    do {
                        exception = false;
                        try {
                            System.out.println("Column position:");
                            col = Integer.parseInt(inputReader.scanInput());
                            if (col > 9) {
                                throw new ArrayIndexOutOfBoundsException();
                            }
                        } catch (NumberFormatException e) {
                            LOGGER.error("Wrong input");
                            exception = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            LOGGER.error("Too big! Number must be between 0 and 9");
                            exception = true;
                        }
                    } while (exception);
                    do {
                        exception = false;
                        try {
                            System.out.println("Row position:");
                            row = Integer.parseInt(inputReader.scanInput());
                            if (row > 9) {
                                throw new ArrayIndexOutOfBoundsException();
                            }
                        } catch (NumberFormatException e) {
                            LOGGER.error("Wrong input");
                            exception = true;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            LOGGER.error("Too big! Number must be between 0 and 9");
                            exception = true;
                        }
                    } while (exception);

                    positionValidator = new PositionValidator();
                    positionAvailable = positionValidator.positionAvailableVertical(row, (row + ship.getShipSize() - 1), col, position);
                    setupPosition = new SetupPosition();
                    if (positionAvailable) {
                        position = setupPosition.vertical(row, (row + ship.getShipSize() - 1), col, position, num);

                        isWrong = false;
                    } else {
                        System.out.println("Position not available!");
                        isWrong = true;
                    }
                }
            } while (!choose.equals("h") && !choose.equals("v"));
        } while (isWrong);
        return position;
    }
}
