package hu.nye.progtech.torpedo.service.command;

import java.sql.SQLOutput;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.ui.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parancsok.
 */

public class Commands {
    private static final Logger LOGGER = LoggerFactory.getLogger(Commands.class);
    private final InputReader inputReader;
    private final Printer printer;
    private MapVO mapVO;

    public Commands(InputReader inputReader, Printer printer, MapVO mapVO) {
        this.inputReader = inputReader;
        this.printer = printer;
        this.mapVO = mapVO;
    }

    /**
     * Parancs ellenőrzése.
     */

    public MapVO commandCheck(String input) {
        switch (input) {
            case "print":
                printer.printMap(mapVO);
                break;
            case "help":
                System.out.println("Help");
                break;
            case "save":
                System.out.println("Save");
                break;
            case "score":
                System.out.println("Score Board");
                break;
            case "load":
                System.out.println("Load");
                break;
            case "setup":
                System.out.println("Setup your board: ");
                SetupCommand setupCommand = new SetupCommand(inputReader);
                String[][] position = mapVO.getMap();
                String[][] map = setupCommand.setupShips(position);
                mapVO = new MapVO(map);
                break;
            case "shot":
                System.out.println("Shot");
                break;
            case "exit":
                System.out.println("Exit game");
                break;
            default:
                System.out.println("Unkown command");
                break;
        }
        return mapVO;
    }
}
