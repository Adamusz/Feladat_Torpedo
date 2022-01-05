package hu.nye.progtech.torpedo.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * MapVO.
 */

public class MapVO {

    private final int numberOfColumns;
    private final int numberOfRows;
    private final String[][] map;

    public MapVO(String[][] map) {
        this.numberOfColumns = 10;
        this.numberOfRows = 10;
        this.map = deepCopy(map);
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public String[][] getMap() {
        return deepCopy(this.map);
    }

    private String[][] deepCopy(String[][] map) {
        String[][] result = new String[map.length][];

        for (int i = 0; i < map.length; i++) {
            result[i] = new String[map[i].length];
            for (int j = 0; j < map[i].length; j++) {
                result[i][j] = map[i][j];
            }
        }

        return result;
    }


    @Override
    public String toString() {
        return "MapVO{" +
                "NumberOfColumns=" + numberOfColumns +
                ", NumberOfRows=" + numberOfRows +
                ", map=" + Arrays.deepToString(map) +
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
        MapVO mapVO = (MapVO) o;
        return numberOfColumns == mapVO.numberOfColumns && numberOfRows == mapVO.numberOfRows && Arrays.deepEquals(map, mapVO.map);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfColumns, numberOfRows);
        result = 31 * result + Arrays.deepHashCode(map);
        return result;
    }
}
