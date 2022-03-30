package learnProgramming.config;

import learnProgramming.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "learnProgramming")
@Configuration
@Import(GameConfig.class)
public class AppConfig {

        //=== bean methods ===
    @Bean
    public NumberGenerator numberGenerator(){
        return  new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return  new MessageGeneratorImpl();
    }


}
