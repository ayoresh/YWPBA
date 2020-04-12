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
    RandomNum rando = new RandomNum();


    public void introductionText(){
        JOptionPane.showMessageDialog(null, "Here we will have the introduction text for the game. ");
        JOptionPane.showMessageDialog(null, "To put text on different pop-ups, \ncopy and paste this line of code and change text in the quotation marks.");

        String playerOneName = JOptionPane.showInputDialog("What is the first player's name?");
        String playerTwoName = JOptionPane.showInputDialog("What is the second player's name?");
        String playerThreeName = JOptionPane.showInputDialog("What is the third player's name?");
        String playerFourName = JOptionPane.showInputDialog("What is the fourth player's name?");

        int teamRandomizer = rando.diceRoll();

        if (teamRandomizer == 1){
            playerOne.setPlayerOneName(playerOneName);
            playerTwo.setPlayerTwoName(playerTwoName);
            playerThree.setPlayerThreeName(playerThreeName);
            playerFour.setPlayerFourName(playerFourName);
        } else if (teamRandomizer == 2){
            playerOne.setPlayerOneName(playerOneName);
            playerTwo.setPlayerTwoName(playerThreeName);
            playerThree.setPlayerThreeName(playerTwoName);
            playerFour.setPlayerFourName(playerFourName);
        } else if (teamRandomizer == 3){
            playerOne.setPlayerOneName(playerOneName);
            playerTwo.setPlayerTwoName(playerFourName);
            playerThree.setPlayerThreeName(playerTwoName);
            playerFour.setPlayerFourName(playerThreeName);
        } else if (teamRandomizer == 4){
            playerOne.setPlayerOneName(playerThreeName);
            playerTwo.setPlayerTwoName(playerFourName);
            playerThree.setPlayerThreeName(playerOneName);
            playerFour.setPlayerFourName(playerTwoName);
        } else if (teamRandomizer == 5) {
            playerOne.setPlayerOneName(playerTwoName);
            playerTwo.setPlayerTwoName(playerFourName);
            playerThree.setPlayerThreeName(playerOneName);
            playerFour.setPlayerFourName(playerThreeName);
        } else if (teamRandomizer == 6){
            playerOne.setPlayerOneName(playerTwoName);
            playerTwo.setPlayerTwoName(playerThreeName);
            playerThree.setPlayerThreeName(playerOneName);
            playerFour.setPlayerFourName(playerFourName);
        }

        JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + ", "
                + playerTwo.getPlayerTwoName() + ", " + playerThree.getPlayerThreeName() + ", and " + playerFour.getPlayerFourName() +
                ", your journey starts now.");

        DayOne dayOne = new DayOne(playerOne.getPlayerOneName(), playerTwo.getPlayerTwoName(), playerThree.getPlayerThreeName(), playerFour.getPlayerFourName());
        dayOne.dayOne();

    }



}
