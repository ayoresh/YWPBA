/**
 * This class will be the first day of the game.
 * After each turn,
 */

import javax.swing.JOptionPane;

public class DayOne {

    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    PlayerFour playerFour;


    DayOne(String playerOneName, String playerTwoName, String playerThreeName, String playerFourName){
        playerOne = new PlayerOne(playerOneName);
        playerTwo = new PlayerTwo(playerTwoName);
        playerThree = new PlayerThree(playerThreeName);
        playerFour = new PlayerFour(playerFourName);

    }

    public void dayOne(){

        JOptionPane.showMessageDialog(null, "Here is where the story for day one begins.");

    }

}
