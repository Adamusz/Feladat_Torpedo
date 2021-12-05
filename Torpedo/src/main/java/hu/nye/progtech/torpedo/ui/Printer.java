package hu.nye.progtech.torpedo.ui;

import hu.nye.progtech.torpedo.model.MapVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Kiíratás.
 */
public class Printer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);
    private static final String FIRST_LINE = "\t|\tA\t|\tB\t|\tC\t|\tD\t|\tE\t|\tF\t|\tG\t|\tH\t|\tI\t|\tJ\t|\n" +
            "-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-";

    /**
     * Map kiíratása.
     */
    public void printMap(MapVO mapVO) {
        LOGGER.info("Printing map to stdout");
        System.out.println();

        System.out.println(FIRST_LINE);
        for (int i = 0; i < mapVO.getNumberOfRows(); i++) {
            System.out.print(i + "\t|\t");
            for (int j = 0; j < mapVO.getNumberOfColumns(); j++) {
                System.out.print(mapVO.getMap()[i][j] + "\t|\t");
            }
            System.out.println();
            for (int j = 0; j < (mapVO.getNumberOfColumns() * 2) + 2; j++) {
                System.out.print("-\t");
            }
            System.out.println();
        }
    }

    public void printPlayerResults() {
        //TODO
    }
}

