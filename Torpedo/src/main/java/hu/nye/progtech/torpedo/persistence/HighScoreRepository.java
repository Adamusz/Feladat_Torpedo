package hu.nye.progtech.torpedo.persistence;

import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.ScoreVO;

/**
 * Interfész az adatbázis számára.
 */

public interface HighScoreRepository {

    void saveScore(String name);

    ArrayList<ScoreVO> loadScore();
}
