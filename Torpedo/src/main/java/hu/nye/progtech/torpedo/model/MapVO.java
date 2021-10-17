package hu.nye.progtech.torpedo.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVO {

    private final int numberOfColumns;
    private final int numberOfRows;
    private final int[][] map;

    public MapVO(int numberOfColumns, int numberOfRows, int[][] map) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.map = deepCopy(map);
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int[][] getMap() {
        return deepCopy(this.map);
    }

    private int[][] deepCopy(int map[][]) {
        int[][] result = new int[map.length][];

        for (int i = 0; i < map.length; i++) {
            result[i] = new int[map[i].length];
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
                ", map=" + Arrays.toString(map) +
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
