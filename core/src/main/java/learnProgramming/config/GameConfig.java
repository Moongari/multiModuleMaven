package learnProgramming.config;

import learnProgramming.GuessCount;
import learnProgramming.MaxNumber;
import learnProgramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("file:C:\\Users\\moungamo\\IdeaProjects\\multiModuleProjectMaven\\core\\src\\main\\resources\\application.properties")
public class GameConfig {

    //== fields ==
    //=== define de default value : 20 ===
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    //=== define de default value : 5 ===
    @Value("${game.guessCount:5}")
    private int guessCount;
    @Value("${game.minNumber:5}")
    private int minNumber;



    //== beans methods==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }


}
