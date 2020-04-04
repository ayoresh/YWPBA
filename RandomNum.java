import java.util.Random;



public class RandomNum {


    public int eventCardAmount = 30;
    /**
     * This method will roll a six-sided die and return a number.
     * @return
     */
    public int diceRoll(){
        int diceRoll = (int)(Math.random() * 6) + 1;
        return diceRoll;
    }

    /**
     * This method will choose a number between 1 and the amount of event cards in the game.
     * The returned number will correspond to an event card, which will go into effect.
     * @return
     */
    public int randomCard(){
        int cardNum = (int) ((Math.random() * eventCardAmount) + 1);
        return  cardNum;
    }


}
