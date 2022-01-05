package hu.nye.progtech.torpedo.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelpCommand segitség a parancsokkal kapcsolatban.
 */

public class HelpCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelpCommand.class);

    /**
     * Help parancs.
     */

    public void help() {

        System.out.println("Command list:\n" +
                "-print\n" +
                "-shoot\n" +
                "-save\n" +
                "-score\n" +
                "-exit\n"
        );
    }
}
