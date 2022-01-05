package hu.nye.progtech.torpedo.service.game;

import java.util.ArrayList;
import java.util.Scanner;

import hu.nye.progtech.torpedo.model.BaseMap;
import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.model.Ship;
import hu.nye.progtech.torpedo.persistence.HighScoreRepository;
import hu.nye.progtech.torpedo.service.command.Commands;
import hu.nye.progtech.torpedo.service.command.LoadCommand;
import hu.nye.progtech.torpedo.service.command.SetupBoard;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.ui.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Játék vezérlője.
 */

public class GameController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Ship> ships = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer = new Printer();
    private HighScoreRepository highScoreRepository;

    public GameController(HighScoreRepository highScoreRepository) {
        this.highScoreRepository = highScoreRepository;
    }

    /**
     * Játék inditása.
     */

    public void start() {
        ships.add(new Ship("Carrier", 5, 5, ' ', 0, 0, 0));
        ships.add(new Ship("Battleship", 4, 4, ' ', 0, 0, 0));
        ships.add(new Ship("Cruiser", 3, 3, ' ', 0, 0, 0));
        ships.add(new Ship("Submarine", 3, 3, ' ', 0, 0, 0));
        ships.add(new Ship("Destroyer", 2, 2, ' ', 0, 0, 0));

        InputReader inputReader = new InputReader(scanner);
        BaseMap baseMap = new BaseMap();
        String[][] map = baseMap.map();

        MapVO[] maps = new MapVO[3];
        maps[0] = new MapVO(map);
        maps[1] = new MapVO(map);
        maps[2] = new MapVO(map);

        boolean wrong = false;
        String input;
        do {
            System.out.println("New game(start) or Loading existing game(load)?");
            input = inputReader.scanInput();
            if (input.equalsIgnoreCase("start")) {
                for (int i = 0; i < 2; i++) {
                    createPlayer(inputReader, maps[0], i);
                    MapVO set = setShips(maps[0], inputReader);
                    players.get(i).setBoard(set);
                }
            } else if (input.equalsIgnoreCase("load")) {
                LoadCommand loadCommand = new LoadCommand();
                players = loadCommand.load();
            } else {
                System.out.println("Wrong input!");
                wrong = true;
            }
        } while (wrong);

        do {
            input = null;
            for (int i = 0; i < 2; i++) {
                System.out.println(players.get(i).getPlayerName() + "'s turn:");
                do {
                    System.out.println("Make a command:");
                    Commands commands = new Commands(inputReader, printer, players.get(i).getBoard(), players.get((i + 1) % 2).getBoard(),
                            players.get(i).getShootMap(), players.get(i), highScoreRepository, players);
                    input = inputReader.scanInput();
                    maps = commands.commandCheck(input);
                    players.get(i).setShootMap(maps[1]);
                    players.get(i).setBoard(maps[0]);
                    players.get((i + 1) % 2).setBoard(maps[2]);

                } while (!input.equals("shoot") && !input.equals("exit") && players.get(i).getHealth() != 0);
                if (input.equals("exit")) {
                    break;
                }
                if (players.get(i).getHealth() == 0) {
                    System.out.println(players.get(i).getPlayerName() + " won!");
                    highScoreRepository.saveScore(players.get(i).getPlayerName());
                    input = "exit";
                    break;
                }
            }
        } while (!input.equals("exit"));
    }

    /**
     * Játékos létrehozása.
     */

    public void createPlayer(InputReader inputReader, MapVO mapVO, int playerNumber) {
        System.out.println("What is your name Player" + (playerNumber + 1) + "?");
        players.add(new Player(inputReader.scanInput(), mapVO, mapVO, ships, 17));
    }

    /**
     * Hajók feállitása.
     */

    public MapVO setShips(MapVO mapVO, InputReader inputReader) {
        int i = 0;
        while (i < 5) {
            System.out.println("Setup your " + ships.get(i).getClassName() + ": ");
            SetupBoard setupBoard = new SetupBoard(inputReader);
            String[][] position = mapVO.getMap();
            String[][] map = setupBoard.setupShips(position, ships.get(i), i);
            mapVO = new MapVO(map);
            i++;
            printer.printMap(mapVO);
        }
        return mapVO;
    }
}
