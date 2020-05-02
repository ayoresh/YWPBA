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
    RandomNum rando = new RandomNum();
    GameBoard game = new GameBoard();
    Events eventTime = new Events();


    DayOne(String playerOneName, String playerTwoName, String playerThreeName, String playerFourName){
        playerOne = new PlayerOne(playerOneName);
        playerTwo = new PlayerTwo(playerTwoName);
        playerThree = new PlayerThree(playerThreeName);
        playerFour = new PlayerFour(playerFourName);

    }

    public void dayOne(){

        //Used to set players' beginning spaces
        int p1h = 0, p2h = 0, p3h = 0, p4h = 0;
        //Exposure counters
        int e1 = 0, e2 = 0, e3 = 0, e4 = 0;

        boolean eventHappened = true;


        //Set home bases and tells each player where their home base is
        do{
            int x = rando.outOfTen();
            int y = rando.outOfTen();
            if(game.getGameboard(x,y) == 0){
                playerOne.setX(x);
                playerOne.setY(y);
                JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + ", you will begin at (" + x + ", " + y + ").");
                game.setGameboard(x, y, 13);
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
                game.setGameboard(x, y, 13);
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
                game.setGameboard(x, y, 13);
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
                game.setGameboard(x, y, 13);
                p4h = 1;
            }
        }while(p4h == 0);


        JOptionPane.showMessageDialog(null, "Here is where the story for day one begins.");

        for (int playerCounter = 0; playerCounter < 4; playerCounter++){

            int turnsMax = 5, turns1 = 1, turns2 = 1, turns3 = 1, turns4 = 1, actionPoints1 = 0,
                                        actionPoints2 = 0, actionPoints3 = 0, actionPoints4 = 0, actionPointsMax = 4;

            if (playerCounter == 0 && playerOne.getHealth() != 0){
                int playerLocale = game.getGameboard(playerOne.getX(), playerOne.getY());
                System.out.println(playerLocale);
                String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                        shopping = "\n3: shop for supplies or food";

                //Infected space?
                if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11){
                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                    e1++;
                }

                do {
                    actionPoints1 = 0;
                    while (actionPoints1 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerOne.getPlayerOneName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints1));


                        //Player shops at food store
                        if (action == 3 && playerLocale == 6) {
                            if(actionPoints1 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.foodShopping();
                                int itemsBoughtChecker = playerOne.getMoney() - (itemsBought * 2);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                            " Please buy an amount of food that you can afford.");
                                    itemsBought = actionobj.foodShopping();
                                    itemsBoughtChecker = playerOne.getMoney() - (itemsBought * 2);
                                }
                                playerOne.setFood(playerOne.getFood() + itemsBought);
                                playerOne.setMoney(playerOne.getMoney() - (itemsBought * 2));
                                actionPoints1 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if (action == 3 && playerLocale == 10) {
                            if(actionPoints1 + 4 <= actionPointsMax){
                            int itemsBought = actionobj.supplyShopping();
                            int itemsBoughtChecker = playerOne.getMoney() - (itemsBought * 2);
                            while(itemsBoughtChecker < 0){
                                JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                        "Please buy an amount of supplies you can afford.");
                                itemsBought = actionobj.supplyShopping();
                                itemsBoughtChecker = playerOne.getMoney() - (itemsBought * 2);
                            }
                            playerOne.setSupplies(playerOne.getSupplies() + itemsBought);
                            playerOne.setMoney(playerOne.getMoney() - (2 * itemsBought));
                            actionPoints1 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }

                        //Player works
                        else if (action == 0) {
                            if(actionPoints1 + 4 <= actionPointsMax){
                            int moneyEarned = 4;
                            playerOne.setMoney(playerOne.getMoney() + moneyEarned);
                            e1++;
                            JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                    + "\nYou now have $" + playerOne.getMoney() + ". You gained one exposure.");
                            actionPoints1 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
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
                                        "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send food to?" +
                                            "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerOne.getFood() + " pieces of food."));
                                while (amountSend < 0 || amountSend > playerOne.getFood()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerOne.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerTwo.setFood(playerTwo.getFood() + amountSend);
                                } else if (whichPlayer == 3) {
                                    playerThree.setFood(playerThree.getFood() + amountSend);
                                } else if (whichPlayer == 4) {
                                    playerFour.setFood(playerFour.getFood() + amountSend);
                                }
                                JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                                playerOne.setFood(playerOne.getFood() - amountSend);
                            }
                            //supplies
                            else if (gift == 2) {
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                            "Enter:+\n2: " + playerTwo.getPlayerTwoName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                int amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerOne.getSupplies() + " supplies."));
                                while (amountSend < 0 || amountSend > playerOne.getSupplies()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerOne.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                                } else if (whichPlayer == 3) {
                                    playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                                } else if (whichPlayer == 4) {
                                    playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                                }
                                playerOne.setSupplies(playerOne.getSupplies() - amountSend);

                            }
                            actionPoints1++;
                        }
                        //quarantine area
                        else if (action == 2) {
                            game.quarantineArea(playerOne.getX(), playerOne.getY());
                            JOptionPane.showMessageDialog(null, "Space (" + playerOne.getX() + "," + playerOne.getY() + ") is now quarantined and cannot become infected.");

                        }

                    }

                    turns1++;
                } while (turns1 < turnsMax);
            }
            if (playerCounter == 1 && playerTwo.getHealth() != 0) {
                int playerLocale = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                System.out.println(playerLocale);
                String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                        shopping = "\n3: shop for supplies or food";

                //Infected space?
                if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11) {
                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                    e2++;
                }


                do {
                    actionPoints2 = 0;
                    while(actionPoints2 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerTwo.getPlayerTwoName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints2));


                        //Player shops at food store
                        if (action == 3 && playerLocale == 6) {
                            if(actionPoints2 + 4 <= actionPointsMax){
                            int itemsBought = actionobj.foodShopping();
                            int itemsBoughtChecker = playerTwo.getMoney() - (itemsBought * 2);
                            while (itemsBoughtChecker < 0) {
                                JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                        " Please buy an amount of food that you can afford.");
                                itemsBought = actionobj.foodShopping();
                                itemsBoughtChecker = playerTwo.getMoney() - (itemsBought * 2);
                            }
                            playerTwo.setFood(playerTwo.getFood() + itemsBought);
                            playerTwo.setMoney(playerTwo.getMoney() - (itemsBought * 2));
                            actionPoints2 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if (action == 3 && playerLocale == 10) {
                            if(actionPoints2 + 4 < actionPointsMax){
                            int itemsBought = actionobj.supplyShopping();
                            int itemsBoughtChecker = playerTwo.getMoney() - (itemsBought * 2);
                            while (itemsBoughtChecker < 0) {
                                JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                        "Please buy an amount of supplies you can afford.");
                                itemsBought = actionobj.supplyShopping();
                                itemsBoughtChecker = playerTwo.getMoney() - (itemsBought * 2);
                            }
                            playerTwo.setSupplies(playerTwo.getSupplies() + itemsBought);
                            playerTwo.setMoney(playerTwo.getMoney() - (2 * itemsBought));
                            actionPoints2 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }

                        //Player works
                        else if (action == 0) {
                            if(actionPoints2 + 4 <= actionPointsMax){
                            int moneyEarned = 4;
                            playerTwo.setMoney(playerTwo.getMoney() + moneyEarned);
                            e2++;
                            JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                    + "\nYou now have $" + playerTwo.getMoney() + ". You gained one exposure.");
                            actionPoints2 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
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
                            actionPoints2++;
                        }

                        //quarantine area
                        else if (action == 2) {
                            game.quarantineArea(playerTwo.getX(), playerTwo.getY());
                            JOptionPane.showMessageDialog(null, "Space (" + playerTwo.getX() + "," + playerTwo.getY() + ") is now quarantined and cannot become infected.");
                        }
                    }
                    turns2++;

                } while (turns2 < turnsMax);
            }



                if (playerCounter == 2 && playerThree.getHealth() != 0) {
                    int playerLocale = game.getGameboard(playerThree.getX(), playerThree.getY());
                    System.out.println(playerLocale);
                    String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                            shopping = "\n3: shop for supplies or food";

                    //Infected space?
                    if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11) {
                        JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                        e3++;
                    }

                    do {
                        actionPoints3 = 0;
                        while(actionPoints3 < actionPointsMax) {
                            //Check if player at a store
                            if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                                actionText += shopping;
                            }
                            int action = Integer.parseInt(JOptionPane.showInputDialog(playerThree.getPlayerThreeName() + ", " +
                                    actionText + "\nAction Points Used: " + actionPoints3));


                            //Player shops at food store
                            if (action == 3 && playerLocale == 6) {
                                if(actionPoints3 + 4 <= actionPointsMax){
                                int itemsBought = actionobj.foodShopping();
                                int itemsBoughtChecker = playerThree.getMoney() - (itemsBought * 2);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                            " Please buy an amount of food that you can afford.");
                                    itemsBought = actionobj.foodShopping();
                                    itemsBoughtChecker = playerThree.getMoney() - (itemsBought * 2);
                                }
                                playerThree.setFood(playerThree.getFood() + itemsBought);
                                playerThree.setMoney(playerThree.getMoney() - (itemsBought * 2));
                                actionPoints3 += 4;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }
                            }

                            //Player shops at supply store
                            else if (action == 3 && playerLocale == 10) {
                                if(actionPoints3 + 4 <= actionPointsMax){
                                int itemsBought = actionobj.supplyShopping();
                                int itemsBoughtChecker = playerThree.getMoney() - (itemsBought * 2);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                            "Please buy an amount of supplies you can afford.");
                                    itemsBought = actionobj.supplyShopping();
                                    itemsBoughtChecker = playerThree.getMoney() - (itemsBought * 2);
                                }
                                playerThree.setSupplies(playerThree.getSupplies() + itemsBought);
                                playerThree.setMoney(playerThree.getMoney() - (2 * itemsBought));
                                actionPoints3 += 4;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }

                            }

                            //Player attempts to shop, but is not on a space that contains a store
                            else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                                JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                        "\nPlease enter a valid action.");
                            }

                            //Player works
                            else if (action == 0) {
                                if(actionPoints3 + 4 < actionPointsMax){
                                int moneyEarned = 4;
                                playerThree.setMoney(playerThree.getMoney() + moneyEarned);
                                e3++;
                                JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                        + "\nYou now have $" + playerThree.getMoney() + ". You gained one exposure.");
                                actionPoints3 += 4;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }
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
                                actionPoints3++;
                            }

                            //quarantine area
                            else if (action == 2) {
                                game.quarantineArea(playerThree.getX(), playerThree.getY());
                                JOptionPane.showMessageDialog(null, "Space (" + playerThree.getX() + "," + playerThree.getY() + ") is now quarantined and cannot become infected.");
                            }
                        }
                        turns3++;
                    } while (turns3 < turnsMax);
                }


            if (playerCounter == 3 && playerFour.getHealth() != 0) {
                int playerLocale = game.getGameboard(playerFour.getX(), playerFour.getY());
                System.out.println(playerLocale);
                String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area",
                        shopping = "\n3: shop for supplies or food";

                //Infected space?
                if (playerLocale == 3 || playerLocale == 7 || playerLocale == 11) {
                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                    e4++;
                }

                do {
                    actionPoints4 = 0;
                    while(actionPoints4 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 6 || playerLocale == 7 || playerLocale == 9 || playerLocale == 10) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerFour.getPlayerFourName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints4));

                        //Player shops at food store
                        if (action == 3 && playerLocale == 6) {
                            if(actionPoints4 + 4 <= actionPointsMax){
                            int itemsBought = actionobj.foodShopping();
                            int itemsBoughtChecker = playerFour.getMoney() - (itemsBought * 2);
                            while (itemsBoughtChecker < 0) {
                                JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                        " Please buy an amount of food that you can afford.");
                                itemsBought = actionobj.foodShopping();
                                itemsBoughtChecker = playerFour.getMoney() - (itemsBought * 2);
                            }
                            playerFour.setFood(playerFour.getFood() + itemsBought);
                            playerFour.setMoney(playerFour.getMoney() - (itemsBought * 2));
                            actionPoints4 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if (action == 3 && playerLocale == 10) {
                            if(actionPoints4 + 4 <= actionPointsMax){
                            int itemsBought = actionobj.supplyShopping();
                            int itemsBoughtChecker = playerFour.getMoney() - (itemsBought * 2);
                            while (itemsBoughtChecker < 0) {
                                JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                        "Please buy an amount of supplies you can afford.");
                                itemsBought = actionobj.supplyShopping();
                                itemsBoughtChecker = playerFour.getMoney() - (itemsBought * 2);
                            }
                            playerFour.setSupplies(playerFour.getSupplies() + itemsBought);
                            playerFour.setMoney(playerFour.getMoney() - (2 * itemsBought));
                            actionPoints4 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 3 && playerLocale != 6 && playerLocale != 10) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }
                        //Player works
                        else if (action == 0) {
                            if(actionPoints4 + 4 < actionPointsMax){
                            int moneyEarned = 4;
                            playerFour.setMoney(playerFour.getMoney() + moneyEarned);
                            e4++;
                            JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                    + "\nYou now have $" + playerFour.getMoney() + ". You gained one exposure.");
                            actionPoints4 += 4;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
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
                                actionPoints4++;
                            }
                        }
                        //quarantine area
                        else if (action == 2) {
                            game.quarantineArea(playerFour.getX(), playerFour.getY());
                            JOptionPane.showMessageDialog(null, "Space (" + playerFour.getX() + "," + playerFour.getY() + ") is now quarantined and cannot become infected.");
                        }
                    }
                    turns4++;
                } while (turns4 < turnsMax);
            }
            playerCounter++;
        }


        //Here we will call the daily event

        int cardDrawn = rando.randomCard();

        while(eventHappened = true) {

            int moneyToAdd = 0;

            if (cardDrawn == 1) {
                eventHappened = eventTime.getSupplyShortage();
                if (!eventHappened){
                    eventTime.supplyShortageEvent();
                    eventHappened = true;
                }
            }
            else if (cardDrawn == 2) {
                eventHappened = eventTime.getEconomicRelief();
                if (!eventHappened) {
                    moneyToAdd = eventTime.economicReliefEvent();
                    playerOne.setMoney(playerOne.getMoney() + moneyToAdd);
                    playerTwo.setMoney(playerTwo.getMoney() + moneyToAdd);
                    playerThree.setMoney(playerThree.getMoney() + moneyToAdd);
                    playerFour.setMoney(playerFour.getMoney() + moneyToAdd);
                    eventHappened = true;
                }
            }
            else if (cardDrawn == 3){
                if (eventTime.getTimesQ() < 3){
                    eventTime.govQuarantine();
                    eventHappened = true;
                }
            }


        }


        //Here we will see if exposures turn into symptoms and if players become infected or not
        int e1c = e1, e2c = e2, e3c = e3, e4c = e4;

        e1 -= playerOne.getSupplies();
        if (e1 < 0){
            e1 = 0;
        }
        playerOne.setSupplies(playerOne.getSupplies() - e1c);
        if(playerOne.getSupplies() < 0){
            playerOne.setSupplies(0);
        }
        e2 -= playerTwo.getSupplies();
        if (e2 < 0){
            e2 =  0;
        }
        playerTwo.setSupplies(playerTwo.getSupplies() - e2c);
        if (playerTwo.getSupplies() < 0){
            playerTwo.setSupplies(0);
        }
        e3 -= playerThree.getSupplies();
        if(e3 < 0){
            e3 = 0;
        }
        playerThree.setSupplies(playerThree.getSupplies() - e3c);
        if (playerThree.getSupplies() < 0){
            playerThree.setSupplies(0);
        }
        e4 -= playerFour.getSupplies();
        if (e4 < 0){
            e4 = 0;
        }
        playerFour.setSupplies(playerFour.getSupplies() - e4c);
        if (playerFour.getSupplies() < 0){
            playerFour.setSupplies(0);
        }
        int chance = 0;

        while (e1 > 0 && !playerOne.getInfected()){
            chance = rando.thirtyThree();
            if (chance == 1){
                playerOne.setInfected(true);
            }
            e1--;
        }
        while(e2 > 0 && !playerTwo.getInfected()){
            chance = rando.thirtyThree();
            if (chance == 1){
                playerTwo.setInfected(true);
            }
            e2--;
        }
        while(e3 > 0 && !playerThree.getInfected()){
            chance = rando.thirtyThree();
            if(chance == 1){
                playerThree.setInfected(true);
            }
            e3--;
        }
        while(e4 > 0 && !playerFour.getInfected()){
            chance = rando.thirtyThree();
            if(chance == 1){
                playerFour.setInfected(true);
            }
            e4--;
        }

        //Gain/lose symptoms?
        int rolled = 0;
        if(playerOne.getInfected()){
            rolled = rando.diceRoll();
            if (rolled == 1 || rolled == 2 || rolled == 3){
                playerOne.setSymptoms(playerOne.getSymptoms() + 1);
            }
            else if(rolled == 4){
                playerOne.setSymptoms(playerOne.getSymptoms() - 1);
            }
        }
        else if (!playerOne.getInfected()){
            rolled = rando.diceRoll();
            if (rolled == 1){
                playerOne.setSymptoms(playerOne.getSymptoms() + 1);
            }
            else if (rolled == 2){
                playerOne.setSymptoms(playerOne.getSymptoms() - 1);
            }
        }
        if (playerTwo.getInfected()){
            rolled = rando.diceRoll();
            if (rolled == 1 || rolled == 2 || rolled == 3){
                playerTwo.setSymptoms(playerTwo.getSymptoms() + 1);
            }
            else if (rolled == 4){
                playerTwo.setSymptoms(playerTwo.getSymptoms() - 1);
            }
        }
        else if(!playerTwo.getInfected()){
            rolled = rando.diceRoll();
            if (rolled == 1){
                playerTwo.setSymptoms(playerTwo.getSymptoms() + 1);
            }
            else if (rolled == 2){
                playerTwo.setSymptoms(playerTwo.getSymptoms() - 1);
            }
        }
        if (playerThree.getInfected()){
            rolled = rando.diceRoll();
            if(rolled == 1 || rolled == 2 || rolled == 3){
                playerThree.setSymptoms(playerThree.getSymptoms() + 1);
            }
            else if(rolled == 4){
                playerThree.setSymptoms(playerThree.getSymptoms() - 1);
            }
        }
        else if(!playerThree.getInfected()){
            rolled = rando.diceRoll();
            if(rolled == 1){
                playerThree.setSymptoms(playerThree.getSymptoms() + 1);
            } else if (rolled == 2){
                playerThree.setSymptoms(playerThree.getSymptoms() - 1);
            }
        }
        if (playerFour.getInfected()){
            rolled = rando.diceRoll();
            if(rolled == 1 || rolled == 2 || rolled == 3){
                playerFour.setSymptoms(playerFour.getSymptoms() + 1);
            }
            else if(rolled == 4){
                playerFour.setSymptoms(playerFour.getSymptoms() - 1);
            }
        }
        else if(!playerFour.getInfected()){
            rolled = rando.diceRoll();
            if(rolled == 1){
                playerFour.setSymptoms(playerFour.getSymptoms() + 1);
            } else if (rolled == 2){
                playerFour.setSymptoms(playerFour.getSymptoms() - 1);
            }
        }

        if(playerOne.getSymptoms() > 3){
            playerOne.setSymptoms(3);
        }
        if(playerTwo.getSymptoms() > 3){
            playerTwo.setSymptoms(3);
        }
        if(playerThree.getSymptoms() > 3){
            playerThree.setSymptoms(3);
        }
        if(playerFour.getSymptoms() > 3){
            playerFour.setSymptoms(3);
        }

        //Health loss

        int hL1 = 0, hL1x = 0,  hL2 = 0, hL2x = 0, hL3 = 0, hL3x = 0, hL4 = 0, hL4x = 0;

        if(playerOne.getFood() > 2){
            hL1x = 0;
            playerOne.setFood(playerOne.getFood() - 2);
        }
        else if (playerOne.getFood() == 1){
            hL1x = 1;
            playerOne.setFood(0);
        }
        else{
            hL1x = 2;
        }

        hL1 = (hL1x + playerOne.getSymptoms());
        playerOne.setHealth(playerOne.getHealth() - hL1);
        if (playerOne.getHealth() < 0){
            playerOne.setHealth(0);
        }

        if(playerTwo.getFood() > 2){
            hL2x = 0;
            playerTwo.setFood(playerTwo.getFood() - 2);
        } else if(playerTwo.getFood() == 1){
            hL2x = 1;
            playerTwo.setFood(0);
        } else{
            hL2x = 2;
        }
        hL2 = (hL2x + playerTwo.getSymptoms());
        playerTwo.setHealth(playerTwo.getHealth() - hL2);
        if(playerTwo.getHealth() < 0){
            playerTwo.setHealth(0);
        }

        if (playerThree.getFood() > 2){
            hL3x = 0;
            playerThree.setFood(playerThree.getFood() - 2);
        }
        else if(playerThree.getFood() == 1){
            hL3x = 1;
            playerThree.setFood(0);
        }
        else{
            hL3x = 2;
        }
        hL3 = hL3x + playerThree.getSymptoms();
        playerThree.setHealth(playerThree.getHealth() - hL3);
        if(playerThree.getHealth() < 0){
            playerThree.setHealth(0);
        }

        if(playerFour.getFood() > 2){
            hL4x = 0;
            playerFour.setFood(playerFour.getFood() - 2);
        }
        else if(playerFour.getFood() == 1){
            hL4x = 1;
            playerFour.setFood(0);
        }
        else{
            hL4x = 2;
        }
        hL4 = hL4x + playerFour.getSymptoms();
        playerFour.setHealth(playerFour.getHealth() - hL4);
        if(playerFour.getHealth() < 0){
            playerFour.setHealth(0);
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
