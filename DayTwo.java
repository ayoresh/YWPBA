import javax.swing.JOptionPane;

public class DayTwo {

    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    PlayerFour playerFour;


    DayTwo(String playerOneName, String playerTwoName, String playerThreeName, String playerFourName){
        playerOne = new PlayerOne(playerOneName);
        playerTwo = new PlayerTwo(playerTwoName);
        playerThree = new PlayerThree(playerThreeName);
        playerFour = new PlayerFour(playerFourName);

    }

}
