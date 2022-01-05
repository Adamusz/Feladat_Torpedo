package hu.nye.progtech.torpedo.service.command;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.service.game.ShootPosition;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.service.validator.ShootPositionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tűzelés.
 */
public class ShotCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShotCommand.class);

    private final InputReader inputReader;
    private ShootPositionValidator shootPositionValidator;
    private Player player;

    public ShotCommand(InputReader inputReader, Player player) {
        this.inputReader = inputReader;
        this.player = player;
    }

    /**
     * Tűzelés.
     */

    public MapVO[] shoot(MapVO[] maps) {
        LOGGER.info("Shooting");
        System.out.println("Where do you want to shoot?");
        int row;
        int column;
        row = 0;
        column = 0;
        boolean exception;
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

        do {
            exception = false;
            try {
                System.out.println("Column position:");
                column = Integer.parseInt(inputReader.scanInput());
                if (column > 9) {
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

        shootPositionValidator = new ShootPositionValidator();
        boolean shootPositionAvailable;
        shootPositionAvailable = shootPositionValidator.shootable(row, column, maps[1].getMap());
        boolean isHit;
        isHit = shootPositionValidator.isHit(row, column, maps[2].getMap());

        if (shootPositionAvailable) {
            ShootPosition shootPosition = new ShootPosition();
            String[][] map = shootPosition.shoot(row, column, maps[1].getMap(), isHit);
            maps[1] = new MapVO(map);
            String[][] map2 = shootPosition.hitOnBoard(row, column, maps[2].getMap(), player);
            maps[2] = new MapVO(map2);
        } else {
            System.out.println("Not available shooting position!");
        }
        return maps;
    }
}
