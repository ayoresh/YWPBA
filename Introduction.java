/**
 * Class that will introduce story.
 * Sets player names and assigns characters
 */

import javax.swing.*;


public class Introduction {

    PlayerOne playerOne = new PlayerOne();
    PlayerTwo playerTwo = new PlayerTwo();
    PlayerThree playerThree = new PlayerThree();
    PlayerFour playerFour = new PlayerFour();
    RandomNum rando = new RandomNum();


    public void introductionText(){
        ImageIcon splash = new ImageIcon("SplashScreen.png");
        JOptionPane.showMessageDialog(null,"","You Will (Probably) Be Alright", JOptionPane.INFORMATION_MESSAGE, splash);
        JOptionPane.showMessageDialog(null, "COVID-19 has been the name on everyone's mind the past few months. \n" +
                "Everything went wrong when people began working from home.\n" +
                "Everyone began going stir crazy in their homes, and when they went outdoors, all public decency was lost.\n" +
                "Finding essential supplies has been more difficult than ever before. The government has begun a mandatory two-week long quarantine.\n" +
                "People may only leave their homes for essential reasons. There is no way of knowing where the virus has been, and where it hasn't.... yet.");
        JOptionPane.showMessageDialog(null,"But don't worry, you will (probably) be alright.");

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



        JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + " and " + playerTwo.getPlayerTwoName() + "" +
                " are emotionally connected. If either perish during this game, neither will win.");
        JOptionPane.showMessageDialog(null, playerThree.getPlayerThreeName() + " and " + playerFour.getPlayerFourName() + "" +
                " are emotionally connected. If either perish during this game, neither will win.");
        int initialEvent = rando.fourSidedDie();
        int initialEvent2 = rando.fourSidedDie();
        String initialeventtext = "", initialeventtext2 = "";
        if (initialEvent == 1){
            initialeventtext = " the governor declared a state of emergency";
        } else if (initialEvent == 2){
            initialeventtext = " the first confirmed case was announced";
        } else if (initialEvent == 3){
            initialeventtext = "the stock market took a nose dive";
        } else if (initialEvent == 4){
            initialeventtext = "the conspiracy theorists started arming themselves and protesting at the state capital";
        }
        if (initialEvent2 == 1){
            initialeventtext2 = "They could not find their vector of infection";
        } else if (initialEvent2 == 2){
            initialeventtext2 = "They were a local priest had given dozens Communion";
        } else if (initialEvent2 == 3){
            initialeventtext2 = "They worked in a retirement home that housed hundreds of immunocompromised patients";
        } else if (initialEvent2 == 4){
            initialeventtext2 = "They worked at a local airport where they could transmit it to people travelling all over the globe";
        }
        int introtext = rando.coinFlip();


        if (introtext == 1) {
            JOptionPane.showMessageDialog(null, "As of yesterday, life had gone on pretty much as usual. \nSome people had started wearing masks or gloves" +
                    ", hand sanitizer also seemed to be in high demand, but few were alarmed by the news of the rapidly spreading virus, COVID-19. \nThat was until " + initialeventtext + "." +
                    " Now people were scared. People flocked to grocery stores and pharmacies to stock up on essentials, even if they had to fight for them. \nIt seemed like those" +
                    " stocking up were either ahead of the curve... or setting a worrying trend.");
        }

        else if (introtext == 2){
            JOptionPane.showMessageDialog(null, "Your family was distantly worried about the spread of COVID-19, but so far it had been half a world away. " +
                    "\nExcept for cruise ships. And major metropolitan hospitals. And a few nursing homes. Soon enough there was an infected visitor in your city. \nWorse yet: " + initialeventtext2 +
                    ". Soon after, " + initialeventtext + ". \nThe pandemic had arrived on your doorstep.");
        }

        GameBoard startBoard = new GameBoard();
        startBoard.setGameboard(2,2,13);
        startBoard.setGameboard(7,2,13);
        startBoard.setGameboard(2,7,13);
        startBoard.setGameboard(7,7,13);
        startBoard.initialInfectionAndSetStores();

        DayOne dayOne = new DayOne(playerOne.getPlayerOneName(), playerTwo.getPlayerTwoName(), playerThree.getPlayerThreeName(), playerFour.getPlayerFourName(), startBoard.getGameboardArray());
        dayOne.dayOne();

    }



}
