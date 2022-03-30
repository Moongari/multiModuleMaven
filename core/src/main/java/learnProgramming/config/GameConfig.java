package learnProgramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    //== fields ==

    private int maxNumber = 50;



    //== beans methods==
    @Bean
    public int maxNumber(){
        return maxNumber;
    }


}
