package hu.nye.progtech.torpedo.model;

import java.util.Objects;

import hu.nye.progtech.torpedo.service.input.InputReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hajók.
 * */

public class ShipClasses {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShipClasses.class);
    private final String className;
    private final int shipSize;

    public ShipClasses(String className, int shipSize) {
        this.className = className;
        this.shipSize = shipSize;
    }

    public String getClassName() {
        return className;
    }

    public int getShipSize() {
        return shipSize;
    }

    @Override
    public String toString() {
        return "ShipClasses{" +
                "ClassName='" + className + '\'' +
                ", shipSize=" + shipSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShipClasses that = (ShipClasses) o;
        return shipSize == that.shipSize && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, shipSize);
    }
}
