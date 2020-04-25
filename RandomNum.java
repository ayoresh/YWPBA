import java.util.Random;



public class RandomNum {



    public int eventCardAmount = 30;


    public int coinFlip(){
        int coinFlip = (int) (Math.random() * 2) + 1;
        return coinFlip;
    }
    public int fourSidedDie(){
        int diceroll = (int) (Math.random() * 4) + 1;
        return  diceroll;
    }
    public int diceRoll(){
        int diceRoll = (int)(Math.random() * 6) + 1;
        return diceRoll;
    }
    public int outOfTen(){
        int outOfTenRoll = (int)(Math.random() * 9) + 1;
        return outOfTenRoll;
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
