import javax.swing.JOptionPane;

public class DayFour {

    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    PlayerFour playerFour;


    DayFour(String playerOneName, String playerTwoName, String playerThreeName, String playerFourName){
        playerOne = new PlayerOne(playerOneName);
        playerTwo = new PlayerTwo(playerTwoName);
        playerThree = new PlayerThree(playerThreeName);
        playerFour = new PlayerFour(playerFourName);

    }

}
