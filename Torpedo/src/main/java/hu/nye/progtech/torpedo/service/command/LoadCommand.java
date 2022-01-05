package hu.nye.progtech.torpedo.service.command;

import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.XmlSaveGameRepository;

/**
 * Betöltés parancs.
 */

public class LoadCommand {

    /**
     * Betöltés.
     */

    public ArrayList<Player> load() {
        XmlSaveGameRepository xmlSaveGameRepository = new XmlSaveGameRepository();
        ArrayList<Player> players = new ArrayList<>();
        players = xmlSaveGameRepository.loadGame();
        return players;
    }
}
