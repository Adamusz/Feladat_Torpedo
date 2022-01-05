package hu.nye.progtech.torpedo.model;

import java.util.ArrayList;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Játékos.
 */
@XmlRootElement(name = "player")
@XmlType(propOrder = {"playerName", "boardMap", "shootMapMap", "ships", "health"})
public class Player {
    private String playerName;
    private MapVO board;
    private MapVO shootMap;
    private ArrayList<Ship> ships;
    private int health;

    public Player() {
    }

    public Player(String playerName, MapVO board, MapVO shootMap, ArrayList<Ship> ships, int health) {
        this.playerName = playerName;
        this.board = board;
        this.shootMap = shootMap;
        this.ships = ships;
        this.health = health;
    }

    @XmlElement
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @XmlElement
    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    @XmlElement
    public String getPlayerName() {
        return playerName;
    }

    @XmlTransient
    public MapVO getBoard() {
        return board;
    }

    @XmlElement
    public String[][] getBoardMap() {
        return board.getMap();
    }

    public void setBoard(MapVO board) {
        this.board = board;
    }

    @XmlTransient
    public MapVO getShootMap() {
        return shootMap;
    }

    @XmlElement
    public String[][] getShootMapMap() {
        return shootMap.getMap();
    }

    public void setShootMap(MapVO shootMap) {
        this.shootMap = shootMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName)
                && Objects.equals(board, player.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, board);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", board=" + board +
                '}';
    }
}
