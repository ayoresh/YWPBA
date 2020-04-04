/**
 * Class that will introduce story.
 * Sets player names and assigns characters
 */

import javax.swing.JOptionPane;

public class Introduction {

    PlayerOne playerOne = new PlayerOne();
    PlayerTwo playerTwo = new PlayerTwo();
    PlayerThree playerThree = new PlayerThree();
    PlayerFour playerFour = new PlayerFour();


    public void introductionText(){
        JOptionPane.showMessageDialog(null, "Here we will have the introduction text for the game. ");
        JOptionPane.showMessageDialog(null, "To put text on different pop-ups, copy and paste this line of code and change text in the quotation marks.");

        String playerOneName = JOptionPane.showInputDialog("What is the first player's name?");
        playerOne.setPlayerOneName(playerOneName);

        String playerTwoName = JOptionPane.showInputDialog("What is the second player's name?");
        playerTwo.setPlayerTwoName(playerTwoName);

        String playerThreeName = JOptionPane.showInputDialog("What is the third player's name?");
        playerThree.setPlayerThreeName(playerThreeName);

        String playerFourName = JOptionPane.showInputDialog("What is the fourth player's name?");
        playerFour.setPlayerFourName(playerFourName);

        JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + ", "
                + playerTwo.getPlayerTwoName() + ", " + playerThree.getPlayerThreeName() + ", and " + playerFour.getPlayerFourName() +
                ", your journey starts now.");

        DayOne dayOne = new DayOne(playerOne.getPlayerOneName(), playerTwo.getPlayerTwoName(), playerThree.getPlayerThreeName(), playerFour.getPlayerFourName());
        dayOne.dayOne();

    }



}
