package hu.nye.progtech.torpedo.ui;

import java.util.ArrayList;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.model.ScoreVO;
import hu.nye.progtech.torpedo.persistence.HighScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Kiíratás.
 */
public class Printer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Printer.class);
    private static final String FIRST_LINE = "\t|\tA\t|\tB\t|\tC\t|\tD\t|\tE\t|\tF\t|\tG\t|\tH\t|\tI\t|\tJ\t|\n" +
            "-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-";
    private static final String SEPARATOR = "=";

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

    /**
     * Lövések Mapja és a saját hajók mapja kiíratása.
     */

    public void printMap(MapVO shootMap, MapVO mapVO) {
        LOGGER.info("Printing map to stdout");
        System.out.println();
        System.out.println(FIRST_LINE);
        for (int i = 0; i < shootMap.getNumberOfRows(); i++) {
            System.out.print(i + "\t|\t");
            for (int j = 0; j < shootMap.getNumberOfColumns(); j++) {
                System.out.print(shootMap.getMap()[i][j] + "\t|\t");
            }
            System.out.println();
            for (int j = 0; j < (shootMap.getNumberOfColumns() * 2) + 2; j++) {
                System.out.print("-\t");
            }
            System.out.println();
        }
        for (int i = 0; i < 85; i++) {
            System.out.print(SEPARATOR);
        }
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

    /**
     * Score tábla kiíratása.
     */

    public void printPlayerResults(HighScoreRepository highScoreRepository) {
        System.out.println("Name:\t|\tNumber of wins:");
        ArrayList<ScoreVO> scoreVOS = new ArrayList<>();
        scoreVOS = highScoreRepository.loadScore();
        for (ScoreVO scoreVo : scoreVOS) {
            System.out.println("----------------------------");
            System.out.println(scoreVo.getPlayerName() + "\t|\t" + scoreVo.getVictoryCount());
        }
        System.out.println("----------------------------");
    }
}

