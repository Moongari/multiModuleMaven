package learnProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{


    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ===
    @Autowired
    private Game game;
    private int guessCount = 10;

    // == init method ==
    @PostConstruct
    public void init(){
        log.info("Authowired game {}",game);

    }


    //=== public methods ====
    @Override
    public String getMainMessage() {
        return "Number between " +
                game.getSmallest() +
                 " and " +
                game.getBiggest() +
                " can you guest it ?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "you guessed it the number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "you lost the number was " + game.getNumber();
        }else if(!game.isValidNumberRange()){
            return "invalid number range";
        }else if(game.getRemainingGuesses() == guessCount){
            return "what is your first guess ?";
        }else{
            String direction ="Lower";
            if(game.getGuess() < game.getNumber()){
                direction = "higher";
            }
            return direction + "! you have "+ game.getRemainingGuesses() + "guess left";
        }

    }
}
