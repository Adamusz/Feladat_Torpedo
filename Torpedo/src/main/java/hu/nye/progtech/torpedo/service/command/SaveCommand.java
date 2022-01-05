package hu.nye.progtech.torpedo.service.command;

import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.XmlSaveGameRepository;

/**
 * Mentés parancs.
 */

public class SaveCommand {

    /**
     * Mentés.
     */

    public void save(ArrayList<Player> players) {
        XmlSaveGameRepository xmlSaveGameRepository = new XmlSaveGameRepository();
        xmlSaveGameRepository.saveGame(players);
    }
}
