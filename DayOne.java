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


        int p1h = 0, p2h = 0, p3h = 0, p4h = 0;

        RandomNum rando = new RandomNum();
        GameBoard game = new GameBoard();

        //Set home bases and tells each player where their home base is
        do{
            int x = rando.outOfTen();
            int y = rando.outOfTen();
            if(game.getGameboard(x,y) == 0){
                playerOne.setX(x);
                playerOne.setY(y);
                JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + ", you will begin at (" + x + ", " + y + ").");
                game.setGameboard(x, y, 12);
                p1h = 1;
            }
        }while(p1h == 0);
        do{
            int x = rando.outOfTen();
            int y = rando.outOfTen();
            if(game.getGameboard(x,y) == 0){
                playerTwo.setX(x);
                playerTwo.setY(y);
                JOptionPane.showMessageDialog(null, playerTwo.getPlayerTwoName() + ", you will begin at (" + x + ", " + y + ").");
                game.setGameboard(x, y, 12);
                p2h = 1;
            }
        }while(p2h == 0);
        do{
            int x = rando.outOfTen();
            int y = rando.outOfTen();
            if(game.getGameboard(x,y) == 0){
                playerThree.setX(x);
                playerThree.setY(y);
                JOptionPane.showMessageDialog(null, playerThree.getPlayerThreeName() + ", you will begin at (" + x + ", " + y + ").");
                game.setGameboard(x, y, 12);
                p3h = 1;
            }
        }while(p3h == 0);
        do{
            int x = rando.outOfTen();
            int y = rando.outOfTen();
            if(game.getGameboard(x,y) == 0){
                playerFour.setX(x);
                playerFour.setY(y);
                JOptionPane.showMessageDialog(null, playerFour.getPlayerFourName() + ", you will begin at (" + x + ", " + y + ").");
                game.setGameboard(x, y, 12);
                p4h = 1;
            }
        }while(p4h == 0);


        JOptionPane.showMessageDialog(null, "Here is where the story for day one begins.");

        for (int playerCounter = 0; playerCounter < 4; playerCounter++){

            int actionsMAx = 4;

            if (playerCounter == 0){
                JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + ", " +
                        "what action would you like to take?\nEnter 0 to work, ");
            }
        }




        DayTwo daytwo = new DayTwo(playerOne.getPlayerOneName(), playerOne.getHealth(), playerOne.getSupplies(), playerOne.getFood(),
                playerOne.getSymptoms(), playerOne.getMoney(), playerOne.getX(), playerOne.getY(), playerOne.getInfected(),
                playerTwo.getPlayerTwoName(), playerTwo.getHealth(), playerTwo.getSupplies(), playerTwo.getFood(),
                playerTwo.getSymptoms(), playerTwo.getMoney(), playerTwo.getX(), playerTwo.getY(), playerTwo.getInfected(),
                playerThree.getPlayerThreeName(), playerThree.getHealth(), playerThree.getSupplies(), playerThree.getFood(),
                playerThree.getSymptoms(), playerThree.getMoney(), playerThree.getX(), playerThree.getY(), playerThree.getInfected(),
                playerFour.getPlayerFourName(), playerFour.getHealth(), playerFour.getSupplies(), playerFour.getFood(),
                playerFour.getSymptoms(), playerFour.getMoney(), playerFour.getX(), playerFour.getY(), playerFour.getInfected());
    }




}
