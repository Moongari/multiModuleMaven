package learnProgramming.console;

import learnProgramming.Game;
import learnProgramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    //== logger fields ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //== fields ==
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    //== events ==
    @EventListener(ContextRefreshedEvent.class)
    public void start(){
        log.info("start() --> container ready to use.");

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("play again y/n ?");

                String playAgainSgtring = scanner.nextLine().trim();
                if(!playAgainSgtring.equalsIgnoreCase("y")){
                    break;
                }
            }
            game.reset();
        }

    }

}
