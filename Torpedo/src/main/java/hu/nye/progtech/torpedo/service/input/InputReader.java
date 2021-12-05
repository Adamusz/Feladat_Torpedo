package hu.nye.progtech.torpedo.service.input;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Beolvasás konzolról.
 */

public class InputReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(InputReader.class);

    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Beolvasás konzolról scannerrel.
     */
    public String scanInput() {
        String input;
        input = scanner.nextLine();
        return input;
    }

}