package hu.nye.progtech.torpedo;

import java.util.Scanner;

import hu.nye.progtech.torpedo.model.BaseMap;
import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.service.command.Commands;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.ui.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main.
 */

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Main.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputReader inputReader = new InputReader(scanner);
        Printer printer = new Printer();
        BaseMap baseMap = new BaseMap();
        String[][] map = baseMap.map();
        MapVO mapVO = new MapVO(map);
        String input;
        do {
            System.out.println("Make a command:");
            Commands commands = new Commands(inputReader, printer, mapVO);
            input = inputReader.scanInput();
            mapVO = commands.commandCheck(input);
        } while (!input.equals("exit"));
    }
}
