package hu.nye.progtech.torpedo.model;

import java.util.Objects;

/**
 * ScoreVO a pontok táblázatban való megjelenítéséhez.
 */

public class ScoreVO {
    private String playerName;
    private int victoryCount;

    public ScoreVO(String playerName, int victoryCount) {
        this.playerName = playerName;
        this.victoryCount = victoryCount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getVictoryCount() {
        return victoryCount;
    }

    public void setVictoryCount(int victoryCount) {
        this.victoryCount = victoryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScoreVO scoreVO = (ScoreVO) o;
        return victoryCount == scoreVO.victoryCount && Objects.equals(playerName, scoreVO.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, victoryCount);
    }

    @Override
    public String toString() {
        return "ScoreVO{" +
                "playerName='" + playerName + '\'' +
                ", victoryCount=" + victoryCount +
                '}';
    }
}
