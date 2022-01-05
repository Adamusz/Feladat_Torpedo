package hu.nye.progtech.torpedo.model;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hajók.
 */

public class Ship {
    private static final Logger LOGGER = LoggerFactory.getLogger(Ship.class);
    private String className;
    private int shipSize;
    private int shipHealth;
    private char direction;
    private int pos1;
    private int pos2;
    private int pos3;

    public Ship() {
    }

    public Ship(String className, int shipSize, int shipHealth, char direction, int pos1, int pos2, int pos3) {
        this.className = className;
        this.shipSize = shipSize;
        this.shipHealth = shipHealth;
        this.direction = direction;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }

    public int getPos3() {
        return pos3;
    }

    public void setPos3(int pos3) {
        this.pos3 = pos3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ship ship = (Ship) o;
        return shipSize == ship.shipSize && shipHealth == ship.shipHealth && direction == ship.direction &&
                pos1 == ship.pos1 && pos2 == ship.pos2 && pos3 == ship.pos3 && Objects.equals(className, ship.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, shipSize, shipHealth, direction, pos1, pos2, pos3);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "className='" + className + '\'' +
                ", shipSize=" + shipSize +
                ", shipHealth=" + shipHealth +
                ", direction=" + direction +
                ", pos1=" + pos1 +
                ", pos2=" + pos2 +
                ", pos3=" + pos3 +
                '}';
    }
}
