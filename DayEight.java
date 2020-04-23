import javax.swing.JOptionPane;

public class DayEight {

    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    PlayerFour playerFour;


    DayEight(String playerOneName, int health1, int supplies1, int food1, int symptoms1, int money1, int x1, int y1, boolean infected1,
             String playerTwoName, int health2, int supplies2, int food2, int symptoms2, int money2, int x2, int y2, boolean infected2,
             String playerThreeName, int health3, int supplies3, int food3, int symptoms3, int money3, int x3, int y3, boolean infected3,
             String playerFourName, int health4, int supplies4, int food4, int symptoms4, int money4, int x4, int y4, boolean infected4){
        playerOne = new PlayerOne(playerOneName, health1, supplies1, food1, symptoms1, money1, x1, y1, infected1);
        playerTwo = new PlayerTwo(playerTwoName, health2, supplies2,food2,symptoms2,money2, x2, y2, infected2);
        playerThree = new PlayerThree(playerThreeName, health3, supplies3, food3, symptoms3, money3, x3, y3, infected3);
        playerFour = new PlayerFour(playerFourName, health4, supplies4, food4, symptoms4, money4, x4, y4, infected4);

    }

    DayNine daynine = new DayNine(playerOne.getPlayerOneName(), playerOne.getHealth(), playerOne.getSupplies(), playerOne.getFood(),
            playerOne.getSymptoms(), playerOne.getMoney(), playerOne.getX(), playerOne.getY(), playerOne.getInfected(),
            playerTwo.getPlayerTwoName(), playerTwo.getHealth(), playerTwo.getSupplies(), playerTwo.getFood(),
            playerTwo.getSymptoms(), playerTwo.getMoney(), playerTwo.getX(), playerTwo.getY(), playerTwo.getInfected(),
            playerThree.getPlayerThreeName(), playerThree.getHealth(), playerThree.getSupplies(), playerThree.getFood(),
            playerThree.getSymptoms(), playerThree.getMoney(), playerThree.getX(), playerThree.getY(), playerThree.getInfected(),
            playerFour.getPlayerFourName(), playerFour.getHealth(), playerFour.getSupplies(), playerFour.getFood(),
            playerFour.getSymptoms(), playerFour.getMoney(), playerFour.getX(), playerFour.getY(), playerFour.getInfected());



}