package hu.nye.progtech.torpedo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import hu.nye.progtech.torpedo.model.BaseMap;
import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.model.Ship;
import hu.nye.progtech.torpedo.persistence.HighScoreRepository;
import hu.nye.progtech.torpedo.persistence.impl.JdbcHighScoreRepository;
import hu.nye.progtech.torpedo.persistence.impl.XmlSaveGameRepository;
import hu.nye.progtech.torpedo.service.command.Commands;
import hu.nye.progtech.torpedo.service.input.InputReader;
import hu.nye.progtech.torpedo.ui.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main.
 */

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Main.
     */

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext("hu.nye.progtech.torpedo");
    }
}
