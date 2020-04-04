//This is the main game file. It will initiate the game and call methods/functions to progress the game.


public class Main {

    public static void main(String[] args){

        RandomNum obj = new RandomNum();

        System.out.println("To test the dice roller, roll now.");
        System.out.println(obj.diceRoll());


        System.out.println("Testing the card number generator...");
        System.out.println(obj.randomCard());







    }

}
