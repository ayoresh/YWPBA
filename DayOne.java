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
    Actions actionobj = new Actions();


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

            int actionsMax = 5, actionsCounter1 = 1, actionsCounter2 = 1, actionsCounter3 = 1, actionsCounter4 = 1;

            if (playerCounter == 0){
                int playerLocale = game.getGameboard(playerOne.getX(), playerOne.getY());
                System.out.println(playerLocale);
                String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                        shopping = "\n3: shop for supplies or food";

                //Infected space?
                if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11){
                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                    playerOne.setSymptoms(playerOne.getSymptoms() + 1);
                }

                do {
                    //Check if player at a store
                    if(playerLocale == 6 || playerLocale == 7 || playerLocale == 9 ||playerLocale == 10) {
                        actionText += shopping;
                    }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerOne.getPlayerOneName() + ", " +
                                actionText +  "\nAction: "));


                    //Player shops at food store
                        if (action == 3 && playerLocale == 6){
                            int itemsBought = actionobj.foodShopping();
                            playerOne.setFood(playerOne.getFood() + itemsBought);
                            playerOne.setMoney(playerOne.getMoney() - (itemsBought * 2));
                            if (playerOne.getMoney() < 0){
                                JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                        "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                            }
                        }

                        //Player shops at supply store
                        else if(action == 3 && playerLocale == 10){
                            int itemsBought = actionobj.supplyShopping();
                            playerOne.setSupplies(playerOne.getSupplies() + itemsBought);
                            playerOne.setMoney(playerOne.getMoney() - (2 * itemsBought));
                            if (playerOne.getMoney() < 0){
                                JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                        "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                            }
                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 3 && playerLocale != 6 && playerLocale != 10){
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                            actionsCounter1--;
                        }

                        //Player works
                        else if (action == 0){
                            int moneyEarned = 0;
                            playerOne.setMoney(playerOne.getMoney() + moneyEarned);
                            playerOne.setSymptoms(playerOne.getSymptoms() + 1);
                            JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                            + "\nYou now have $" + playerOne.getMoney() + ". You gained one exposure.");
                        }

                        //Player gifts items to another player
                        else if (action == 1){
                            int gift = Integer.parseInt(JOptionPane.showInputDialog("What gift would you like to send? Enter: \n1: food\n2: supplies"));
                            while (gift != 1 && gift != 2){
                                gift = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. What gift would you like to send? Enter: \n1: food\n2: supplies"));
                            }
                            //food
                            if (gift == 1){
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send food to?" +
                                        "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4){
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send food to?" +
                                            "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerOne.getFood() + " pieces of food."));
                                while(amountSend < 0 || amountSend > playerOne.getFood()){
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerOne.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2){
                                    playerTwo.setFood(playerTwo.getFood() + amountSend);
                                } else if (whichPlayer == 3){
                                    playerThree.setFood(playerThree.getFood() + amountSend);
                                } else if (whichPlayer == 4){
                                    playerFour.setFood(playerFour.getFood() + amountSend);
                                }
                                JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                                playerOne.setFood(playerOne.getFood() - amountSend);
                            }
                            //supplies
                            else if (gift == 2){
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4){
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                            "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerOne.getSupplies() + " supplies."));
                                while(amountSend < 0 || amountSend > playerOne.getSupplies()){
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerOne.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2){
                                    playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                                } else if (whichPlayer == 3){
                                    playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                                } else if (whichPlayer == 4){
                                    playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                                }
                                playerOne.setSupplies(playerOne.getSupplies() - amountSend);
                            }
                        }
                        //quarantine area
                        else if (action == 2){
                            if (playerLocale > 3 || playerLocale < 12) {
                                JOptionPane.showMessageDialog(null, "Space cannot be quarantined. Please choose a different action.");
                                actionsCounter1--;
                            } else{
                                game.quarantineArea(playerOne.getX(), playerOne.getY());
                                JOptionPane.showMessageDialog(null, "Space (" + playerOne.getX() + "," + playerOne.getY() + ") is now quarantined and cannot become infected.");
                            }
                        }


                    actionsCounter1++;
                } while (actionsCounter1 < actionsMax);
            }
            if (playerCounter == 1) {
                int playerLocale = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                System.out.println(playerLocale);
                String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                        shopping = "\n3: shop for supplies or food";

                //Infected space?
                if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11) {
                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                    playerTwo.setSymptoms(playerTwo.getSymptoms() + 1);
                }

                do {
                    //Check if player at a store
                    if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                        actionText += shopping;
                    }
                    int action = Integer.parseInt(JOptionPane.showInputDialog(playerTwo.getPlayerTwoName() + ", " +
                            actionText + "\nAction: "));


                    //Player shops at food store
                    if (action == 3 && playerLocale == 6) {
                        int itemsBought = actionobj.foodShopping();
                        playerTwo.setFood(playerTwo.getFood() + itemsBought);
                        playerTwo.setMoney(playerTwo.getMoney() - (itemsBought * 2));
                        if (playerTwo.getMoney() < 0) {
                            JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                    "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                        }
                    }

                    //Player shops at supply store
                    else if (action == 3 && playerLocale == 10) {
                        int itemsBought = actionobj.supplyShopping();
                        playerTwo.setSupplies(playerTwo.getSupplies() + itemsBought);
                        playerTwo.setMoney(playerTwo.getMoney() - (2 * itemsBought));
                        if (playerTwo.getMoney() < 0) {
                            JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                    "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                        }
                    }

                    //Player attempts to shop, but is not on a space that contains a store
                    else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                        JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                "\nPlease enter a valid action.");
                        actionsCounter2--;
                    }

                    //Player works
                    else if (action == 0) {
                        int moneyEarned = 0;
                        playerTwo.setMoney(playerTwo.getMoney() + moneyEarned);
                        playerTwo.setSymptoms(playerTwo.getSymptoms() + 1);
                        JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                + "\nYou now have $" + playerTwo.getMoney() + ". You gained one exposure.");
                    }

                    //Player gifts items to another player
                    else if (action == 1) {
                        int gift = Integer.parseInt(JOptionPane.showInputDialog("What gift would you like to send? Enter: \n1: food\n2: supplies"));
                        while (gift != 1 && gift != 2) {
                            gift = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. What gift would you like to send? Enter: \n1: food\n2: supplies"));
                        }
                        //food
                        if (gift == 1) {
                            int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send food to?" +
                                    "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                            while (whichPlayer < 2 || whichPlayer > 4) {
                                whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send food to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                            }
                            int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerTwo.getFood() + " pieces of food."));
                            while (amountSend < 0 || amountSend > playerTwo.getFood()) {
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerTwo.getFood()
                                        + "."));
                            }
                            if (whichPlayer == 2) {
                                playerOne.setFood(playerOne.getFood() + amountSend);
                            } else if (whichPlayer == 3) {
                                playerThree.setFood(playerThree.getFood() + amountSend);
                            } else if (whichPlayer == 4) {
                                playerFour.setFood(playerFour.getFood() + amountSend);
                            }
                            JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                            playerTwo.setFood(playerTwo.getFood() - amountSend);
                        }

                        //supplies
                        else if (gift == 2) {
                            int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                    "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                            while (whichPlayer < 2 || whichPlayer > 4) {
                                whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                            }
                            int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerTwo.getSupplies() + " supplies."));
                            while (amountSend < 0 || amountSend > playerTwo.getSupplies()) {
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerTwo.getSupplies()
                                        + "."));
                            }
                            if (whichPlayer == 2) {
                                playerOne.setSupplies(playerTwo.getSupplies() + amountSend);
                            } else if (whichPlayer == 3) {
                                playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                            } else if (whichPlayer == 4) {
                                playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                            }
                            playerTwo.setSupplies(playerTwo.getSupplies() - amountSend);
                        }
                    }

                    //quarantine area
                    else if (action == 2) {
                        if (playerLocale > 3 || playerLocale < 12) {
                            JOptionPane.showMessageDialog(null, "Space cannot be quarantined. Please choose a different action.");
                            actionsCounter2--;
                        } else {
                            game.quarantineArea(playerTwo.getX(), playerTwo.getY());
                            JOptionPane.showMessageDialog(null, "Space (" + playerTwo.getX() + "," + playerTwo.getY() + ") is now quarantined and cannot become infected.");
                        }
                    }


                    actionsCounter2++;
                } while (actionsCounter2 < actionsMax);
            }



                if (playerCounter == 2) {
                    int playerLocale = game.getGameboard(playerThree.getX(), playerThree.getY());
                    System.out.println(playerLocale);
                    String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                            shopping = "\n3: shop for supplies or food";

                    //Infected space?
                    if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11) {
                        JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                        playerThree.setSymptoms(playerThree.getSymptoms() + 1);
                    }

                    do {
                        //Check if player at a store
                        if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerThree.getPlayerThreeName() + ", " +
                                actionText + "\nAction: "));


                        //Player shops at food store
                        if (action == 3 && playerLocale == 6) {
                            int itemsBought = actionobj.foodShopping();
                            playerThree.setFood(playerThree.getFood() + itemsBought);
                            playerThree.setMoney(playerThree.getMoney() - (itemsBought * 2));
                            if (playerThree.getMoney() < 0) {
                                JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                        "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                            }
                        }

                        //Player shops at supply store
                        else if (action == 3 && playerLocale == 10) {
                            int itemsBought = actionobj.supplyShopping();
                            playerThree.setSupplies(playerThree.getSupplies() + itemsBought);
                            playerThree.setMoney(playerThree.getMoney() - (2 * itemsBought));
                            if (playerThree.getMoney() < 0) {
                                JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                        "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                            }
                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                            actionsCounter3--;
                        }

                        //Player works
                        else if (action == 0) {
                            int moneyEarned = 0;
                            playerThree.setMoney(playerThree.getMoney() + moneyEarned);
                            playerThree.setSymptoms(playerThree.getSymptoms() + 1);
                            JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                    + "\nYou now have $" + playerThree.getMoney() + ". You gained one exposure.");
                        }

                        //Player gifts items to another player
                        else if (action == 1) {
                            int gift = Integer.parseInt(JOptionPane.showInputDialog("What gift would you like to send? Enter: \n1: food\n2: supplies"));
                            while (gift != 1 && gift != 2) {
                                gift = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. What gift would you like to send? Enter: \n1: food\n2: supplies"));
                            }
                            //food
                            if (gift == 1) {
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send food to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send food to?" +
                                            "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerThree.getFood() + " pieces of food."));
                                while (amountSend < 0 || amountSend > playerThree.getFood()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerThree.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setFood(playerOne.getFood() + amountSend);
                                } else if (whichPlayer == 3) {
                                    playerTwo.setFood(playerTwo.getFood() + amountSend);
                                } else if (whichPlayer == 4) {
                                    playerFour.setFood(playerFour.getFood() + amountSend);
                                }
                                JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                                playerThree.setFood(playerThree.getFood() - amountSend);
                            }

                            //supplies
                            else if (gift == 2) {
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                            "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerThree.getSupplies() + " supplies."));
                                while (amountSend < 0 || amountSend > playerThree.getSupplies()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerThree.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setSupplies(playerOne.getSupplies() + amountSend);
                                } else if (whichPlayer == 3) {
                                    playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                                } else if (whichPlayer == 4) {
                                    playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                                }
                                playerThree.setSupplies(playerThree.getSupplies() - amountSend);
                            }
                        }

                        //quarantine area
                        else if (action == 2) {
                            if (playerLocale > 3 || playerLocale < 12) {
                                JOptionPane.showMessageDialog(null, "Space cannot be quarantined. Please choose a different action.");
                                actionsCounter3--;
                            } else {
                                game.quarantineArea(playerThree.getX(), playerThree.getY());
                                JOptionPane.showMessageDialog(null, "Space (" + playerThree.getX() + "," + playerThree.getY() + ") is now quarantined and cannot become infected.");
                            }
                        }
                        actionsCounter3++;
                    } while (actionsCounter3 < actionsMax);
                }


            if (playerCounter == 3) {
                int playerLocale = game.getGameboard(playerFour.getX(), playerFour.getY());
                System.out.println(playerLocale);
                String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                        shopping = "\n3: shop for supplies or food";

                //Infected space?
                if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11) {
                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                    playerFour.setSymptoms(playerFour.getSymptoms() + 1);
                }

                do {
                    //Check if player at a store
                    if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                        actionText += shopping;
                    }
                    int action = Integer.parseInt(JOptionPane.showInputDialog(playerFour.getPlayerFourName() + ", " +
                            actionText + "\nAction: "));

                    //Player shops at food store
                    if (action == 3 && playerLocale == 6) {
                        int itemsBought = actionobj.foodShopping();
                        playerFour.setFood(playerFour.getFood() + itemsBought);
                        playerFour.setMoney(playerFour.getMoney() - (itemsBought * 2));
                        if (playerFour.getMoney() < 0) {
                            JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                    "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                        }
                    }
                    //Player shops at supply store
                    else if (action == 3 && playerLocale == 10) {
                        int itemsBought = actionobj.supplyShopping();
                        playerFour.setSupplies(playerThree.getSupplies() + itemsBought);
                        playerFour.setMoney(playerThree.getMoney() - (2 * itemsBought));
                        if (playerFour.getMoney() < 0) {
                            JOptionPane.showMessageDialog(null, "You are now in debt. " +
                                    "\nIf you do not earn more money before the end of the game, you will face severe consequences.");
                        }
                    }

                    //Player attempts to shop, but is not on a space that contains a store
                    else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                        JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                "\nPlease enter a valid action.");
                        actionsCounter4--;
                    }
                    //Player works
                    else if (action == 0) {
                        int moneyEarned = 0;
                        playerFour.setMoney(playerFour.getMoney() + moneyEarned);
                        playerFour.setSymptoms(playerFour.getSymptoms() + 1);
                        JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                + "\nYou now have $" + playerFour.getMoney() + ". You gained one exposure.");
                    }

                    //Player gifts items to another player
                    else if (action == 1) {
                        int gift = Integer.parseInt(JOptionPane.showInputDialog("What gift would you like to send? Enter: \n1: food\n2: supplies"));
                        while (gift != 1 && gift != 2) {
                            gift = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. What gift would you like to send? Enter: \n1: food\n2: supplies"));
                        }
                        //food
                        if (gift == 1) {
                            int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send food to?" +
                                    "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerThree.getPlayerThreeName()));
                            while (whichPlayer < 2 || whichPlayer > 4) {
                                whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send food to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerThree.getPlayerThreeName()));
                            }
                            int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerFour.getFood() + " pieces of food."));
                            while (amountSend < 0 || amountSend > playerFour.getFood()) {
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerFour.getFood()
                                        + "."));
                            }
                            if (whichPlayer == 2) {
                                playerOne.setFood(playerOne.getFood() + amountSend);
                            } else if (whichPlayer == 3) {
                                playerTwo.setFood(playerTwo.getFood() + amountSend);
                            } else if (whichPlayer == 4) {
                                playerThree.setFood(playerThree.getFood() + amountSend);
                            }
                            JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                            playerFour.setFood(playerFour.getFood() - amountSend);
                        }
                        //supplies
                        else if (gift == 2) {
                            int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                    "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerThree.getPlayerThreeName()));
                            while (whichPlayer < 2 || whichPlayer > 4) {
                                whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerThree.getPlayerThreeName()));
                            }
                            int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerFour.getSupplies() + " supplies."));
                            while (amountSend < 0 || amountSend > playerThree.getSupplies()) {
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerFour.getSupplies()
                                        + "."));
                            }
                            if (whichPlayer == 2) {
                                playerOne.setSupplies(playerTwo.getSupplies() + amountSend);
                            } else if (whichPlayer == 3) {
                                playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                            } else if (whichPlayer == 4) {
                                playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                            }
                            playerFour.setSupplies(playerFour.getSupplies() - amountSend);
                        }
                    }
                    //quarantine area
                    else if (action == 2) {
                        if (playerLocale > 3 || playerLocale < 12) {
                            JOptionPane.showMessageDialog(null, "Space cannot be quarantined. Please choose a different action.");
                            actionsCounter4--;
                        } else {
                            game.quarantineArea(playerFour.getX(), playerFour.getY());
                            JOptionPane.showMessageDialog(null, "Space (" + playerFour.getX() + "," + playerFour.getY() + ") is now quarantined and cannot become infected.");
                        }
                    }
                    actionsCounter4++;
                } while (actionsCounter4 < actionsMax);
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
