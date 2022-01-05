package hu.nye.progtech.torpedo.configuration;

import hu.nye.progtech.torpedo.persistence.HighScoreRepository;
import hu.nye.progtech.torpedo.service.game.GameController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig.
 */

@Configuration
public class ApplicationConfiguration {

    /**
     * Elindítja a programot.
     */

    @Bean(initMethod = "start")
    public GameController gameController(HighScoreRepository highScoreRepository) {
        return new GameController(highScoreRepository);
    }
}
