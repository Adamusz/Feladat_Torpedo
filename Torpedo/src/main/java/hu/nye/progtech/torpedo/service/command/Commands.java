package hu.nye.progtech.torpedo.service.command;


import java.util.ArrayList;
import java.util.Locale;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.HighScoreRepository;
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
    private final Player player;
    MapVO[] maps = new MapVO[3];
    HighScoreRepository highScoreRepository;
    ShotCommand shotCommand;
    HelpCommand helpCommand;
    SaveCommand saveCommand;

    ArrayList<Player> players;

    public Commands(InputReader inputReader, Printer printer, MapVO mapVO, MapVO mapVO2, MapVO shootMap,
                    Player player, HighScoreRepository highScoreRepository, ArrayList<Player> players) {
        this.inputReader = inputReader;
        this.printer = printer;
        this.maps[0] = mapVO;
        this.maps[1] = shootMap;
        this.maps[2] = mapVO2;
        this.player = player;
        this.highScoreRepository = highScoreRepository;
        this.players = players;
    }

    /**
     * Parancs ellenőrzése.
     */

    public MapVO[] commandCheck(String input) {
        switch (input.toLowerCase()) {
            case "print":
                printer.printMap(maps[1], maps[0]);
                break;
            case "help":
                helpCommand = new HelpCommand();
                helpCommand.help();
                break;
            case "save":
                System.out.println("Save");
                saveCommand = new SaveCommand();
                saveCommand.save(players);
                break;
            case "score":
                System.out.println("Score Board");
                printer.printPlayerResults(highScoreRepository);
                break;
            case "shoot":
                shotCommand = new ShotCommand(inputReader, player);
                maps = shotCommand.shoot(maps);
                break;
            case "exit":
                System.out.println("Exit game");
                break;
            default:
                System.out.println("Unkown command");
                break;
        }
        return maps;
    }
}
