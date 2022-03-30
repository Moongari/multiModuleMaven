package learnProgramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "learnProgramming")
@Configuration
public class AppConfig {

        //=== bean methods ===
    @Bean
    public  NumberGenerator numberGenerator(){
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
