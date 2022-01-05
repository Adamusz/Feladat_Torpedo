package hu.nye.progtech.torpedo.persistence;

import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.Player;

/**
 * Mentés, betöltés interfésze.
 */

public interface SaveGameRepository {
    void saveGame(ArrayList<Player> players);

    ArrayList<Player> loadGame();
}
