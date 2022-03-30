package learnProgramming.console;



import learnProgramming.AppConfig;
import learnProgramming.Game;
import learnProgramming.MessageGenerator;
import learnProgramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    // nous avons definit un nouveau context avec la classe AppConfig nous n'avons plus besoin de ca
    //private static final String CONFIG_LOCATION ="beans.xml";


    public static void main(String[] args) {

        log.info("Guess the number Game");

        //create the context (container)

        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //call method to get a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {} ",number);

        // get game from context(Container)
        Game game = context.getBean(Game.class);

        // call reset method
        game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());


        //close context container
        context.close();

    }
}
