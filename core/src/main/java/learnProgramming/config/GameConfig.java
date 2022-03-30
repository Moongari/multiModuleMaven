package learnProgramming.config;

import learnProgramming.GuessCount;
import learnProgramming.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    //== fields ==

    private int maxNumber = 50;
    private int guessCount = 8;



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

}
