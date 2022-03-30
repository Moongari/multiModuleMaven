package learnProgramming;

public interface Game {


    int getNumber();
    int getGuess();
    void setGuess(int guest);
    int getSmallest();
    int getBiggest();
    int getRemainingGuesses();

    void reset();
    void check();
    boolean isValidNumberRange();
    boolean isGameWon();

    boolean isGameLost();


}
