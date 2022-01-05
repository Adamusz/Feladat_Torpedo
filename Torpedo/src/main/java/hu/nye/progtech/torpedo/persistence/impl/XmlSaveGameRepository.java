package hu.nye.progtech.torpedo.persistence.impl;

import java.io.File;
import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.SaveGameRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mentés, betöltés.
 */


public class XmlSaveGameRepository implements SaveGameRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlSaveGameRepository.class);

    @Override
    public void saveGame(ArrayList<Player> players) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ArrayList<Player> players2 = new ArrayList<>();
            for (int i = 0; i < players.size(); i++) {

                players2.add(new Player(players.get(i).getPlayerName(), players.get(i).getBoard(), players.get(i).getShootMap(),
                        players.get(i).getShips(), players.get(i).getHealth()));

                marshaller.marshal(players2.get(i), new File("save" + i + ".xml"));
            }
        } catch (JAXBException e) {
            LOGGER.error("Jaxb error during save", e);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Player> loadGame() {

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> players2 = new ArrayList<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            System.out.println("object " + (Player) unmarshaller.unmarshal(new File("save0.xml")));

            for (int i = 0; i < 2; i++) {
                players2.add((Player) unmarshaller.unmarshal(new File("save" + i + ".xml")));


                players.add(new Player(players2.get(i).getPlayerName(), new MapVO(players2.get(i).getBoardMap()),
                        new MapVO(players2.get(i).getShootMapMap()), players2.get(i).getShips(), players2.get(i).getHealth()));
            }


        } catch (JAXBException e) {
            LOGGER.error("Jaxb Error during load", e);
            e.printStackTrace();
        }
        return players;
    }
}
