import javax.swing.JOptionPane;

public class DayNine {
    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    PlayerFour playerFour;
    Actions actionobj = new Actions();
    RandomNum rando = new RandomNum();
    GameBoard game = new GameBoard();
    Events eventTime = new Events();



    DayNine(String playerOneName, int health1, int supplies1, int food1, int symptoms1, int money1, int x1, int y1, boolean infected1,
            String playerTwoName, int health2, int supplies2, int food2, int symptoms2, int money2, int x2, int y2, boolean infected2,
            String playerThreeName, int health3, int supplies3, int food3, int symptoms3, int money3, int x3, int y3, boolean infected3,
            String playerFourName, int health4, int supplies4, int food4, int symptoms4, int money4, int x4, int y4, boolean infected4, int[][] gameboard) {
        playerOne = new PlayerOne(playerOneName, health1, supplies1, food1, symptoms1, money1, x1, y1, infected1);
        playerTwo = new PlayerTwo(playerTwoName, health2, supplies2, food2, symptoms2, money2, x2, y2, infected2);
        playerThree = new PlayerThree(playerThreeName, health3, supplies3, food3, symptoms3, money3, x3, y3, infected3);
        playerFour = new PlayerFour(playerFourName, health4, supplies4, food4, symptoms4, money4, x4, y4, infected4);
        game = new GameBoard(gameboard);
    }
    public void day9(){
        //Players sent back to home base
        playerOne.setX(2);
        playerOne.setY(2);
        JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + ", you've returned to your home base, (2,2).");
        playerTwo.setX(2);
        playerTwo.setY(7);
        JOptionPane.showMessageDialog(null, playerTwo.getPlayerTwoName() + ", you've returned to your home base, (2,7).");
        playerThree.setX(7);
        playerThree.setY(2);
        JOptionPane.showMessageDialog(null, playerThree.getPlayerThreeName() + ", you've returned to your home base, (7,2).");
        playerFour.setX(7);
        playerFour.setY(7);
        JOptionPane.showMessageDialog(null, playerFour.getPlayerFourName() + ", you've returned to your home base, (7,7).");
//Exposure counters
        int e1 = 0, e2 = 0, e3 = 0, e4 = 0;
        boolean eventHappened = false;
        String preventativeMeasure = "", morningText ="";
        int pmtxt = rando.outOfFive();
        switch(pmtxt){
            case 1:
                preventativeMeasure += "wash hands thoroughly and often for at least 20 seconds";
                break;
            case 2:
                preventativeMeasure += "stay home if you exhibit any symptoms";
                break;
            case 3:
                preventativeMeasure += "call ahead if you are seeking medical treatment for COVID-19";
                break;
            case 4:
                preventativeMeasure += "limit close contact with individuals outside our your household in public spaces";
                break;
            case 5:
                preventativeMeasure += "stay away from others when possible, even if you show no symptoms.\n people can spread the virus " +
                        "before they know they are sick";
                break;
            default:
                preventativeMeasure += "only leave your home for essential purposes";
                break;
        }

        pmtxt = rando.thirtyThree();
        switch(pmtxt){
            case 1:
                game.setDeathRate(2);
                game.setDeathToll(game.getDeathRate());
                morningText = "The morning news announces that the death toll of the virus has risen to " + game.getDeathToll() +
                        ",000 after " + game.getDeathRate() + ",000 were lost to the virus yesterday.\nCDC advises people to " + preventativeMeasure
                        + ".";
                break;
            case 2:
                game.setDeathRate(2);
                game.setDeathToll(game.getDeathRate());
                morningText = "While watching regular television there is now a constant\nbreaking news scroll displayed at the bottom\nof the screen.";
                morningText+= "\nDeath Toll: " + game.getDeathToll() + ",000   Death Rate: " + game.getDeathRate() +
                        "\n CDC advises to " + preventativeMeasure + ".";
                break;
            case 3:
                game.setDeathRate(2);
                game.setDeathToll(game.getDeathRate());
                morningText = "During morning television regular broadcast TV is interrupted by\n";
                int pmtxt2 = rando.fourSidedDie();
                switch(pmtxt2){
                    case 1:
                        morningText += "a PSA advising citizens to " + preventativeMeasure + ".";
                        break;
                    case 2:
                        morningText += "a news conference from the president advising the public to\n" + preventativeMeasure + ".";
                        break;
                    case 3:
                        morningText += "an announcement by the governor advising the public to\n" + preventativeMeasure + ".";
                        break;
                    case 4:
                        morningText += "a commercial telling people to " + preventativeMeasure + ".\nIt also assures us that\nWe Are All In This Together" +
                                "\nThe commercial is sponsored by a multinational fast food chain.";
                        break;
                    default:
                        morningText += "a celebrity telling the public to " + preventativeMeasure + ".\nThe celebrity is beginning to sell 24k gold face masks for $2k each.";
                        break;
                }
                break;
            default:
                morningText = "A flyer came in the mail this morning advising people to\n" + preventativeMeasure + ".";
                break;
        }


        JOptionPane.showMessageDialog(null, morningText);

        if(eventTime.getEssentialBusiness()){
            JOptionPane.showMessageDialog(null,"Each player has received $4 thanks to the P.P.P.");
            playerOne.setMoney(playerOne.getMoney() + 4);
            playerTwo.setMoney(playerTwo.getMoney() + 4);
            playerThree.setMoney(playerThree.getMoney() + 4);
            playerFour.setMoney(playerFour.getMoney() + 4);
        }
        //New vector spawning
        int infectedspacecount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of infected spaces currently in play. "));
        int vectorCount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of vectors currently in play."));
        JOptionPane.showMessageDialog(null,"Please ignore any vectors the game assigns once 6 vectors have been created.");
        if(vectorCount < 6){
            for(int i = 0; i < game.gameboard.length; i++){
                for(int j = 0; j < game.gameboard[i].length; j++){
                    if(game.getGameboard(i,j) == 1){
                        int vChance = rando.fourSidedDie();
                        int dChance = rando.fourSidedDie();
                        String dir;
                        if(dChance == 1){
                            dir = "right";
                        }
                        else if(dChance == 2){
                            dir = "left";
                        }
                        else if(dChance == 3){
                            dir = "up";
                        } else{
                            dir = "down";
                        }
                        if (vChance == 1){
                            JOptionPane.showMessageDialog(null,"The space (" + i + "," + j + ") has now become a vector travelling " + dir + ".");
                            vectorCount++;
                        }
                    }
                    if(vectorCount >= 6){
                        break;
                    }
                }
                if(vectorCount >= 6){
                    break;
                }
                if(vectorCount >= 6){
                    break;
                }
            }
        }
        for(int x = 0; x < 8; x++) {
            for (int playerCounter = 0; playerCounter < 4; playerCounter++) {

                int actionPoints1 = 0, actionPoints2 = 0, actionPoints3 = 0, actionPoints4 = 0, actionPointsMax = 4;

                if (playerCounter == 0 && playerOne.getHealth() != 0) {
                    int playerLocale = game.getGameboard(playerOne.getX(), playerOne.getY());
                    String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn",
                            shopping = "\n4: shop for supplies or food";


                    actionPoints1 = 0;
                    while (actionPoints1 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 4 || playerLocale == 5 || playerLocale == 9 || playerLocale == 8) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerOne.getPlayerOneName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints1));


                        while (action != 0 && action != 1 && action != 2 && action != 3 && action != 10 && action != 4) {
                            action = Integer.parseInt(JOptionPane.showInputDialog("Invalid input.\n" +
                                    playerOne.getPlayerOneName() + ", " +
                                    actionText + "\nAction Points Used: " + actionPoints1));
                        }
                        //Player shops at food store
                        if ((action == 4 && playerLocale == 4) || (action == 4 && playerLocale == 5)) {
                            if (actionPoints1 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.foodShopping();
                                int itemsBoughtChecker = playerOne.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                            " Please buy an amount of food that you can afford.");
                                    itemsBought = actionobj.foodShopping();
                                    itemsBoughtChecker = playerOne.getMoney() - (itemsBought);
                                }
                                playerOne.setFood(playerOne.getFood() + itemsBought);
                                playerOne.setMoney(playerOne.getMoney() - (itemsBought));
                                actionPoints1 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if ((action == 4 && playerLocale == 8) || (action == 4 && playerLocale == 9)) {
                            if (actionPoints1 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.supplyShopping();
                                int itemsBoughtChecker = playerOne.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                            "Please buy an amount of supplies you can afford.");
                                    itemsBought = actionobj.supplyShopping();
                                    itemsBoughtChecker = playerOne.getMoney() - (itemsBought);
                                }
                                playerOne.setSupplies(playerOne.getSupplies() + itemsBought);
                                playerOne.setMoney(playerOne.getMoney() - (itemsBought));
                                actionPoints1 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 4 && playerLocale != 4 && playerLocale != 5 && playerLocale != 8 && playerLocale != 9) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }

                        //Player works
                        else if (action == 0) {
                            if (!eventTime.getEssentialBusiness()) {
                                if (actionPoints1 + 4 <= actionPointsMax) {
                                    int moneyEarned = 4;
                                    playerOne.setMoney(playerOne.getMoney() + moneyEarned);
                                    e1++;
                                    JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                            + "\nYou now have $" + playerOne.getMoney() + ". You gained one exposure.");
                                    actionPoints1 += 4;
                                } else {
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Working is not available due to the closure of essential businesses.");
                            }
                        }

                        //Player Movement
                        else if (action == 3) {
                            boolean movePossible = true;
                            int movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                    "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            while (movement < 1 || movement > 4) {
                                JOptionPane.showMessageDialog(null, "Invalid entry. Please enter a number between 1 and 4.");
                                movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                        "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            }
                            if (playerOne.getY() == 9 && movement == 1) {
                                JOptionPane.showMessageDialog(null, "You may not travel right, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerOne.getY() == 0 && movement == 2) {
                                JOptionPane.showMessageDialog(null, "You may not travel left, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerOne.getX() == 0 && movement == 3) {
                                JOptionPane.showMessageDialog(null, "You may not travel up, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerOne.getX() == 9 && movement == 4) {
                                JOptionPane.showMessageDialog(null, "You may not travel down, as you are on the edge of the board.");
                                movePossible = false;
                            }

                            if (movePossible) {
                                if (movement == 1) {
                                    playerOne.setY(playerOne.getY() + 1);
                                } else if (movement == 2) {
                                    playerOne.setY(playerOne.getY() - 1);
                                } else if (movement == 3) {
                                    playerOne.setX(playerOne.getX() - 1);
                                } else if (movement == 4) {
                                    playerOne.setX(playerOne.getX() + 1);
                                }

                                playerLocale = game.getGameboard(playerOne.getX(), playerOne.getY());
                                if (playerLocale == 1 || playerLocale == 5 || playerLocale == 9) {
                                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                                    e1++;
                                }

                                JOptionPane.showMessageDialog(null, "New location: (" + playerOne.getX() + "," + playerOne.getY() + ").");
                                actionPoints1++;

                            }


                        }
                        //Player gifts items to another player
                        else if (action == 1) {
                            int gift = Integer.parseInt(JOptionPane.showInputDialog("What gift would you like to send? Enter: \n1: food\n2: supplies"));
                            int amountSend = 0;
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
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerOne.getFood() + " pieces of food."));
                                while (amountSend < 0 || amountSend > playerOne.getFood()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerOne.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerTwo.setFood(playerTwo.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e2++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerThree.setFood(playerThree.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e3++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerFour.setFood(playerFour.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e4++;
                                    }
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
                                if (whichPlayer == 2 && (playerTwo.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 3 to send supplies to " + playerThree.getPlayerThreeName() +
                                            " or enter a 4 to send supplies to " + playerFour.getPlayerFourName() + "."));
                                    while (whichPlayer != 3 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 3 or a 4."));
                                    }
                                }
                                if (whichPlayer == 3 && (playerThree.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " +
                                            playerTwo.getPlayerTwoName() + " or a 4 to send supplies to " + playerFour.getPlayerFourName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 4."));
                                    }
                                }
                                if (whichPlayer == 4 && (playerFour.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " + playerTwo.getPlayerTwoName() +
                                            " or a 3 to send supplies to " + playerThree.getPlayerThreeName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 3) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 3."));
                                    }
                                }
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerOne.getSupplies() + " supplies."));
                                while (amountSend < 0 || amountSend > playerOne.getSupplies()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerOne.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e2++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e3++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e4++;
                                    }
                                }
                                playerOne.setSupplies(playerOne.getSupplies() - amountSend);

                            }
                            if (amountSend == 0) {
                                actionPoints1--;
                            }
                            actionPoints1++;
                        } else if (action == 10) {
                            JOptionPane.showMessageDialog(null, "Turn ended.");
                            actionPoints1 = 4;
                        }
                        //quarantine area
                        else if (action == 2) {
                            boolean together = false;
                            int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                                    pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                            if (pl1 == pl2 || pl2 == pl3 || pl3 == pl4 || pl1 == pl4 || pl2 == pl4 || pl1 == pl3) {
                                together = true;
                            }
                            if (actionPoints1 <= 2 && together) {
                                int currentPlace = game.getGameboard(playerOne.getX(), playerOne.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerOne.getX(), playerOne.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerOne.getX() + "," + playerOne.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints1 += 2;
                                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2 && pl2 == pl4) {
                                        e1++;
                                        e2++;
                                        e4++;
                                    } else if (pl2 == pl3 && pl3 == pl4) {
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2) {
                                        e1++;
                                        e2++;
                                    } else if (pl2 == pl3) {
                                        e2++;
                                        e3++;
                                    } else if (pl3 == pl4) {
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl4) {
                                        e1++;
                                        e4++;
                                    } else if (pl2 == pl4) {
                                        e2++;
                                        e4++;
                                    } else if (pl1 == pl3) {
                                        e1++;
                                        e3++;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            }
                            if (actionPoints1 + 4 <= actionPointsMax) {
                                int currentPlace = game.getGameboard(playerOne.getX(), playerOne.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerOne.getX(), playerOne.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerOne.getX() + "," + playerOne.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints1 += 4;
                                    actionPoints1 += 4;
                                    e1++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough points to complete this action. " +
                                        "Please choose another action.");
                            }
                        }
                        playerLocale = game.getGameboard(playerOne.getX(), playerOne.getY());
                        if (playerLocale != 4 && playerLocale != 5 && playerLocale != 9 && playerLocale != 8) {
                            actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn";
                        }
                    }

                    //Players land on same location?
                    int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                            pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                        e1++;
                        e2++;
                        e3++;
                        e4++;
                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                        e1++;
                        e2++;
                        e3++;
                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                        e1++;
                        e3++;
                        e4++;
                    } else if (pl1 == pl2 && pl2 == pl4) {
                        e1++;
                        e2++;
                        e4++;
                    } else if (pl2 == pl3 && pl3 == pl4) {
                        e2++;
                        e3++;
                        e4++;
                    } else if (pl1 == pl2) {
                        e1++;
                        e2++;
                    } else if (pl2 == pl3) {
                        e2++;
                        e3++;
                    } else if (pl3 == pl4) {
                        e3++;
                        e4++;
                    } else if (pl1 == pl4) {
                        e1++;
                        e4++;
                    } else if (pl2 == pl4) {
                        e2++;
                        e4++;
                    } else if (pl1 == pl3) {
                        e1++;
                        e3++;
                    }
                }
                if (playerCounter == 1 && playerTwo.getHealth() != 0) {
                    int playerLocale = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                    String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn",
                            shopping = "\n4: shop for supplies or food";


                    actionPoints2 = 0;
                    while (actionPoints2 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 4 || playerLocale == 5 || playerLocale == 9 || playerLocale == 8) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerTwo.getPlayerTwoName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints2));

                        while (action != 0 && action != 1 && action != 2 && action != 3 && action != 10 && action != 4) {
                            action = Integer.parseInt(JOptionPane.showInputDialog("Invalid input.\n" +
                                    playerTwo.getPlayerTwoName() + ", " +
                                    actionText + "\nAction Points Used: " + actionPoints2));
                        }

                        //Player shops at food store
                        if ((action == 4 && playerLocale == 4) || (action == 4 && playerLocale == 5)) {
                            if (actionPoints2 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.foodShopping();
                                int itemsBoughtChecker = playerTwo.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                            " Please buy an amount of food that you can afford.");
                                    itemsBought = actionobj.foodShopping();
                                    itemsBoughtChecker = playerTwo.getMoney() - (itemsBought);
                                }
                                playerTwo.setFood(playerTwo.getFood() + itemsBought);
                                playerTwo.setMoney(playerTwo.getMoney() - (itemsBought));
                                actionPoints2 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if ((action == 4 && playerLocale == 8) || (action == 4 && playerLocale == 9)) {
                            if (actionPoints2 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.supplyShopping();
                                int itemsBoughtChecker = playerTwo.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                            "Please buy an amount of supplies you can afford.");
                                    itemsBought = actionobj.supplyShopping();
                                    itemsBoughtChecker = playerTwo.getMoney() - (itemsBought);
                                }
                                playerTwo.setSupplies(playerTwo.getSupplies() + itemsBought);
                                playerTwo.setMoney(playerTwo.getMoney() - (itemsBought));
                                actionPoints2 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 4 && playerLocale != 4 && playerLocale != 5 && playerLocale != 8 && playerLocale != 9) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }

                        //Player works
                        else if (action == 0) {
                            if (!eventTime.getEssentialBusiness()) {
                                if (actionPoints2 + 4 <= actionPointsMax) {
                                    int moneyEarned = 4;
                                    playerTwo.setMoney(playerTwo.getMoney() + moneyEarned);
                                    e2++;
                                    JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                            + "\nYou now have $" + playerTwo.getMoney() + ". You gained one exposure.");
                                    actionPoints2 += 4;
                                } else {
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Working is not available due to the closure of essential businesses.");
                            }
                        }
                        //Player Movement
                        else if (action == 3) {
                            boolean movePossible = true;
                            int movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                    "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            while (movement < 1 || movement > 4) {
                                JOptionPane.showMessageDialog(null, "Invalid entry. Please enter a number between 1 and 4.");
                                movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                        "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            }
                            if (playerTwo.getY() == 9 && movement == 1) {
                                JOptionPane.showMessageDialog(null, "You may not travel right, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerTwo.getY() == 0 && movement == 2) {
                                JOptionPane.showMessageDialog(null, "You may not travel left, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerTwo.getX() == 0 && movement == 3) {
                                JOptionPane.showMessageDialog(null, "You may not travel up, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerTwo.getX() == 9 && movement == 4) {
                                JOptionPane.showMessageDialog(null, "You may not travel down, as you are on the edge of the board.");
                                movePossible = false;
                            }

                            if (movePossible) {
                                if (movement == 1) {
                                    playerTwo.setY(playerTwo.getY() + 1);
                                } else if (movement == 2) {
                                    playerTwo.setY(playerTwo.getY() - 1);
                                } else if (movement == 3) {
                                    playerTwo.setX(playerTwo.getX() - 1);
                                } else if (movement == 4) {
                                    playerTwo.setX(playerTwo.getX() + 1);
                                }

                                playerLocale = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                                if (playerLocale == 1 || playerLocale == 5 || playerLocale == 9) {
                                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                                    e2++;
                                }

                                JOptionPane.showMessageDialog(null, "New location: (" + playerTwo.getX() + "," + playerTwo.getY() + ").");
                                actionPoints2++;

                            }
                        }

                        //Player gifts items to another player
                        else if (action == 1) {
                            int amountSend = 0;
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
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerTwo.getFood() + " pieces of food."));
                                while (amountSend < 0 || amountSend > playerTwo.getFood()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerTwo.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setFood(playerOne.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e1++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerThree.setFood(playerThree.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e3++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerFour.setFood(playerFour.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e4++;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                                playerTwo.setFood(playerTwo.getFood() - amountSend);
                            }

                            //supplies
                            //2 - p1 , 3 - p3 , 4 - p4
                            else if (gift == 2) {
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                            "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerThree.getPlayerThreeName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                if (whichPlayer == 2 && (playerOne.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 3 to send supplies to " + playerThree.getPlayerThreeName() +
                                            " or enter a 4 to send supplies to " + playerFour.getPlayerFourName() + "."));
                                    while (whichPlayer != 3 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 3 or a 4."));
                                    }
                                }
                                if (whichPlayer == 3 && (playerThree.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " +
                                            playerOne.getPlayerOneName() + " or a 4 to send supplies to " + playerFour.getPlayerFourName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 4."));
                                    }
                                }
                                if (whichPlayer == 4 && (playerFour.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " + playerOne.getPlayerOneName() +
                                            " or a 3 to send supplies to " + playerThree.getPlayerThreeName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 3) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 3."));
                                    }
                                }
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerTwo.getSupplies() + " supplies."));
                                while (amountSend < 0 || amountSend > playerTwo.getSupplies()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerTwo.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setSupplies(playerTwo.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e1++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e3++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e4++;
                                    }
                                }
                                playerTwo.setSupplies(playerTwo.getSupplies() - amountSend);
                            }
                            if (amountSend == 0) {
                                actionPoints2--;
                            }
                            actionPoints2++;
                        } else if (action == 10) {
                            JOptionPane.showMessageDialog(null, "Turn ended.");
                            actionPoints2 = 4;
                        }
                        //quarantine area
                        else if (action == 2) {
                            boolean together = false;
                            int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                                    pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                            if (pl1 == pl2 || pl2 == pl3 || pl3 == pl4 || pl1 == pl4 || pl2 == pl4 || pl1 == pl3) {
                                together = true;
                            }
                            if (actionPoints2 <= 2 && together) {
                                int currentPlace = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerTwo.getX(), playerTwo.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerTwo.getX() + "," + playerTwo.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints2 += 2;
                                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2 && pl2 == pl4) {
                                        e1++;
                                        e2++;
                                        e4++;
                                    } else if (pl2 == pl3 && pl3 == pl4) {
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2) {
                                        e1++;
                                        e2++;
                                    } else if (pl2 == pl3) {
                                        e2++;
                                        e3++;
                                    } else if (pl3 == pl4) {
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl4) {
                                        e1++;
                                        e4++;
                                    } else if (pl2 == pl4) {
                                        e2++;
                                        e4++;
                                    } else if (pl1 == pl3) {
                                        e1++;
                                        e3++;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            }
                            if (actionPoints2 + 4 <= actionPointsMax) {
                                int currentPlace = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                                if (currentPlace != 13 && currentPlace != 8 && currentPlace != 9 && currentPlace != 4 && currentPlace != 5) {
                                    game.quarantineArea(playerTwo.getX(), playerTwo.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerTwo.getX() + "," + playerTwo.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints2 += 4;
                                    e2++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough points to complete this action. " +
                                        "Please choose another action.");
                            }
                        }
                        playerLocale = game.getGameboard(playerTwo.getX(), playerTwo.getY());
                        if (playerLocale != 4 && playerLocale != 5 && playerLocale != 9 && playerLocale != 8) {
                            actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn";
                        }

                    }

                    //Players land on same location?
                    int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                            pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                        e1++;
                        e2++;
                        e3++;
                        e4++;
                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                        e1++;
                        e2++;
                        e3++;
                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                        e1++;
                        e3++;
                        e4++;
                    } else if (pl1 == pl2 && pl2 == pl4) {
                        e1++;
                        e2++;
                        e4++;
                    } else if (pl2 == pl3 && pl3 == pl4) {
                        e2++;
                        e3++;
                        e4++;
                    } else if (pl1 == pl2) {
                        e1++;
                        e2++;
                    } else if (pl2 == pl3) {
                        e2++;
                        e3++;
                    } else if (pl3 == pl4) {
                        e3++;
                        e4++;
                    } else if (pl1 == pl4) {
                        e1++;
                        e4++;
                    } else if (pl2 == pl4) {
                        e2++;
                        e4++;
                    } else if (pl1 == pl3) {
                        e1++;
                        e3++;
                    }
                }


                if (playerCounter == 2 && playerThree.getHealth() != 0) {
                    int playerLocale = game.getGameboard(playerThree.getX(), playerThree.getY());
                    String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn",
                            shopping = "\n4: shop for supplies or food";

                    actionPoints3 = 0;
                    while (actionPoints3 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 4 || playerLocale == 5 || playerLocale == 9 || playerLocale == 8) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerThree.getPlayerThreeName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints3));

                        while (action != 0 && action != 1 && action != 2 && action != 3 && action != 10 && action != 4) {
                            action = Integer.parseInt(JOptionPane.showInputDialog("Invalid input.\n" +
                                    playerThree.getPlayerThreeName() + ", " +
                                    actionText + "\nAction Points Used: " + actionPoints3));
                        }

                        //Player shops at food store
                        if ((action == 4 && playerLocale == 4) || (action == 4 && playerLocale == 5)) {
                            if (actionPoints3 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.foodShopping();
                                int itemsBoughtChecker = playerThree.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                            " Please buy an amount of food that you can afford.");
                                    itemsBought = actionobj.foodShopping();
                                    itemsBoughtChecker = playerThree.getMoney() - (itemsBought);
                                }
                                playerThree.setFood(playerThree.getFood() + itemsBought);
                                playerThree.setMoney(playerThree.getMoney() - (itemsBought));
                                actionPoints3 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if ((action == 4 && playerLocale == 8) || (action == 4 && playerLocale == 9)) {
                            if (actionPoints3 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.supplyShopping();
                                int itemsBoughtChecker = playerThree.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                            "Please buy an amount of supplies you can afford.");
                                    itemsBought = actionobj.supplyShopping();
                                    itemsBoughtChecker = playerThree.getMoney() - (itemsBought);
                                }
                                playerThree.setSupplies(playerThree.getSupplies() + itemsBought);
                                playerThree.setMoney(playerThree.getMoney() - (itemsBought));
                                actionPoints3 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 4 && playerLocale != 4 && playerLocale != 5 && playerLocale != 8 && playerLocale != 9) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }

                        //Player works
                        else if (action == 0) {
                            if (!eventTime.getEssentialBusiness()) {
                                if (actionPoints3 + 4 <= actionPointsMax) {
                                    int moneyEarned = 4;
                                    playerThree.setMoney(playerThree.getMoney() + moneyEarned);
                                    e3++;
                                    JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                            + "\nYou now have $" + playerThree.getMoney() + ". You gained one exposure.");
                                    actionPoints3 += 4;
                                } else {
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Working is not available due to the closure of essential businesses.");
                            }
                        }

                        //Player Movement
                        else if (action == 3) {
                            boolean movePossible = true;
                            int movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                    "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            while (movement < 1 || movement > 4) {
                                JOptionPane.showMessageDialog(null, "Invalid entry. Please enter a number between 1 and 4.");
                                movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                        "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            }
                            if (playerThree.getY() == 9 && movement == 1) {
                                JOptionPane.showMessageDialog(null, "You may not travel right, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerThree.getY() == 0 && movement == 2) {
                                JOptionPane.showMessageDialog(null, "You may not travel left, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerThree.getX() == 0 && movement == 3) {
                                JOptionPane.showMessageDialog(null, "You may not travel up, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerThree.getX() == 9 && movement == 4) {
                                JOptionPane.showMessageDialog(null, "You may not travel down, as you are on the edge of the board.");
                                movePossible = false;
                            }

                            if (movePossible) {
                                if (movement == 1) {
                                    playerThree.setY(playerThree.getY() + 1);
                                } else if (movement == 2) {
                                    playerThree.setY(playerThree.getY() - 1);
                                } else if (movement == 3) {
                                    playerThree.setX(playerThree.getX() - 1);
                                } else if (movement == 4) {
                                    playerThree.setX(playerThree.getX() + 1);
                                }

                                playerLocale = game.getGameboard(playerThree.getX(), playerThree.getY());
                                if (playerLocale == 1 || playerLocale == 5 || playerLocale == 9) {
                                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                                    e3++;
                                }

                                JOptionPane.showMessageDialog(null, "New location: (" + playerThree.getX() + "," + playerThree.getY() + ").");
                                actionPoints3++;

                            }
                        }

                        //Player gifts items to another player
                        else if (action == 1) {
                            int amountSend = 0;
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
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerThree.getFood() + " pieces of food."));
                                while (amountSend < 0 || amountSend > playerThree.getFood()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerThree.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setFood(playerOne.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e1++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerTwo.setFood(playerTwo.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e2++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerFour.setFood(playerFour.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e4++;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                                playerThree.setFood(playerThree.getFood() - amountSend);
                            }

                            //supplies
                            //2 - p1 , 3 - p2 , 4 - p4
                            else if (gift == 2) {
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerFour.getPlayerFourName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                            "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerFour.getPlayerFourName()));
                                }
                                if (whichPlayer == 2 && (playerOne.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 3 to send supplies to " + playerTwo.getPlayerTwoName() +
                                            " or enter a 4 to send supplies to " + playerFour.getPlayerFourName() + "."));
                                    while (whichPlayer != 3 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 3 or a 4."));
                                    }
                                }
                                if (whichPlayer == 3 && (playerTwo.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " +
                                            playerOne.getPlayerOneName() + " or a 4 to send supplies to " + playerFour.getPlayerFourName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 4."));
                                    }
                                }
                                if (whichPlayer == 4 && (playerFour.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " + playerOne.getPlayerOneName() +
                                            " or a 3 to send supplies to " + playerTwo.getPlayerTwoName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 3) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 3."));
                                    }
                                }
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerThree.getSupplies() + " supplies."));
                                while (amountSend < 0 || amountSend > playerThree.getSupplies()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerThree.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setSupplies(playerOne.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e1++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e2++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerFour.setSupplies(playerFour.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e4++;
                                    }
                                }
                                playerThree.setSupplies(playerThree.getSupplies() - amountSend);
                            }
                            if (amountSend == 0) {
                                actionPoints3--;
                            }
                            actionPoints3++;
                        } else if (action == 10) {
                            JOptionPane.showMessageDialog(null, "Turn ended.");
                            actionPoints3 = 4;
                        }
                        //quarantine area
                        else if (action == 2) {
                            boolean together = false;
                            int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                                    pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                            if (pl1 == pl2 || pl2 == pl3 || pl3 == pl4 || pl1 == pl4 || pl2 == pl4 || pl1 == pl3) {
                                together = true;
                            }
                            if (actionPoints3 <= 2 && together) {
                                int currentPlace = game.getGameboard(playerThree.getX(), playerThree.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerThree.getX(), playerThree.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerThree.getX() + "," + playerThree.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints3 += 2;
                                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2 && pl2 == pl4) {
                                        e1++;
                                        e2++;
                                        e4++;
                                    } else if (pl2 == pl3 && pl3 == pl4) {
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2) {
                                        e1++;
                                        e2++;
                                    } else if (pl2 == pl3) {
                                        e2++;
                                        e3++;
                                    } else if (pl3 == pl4) {
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl4) {
                                        e1++;
                                        e4++;
                                    } else if (pl2 == pl4) {
                                        e2++;
                                        e4++;
                                    } else if (pl1 == pl3) {
                                        e1++;
                                        e3++;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            }
                            if (actionPoints3 + 4 <= actionPointsMax) {
                                int currentPlace = game.getGameboard(playerThree.getX(), playerThree.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerThree.getX(), playerThree.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerThree.getX() + "," + playerThree.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints3 += 4;
                                    e3++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough points to complete this action. " +
                                        "Please choose another action.");
                            }
                        }
                        playerLocale = game.getGameboard(playerThree.getX(), playerThree.getY());
                        if (playerLocale != 4 && playerLocale != 5 && playerLocale != 9 && playerLocale != 8) {
                            actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn";
                        }
                    }

                    //Players land on same location?
                    int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                            pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                        e1++;
                        e2++;
                        e3++;
                        e4++;
                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                        e1++;
                        e2++;
                        e3++;
                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                        e1++;
                        e3++;
                        e4++;
                    } else if (pl1 == pl2 && pl2 == pl4) {
                        e1++;
                        e2++;
                        e4++;
                    } else if (pl2 == pl3 && pl3 == pl4) {
                        e2++;
                        e3++;
                        e4++;
                    } else if (pl1 == pl2) {
                        e1++;
                        e2++;
                    } else if (pl2 == pl3) {
                        e2++;
                        e3++;
                    } else if (pl3 == pl4) {
                        e3++;
                        e4++;
                    } else if (pl1 == pl4) {
                        e1++;
                        e4++;
                    } else if (pl2 == pl4) {
                        e2++;
                        e4++;
                    } else if (pl1 == pl3) {
                        e1++;
                        e3++;
                    }
                }


                if (playerCounter == 3 && playerFour.getHealth() != 0) {
                    int playerLocale = game.getGameboard(playerFour.getX(), playerFour.getY());
                    String actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn",
                            shopping = "\n4: shop for supplies or food";

                    actionPoints4 = 0;
                    while (actionPoints4 < actionPointsMax) {
                        //Check if player at a store
                        if (playerLocale == 4 || playerLocale == 5 || playerLocale == 9 || playerLocale == 8) {
                            actionText += shopping;
                        }
                        int action = Integer.parseInt(JOptionPane.showInputDialog(playerFour.getPlayerFourName() + ", " +
                                actionText + "\nAction Points Used: " + actionPoints4));

                        while (action != 0 && action != 1 && action != 2 && action != 3 && action != 10 && action != 4) {
                            action = Integer.parseInt(JOptionPane.showInputDialog("Invalid input.\n" +
                                    playerFour.getPlayerFourName() + ", " +
                                    actionText + "\nAction Points Used: " + actionPoints4));
                        }
                        //Player shops at food store
                        if ((action == 4 && playerLocale == 4) || (action == 4 && playerLocale == 5)) {
                            if (actionPoints4 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.foodShopping();
                                int itemsBoughtChecker = playerFour.getMoney() - (itemsBought * 2);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more food than you can afford." +
                                            " Please buy an amount of food that you can afford.");
                                    itemsBought = actionobj.foodShopping();
                                    itemsBoughtChecker = playerFour.getMoney() - (itemsBought);
                                }
                                playerFour.setFood(playerFour.getFood() + itemsBought);
                                playerFour.setMoney(playerFour.getMoney() - (itemsBought));
                                actionPoints4 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }
                        }

                        //Player shops at supply store
                        else if ((action == 4 && playerLocale == 8) || (action == 4 && playerLocale == 9)) {
                            if (actionPoints4 + 4 <= actionPointsMax) {
                                int itemsBought = actionobj.supplyShopping();
                                int itemsBoughtChecker = playerFour.getMoney() - (itemsBought);
                                while (itemsBoughtChecker < 0) {
                                    JOptionPane.showMessageDialog(null, "You have attempted to buy more supplies than you can afford. " +
                                            "Please buy an amount of supplies you can afford.");
                                    itemsBought = actionobj.supplyShopping();
                                    itemsBoughtChecker = playerFour.getMoney() - (itemsBought);
                                }
                                playerFour.setSupplies(playerFour.getSupplies() + itemsBought);
                                playerFour.setMoney(playerFour.getMoney() - (itemsBought));
                                actionPoints4 += 4;
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                        "Please choose another action.");
                            }

                        }

                        //Player attempts to shop, but is not on a space that contains a store
                        else if (action == 4 && playerLocale != 4 && playerLocale != 5 && playerLocale != 8 && playerLocale != 9) {
                            JOptionPane.showMessageDialog(null, "You are not on a space that you may buy supplies at." +
                                    "\nPlease enter a valid action.");
                        }
                        //Player works

                        else if (action == 0) {
                            if (!eventTime.getEssentialBusiness()) {
                                if (actionPoints4 + 4 <= actionPointsMax) {
                                    int moneyEarned = 4;
                                    playerFour.setMoney(playerFour.getMoney() + moneyEarned);
                                    e4++;
                                    JOptionPane.showMessageDialog(null, "You have decided to work. You earned $" + moneyEarned + "."
                                            + "\nYou now have $" + playerFour.getMoney() + ". You gained one exposure.");
                                    actionPoints4 += 4;
                                } else {
                                    JOptionPane.showMessageDialog(null, "You do not have enough action points to do complete this action. " +
                                            "Please choose another action.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Working is not available due to the closure of essential businesses.");
                            }
                        }

                        //Player Movement
                        else if (action == 3) {
                            boolean movePossible = true;
                            int movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                    "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            while (movement < 1 || movement > 4) {
                                JOptionPane.showMessageDialog(null, "Invalid entry. Please enter a number between 1 and 4.");
                                movement = Integer.parseInt(JOptionPane.showInputDialog("Which direction would you like to move? Enter:" +
                                        "\n1: Move Right\n2: Move Left\n3: Move Up\n 4: Move down"));
                            }
                            if (playerFour.getY() == 9 && movement == 1) {
                                JOptionPane.showMessageDialog(null, "You may not travel right, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerFour.getY() == 0 && movement == 2) {
                                JOptionPane.showMessageDialog(null, "You may not travel left, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerFour.getX() == 0 && movement == 3) {
                                JOptionPane.showMessageDialog(null, "You may not travel up, as you are on the edge of the board.");
                                movePossible = false;
                            }
                            if (playerFour.getX() == 9 && movement == 4) {
                                JOptionPane.showMessageDialog(null, "You may not travel down, as you are on the edge of the board.");
                                movePossible = false;
                            }

                            if (movePossible) {
                                if (movement == 1) {
                                    playerFour.setY(playerFour.getY() + 1);
                                } else if (movement == 2) {
                                    playerFour.setY(playerFour.getY() - 1);
                                } else if (movement == 3) {
                                    playerFour.setX(playerFour.getX() - 1);
                                } else if (movement == 4) {
                                    playerFour.setX(playerFour.getX() + 1);
                                }

                                playerLocale = game.getGameboard(playerFour.getX(), playerFour.getY());
                                if (playerLocale == 1 || playerLocale == 5 || playerLocale == 9) {
                                    JOptionPane.showMessageDialog(null, "YOU HAVE ENTERED AN INFECTED SPACE. Exposure goes up one level.");
                                    e4++;
                                }

                                JOptionPane.showMessageDialog(null, "New location: (" + playerFour.getX() + "," + playerFour.getY() + ").");
                                actionPoints4++;

                            }


                        }
                        //Player gifts items to another player
                        else if (action == 1) {
                            int amountSend = 0;
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
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerFour.getFood() + " pieces of food."));
                                while (amountSend < 0 || amountSend > playerFour.getFood()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of food you currently have, " + playerFour.getFood()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setFood(playerOne.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e1++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerTwo.setFood(playerTwo.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e2++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerThree.setFood(playerThree.getFood() + amountSend);
                                    if (amountSend > 0) {
                                        e3++;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "You sent " + amountSend + " pieces of food.");
                                playerFour.setFood(playerFour.getFood() - amountSend);
                            }
                            //supplies
                            //2 - p1 , 3 - p2 , 4 - p3
                            else if (gift == 2) {
                                int whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Which player would you like to send supplies to?" +
                                        "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerThree.getPlayerThreeName()));
                                while (whichPlayer < 2 || whichPlayer > 4) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Which player would you like to send supplies to?" +
                                            "Enter:+\n2: " + playerOne.getPlayerOneName() + "\n3: " + playerTwo.getPlayerTwoName() + "\n4: " + playerThree.getPlayerThreeName()));
                                }
                                if (whichPlayer == 2 && (playerOne.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 3 to send supplies to " + playerTwo.getPlayerTwoName() +
                                            " or enter a 4 to send supplies to " + playerThree.getPlayerThreeName() + "."));
                                    while (whichPlayer != 3 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 3 or a 4."));
                                    }
                                }
                                if (whichPlayer == 3 && (playerTwo.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " +
                                            playerOne.getPlayerOneName() + " or a 4 to send supplies to " + playerThree.getPlayerThreeName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 4) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 4."));
                                    }
                                }
                                if (whichPlayer == 4 && (playerThree.getHealth() == 0)) {
                                    whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("You cannot send supplies to a dead player. Please enter a 2 to send supplies to " + playerOne.getPlayerOneName() +
                                            " or a 3 to send supplies to " + playerTwo.getPlayerTwoName() + "."));
                                    while (whichPlayer != 2 && whichPlayer != 3) {
                                        whichPlayer = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a 2 or a 3."));
                                    }
                                }
                                amountSend = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to send? You currently have " + playerFour.getSupplies() + " supplies."));
                                while (amountSend < 0 || amountSend > playerThree.getSupplies()) {
                                    amountSend = Integer.parseInt(JOptionPane.showInputDialog("Invalid entry. Please enter a number between 0 and the amount of supplies you currently have, " + playerFour.getSupplies()
                                            + "."));
                                }
                                if (whichPlayer == 2) {
                                    playerOne.setSupplies(playerTwo.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e1++;
                                    }
                                } else if (whichPlayer == 3) {
                                    playerTwo.setSupplies(playerTwo.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e2++;
                                    }
                                } else if (whichPlayer == 4) {
                                    playerThree.setSupplies(playerThree.getSupplies() + amountSend);
                                    if (amountSend > 0) {
                                        e3++;
                                    }
                                }
                                playerFour.setSupplies(playerFour.getSupplies() - amountSend);

                            }
                            if (amountSend == 0) {
                                actionPoints4--;
                            }
                            actionPoints4++;
                        } else if (action == 10) {
                            JOptionPane.showMessageDialog(null, "Turn ended.");
                            actionPoints4 = 4;
                        }
                        //quarantine area
                        else if (action == 2) {
                            boolean together = false;
                            int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                                    pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                            if (pl1 == pl2 || pl2 == pl3 || pl3 == pl4 || pl1 == pl4 || pl2 == pl4 || pl1 == pl3) {
                                together = true;
                            }
                            if (actionPoints4 <= 2 && together) {
                                int currentPlace = game.getGameboard(playerFour.getX(), playerFour.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerFour.getX(), playerFour.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerFour.getX() + "," + playerFour.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints4 += 2;
                                    if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if ((pl1 == pl2) && (pl2 == pl3)) {
                                        e1++;
                                        e2++;
                                        e3++;
                                    } else if ((pl1 == pl3) && (pl3 == pl4)) {
                                        e1++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2 && pl2 == pl4) {
                                        e1++;
                                        e2++;
                                        e4++;
                                    } else if (pl2 == pl3 && pl3 == pl4) {
                                        e2++;
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl2) {
                                        e1++;
                                        e2++;
                                    } else if (pl2 == pl3) {
                                        e2++;
                                        e3++;
                                    } else if (pl3 == pl4) {
                                        e3++;
                                        e4++;
                                    } else if (pl1 == pl4) {
                                        e1++;
                                        e4++;
                                    } else if (pl2 == pl4) {
                                        e2++;
                                        e4++;
                                    } else if (pl1 == pl3) {
                                        e1++;
                                        e3++;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            }
                            if (actionPoints3 + 4 <= actionPointsMax) {
                                int currentPlace = game.getGameboard(playerFour.getX(), playerFour.getY());
                                if (currentPlace != 13 && currentPlace != 4 && currentPlace != 5 && currentPlace != 8 && currentPlace != 9) {
                                    game.quarantineArea(playerFour.getX(), playerFour.getY());
                                    JOptionPane.showMessageDialog(null, "Space (" + playerFour.getX() + "," + playerFour.getY() + ") is now quarantined and cannot become infected.");
                                    actionPoints4 += 4;
                                    e4++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "This space is already quarantined, or may be unable to be quarantined.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "You do not have enough points to complete this action. " +
                                        "Please choose another action.");
                            }
                        }
                        playerLocale = game.getGameboard(playerFour.getX(), playerFour.getY());
                        if (playerLocale != 4 && playerLocale != 5 && playerLocale != 9 && playerLocale != 8) {
                            actionText = "which action would you like to take? Enter:\n0: work\n1: gift supplies or food to another player\n2: create quarantine area\n3: move\n10: end turn";
                        }
                    }
                }

                //Players land on same location?
                int pl1 = game.getGameboard(playerOne.getX(), playerOne.getY()), pl2 = game.getGameboard(playerTwo.getX(), playerTwo.getY()),
                        pl3 = game.getGameboard(playerThree.getX(), playerThree.getY()), pl4 = game.getGameboard(playerFour.getX(), playerFour.getY());
                if ((pl1 == pl2) && (pl2 == pl3) && (pl3 == pl4)) {
                    e1++;
                    e2++;
                    e3++;
                    e4++;
                } else if ((pl1 == pl2) && (pl2 == pl3)) {
                    e1++;
                    e2++;
                    e3++;
                } else if ((pl1 == pl3) && (pl3 == pl4)) {
                    e1++;
                    e3++;
                    e4++;
                } else if (pl1 == pl2 && pl2 == pl4) {
                    e1++;
                    e2++;
                    e4++;
                } else if (pl2 == pl3 && pl3 == pl4) {
                    e2++;
                    e3++;
                    e4++;
                } else if (pl1 == pl2) {
                    e1++;
                    e2++;
                } else if (pl2 == pl3) {
                    e2++;
                    e3++;
                } else if (pl3 == pl4) {
                    e3++;
                    e4++;
                } else if (pl1 == pl4) {
                    e1++;
                    e4++;
                } else if (pl2 == pl4) {
                    e2++;
                    e4++;
                } else if (pl1 == pl3) {
                    e1++;
                    e3++;
                }
            }


            //Vector Movement HERE!!!!!
            JOptionPane.showMessageDialog(null, "Move vectors in the direction they are traveling.\n" +
                    "If a vector has hit a corner or quarantined space, its direction is now the opposite of what it was.");
            int howManyVectors = Integer.parseInt(JOptionPane.showInputDialog("How many vectors are currently active on the board?\nmin: 0 max: 6"));
            while (howManyVectors < 0 || howManyVectors > 6){
                howManyVectors = Integer.parseInt(JOptionPane.showInputDialog("Invalid input. \nPlease enter the amount of active vectors. \nmin: 0 max: 6 "));
            }
            for(int z = 0; z < howManyVectors; z++){
                int xVal = Integer.parseInt(JOptionPane.showInputDialog("What is the x-coordinate?"));
                while(xVal < 0 || xVal > 9){
                    xVal = Integer.parseInt(JOptionPane.showInputDialog("Value for x-coordinate must be between 0 and 9.\nPlease enter the x-coordinate."));
                }
                int yVal = Integer.parseInt(JOptionPane.showInputDialog("What is the y-coordinate?"));
                while(yVal < 0 || yVal > 9){
                    yVal = Integer.parseInt(JOptionPane.showInputDialog("Value for y-coordinate must be between 0 and 9.\nPlease enter the y-coordinate."));
                }
                int gameSpace = game.getGameboard(xVal, yVal);
                if(gameSpace == 0){
                    game.setGameboard(xVal, yVal, 1);
                    JOptionPane.showMessageDialog(null, "(" + xVal + "," + yVal + ") is now infected.");
                }
                else if(gameSpace == 4){
                    game.setGameboard(xVal, yVal, 5);
                    JOptionPane.showMessageDialog(null, "(" + xVal + "," + yVal + ") is now an infected food shop.");
                }
                else if(gameSpace == 8){
                    game.setGameboard(xVal, yVal, 9);
                    JOptionPane.showMessageDialog(null, "(" + xVal + "," + yVal + ") is now an infected supply shop.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Space does not change.");
                }
                int getRolled = rando.diceRoll();
                if(getRolled == 1){
                    JOptionPane.showMessageDialog(null,"Vector direction change!\nTurn this vector once to the right.");
                } if(getRolled == 2){
                    JOptionPane.showMessageDialog(null,"Vector direction change!\nTurn this vector once to the left.");
                }
            }

            int toDisplay = x + 1;
            JOptionPane.showMessageDialog(null, toDisplay + " turn(s) used.");
        }


        //Here we will call the daily event

        int cardDrawn = rando.randomCard();

        while(eventHappened = false) {

            int moneyToAdd = 0;

            if (cardDrawn == 1) {
                if (!eventTime.getSupplyShortage()){
                    eventTime.supplyShortageEvent();
                    eventHappened = true;
                }
            }
            else if (cardDrawn == 2) {
                if (!eventTime.getEconomicRelief()) {
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
            else if (cardDrawn == 4){
                if(!eventTime.getLooting()){
                    eventTime.looting();
                    eventHappened = true;
                }
            }
            else if(cardDrawn == 5){
                if(!eventTime.getTests()){
                    String toAddToTestingText = "";
                    int tocheck = rando.fourSidedDie();
                    if(tocheck == 1){
                        toAddToTestingText = "drive through testing centers located in repurposed mall parking lots.";
                    } else if(tocheck == 2){
                        toAddToTestingText = "select pharmacies and urgent care clinics.";;
                    } else if(tocheck == 3){
                        toAddToTestingText = "primary care physicians' and select specialists' offices.";
                    } else{
                        toAddToTestingText = "hospitals.";
                    }
                    JOptionPane.showMessageDialog(null,"After being fast tracked by the FDA, a new test for COVID-19 has become available.\n" +
                            "Now the wait for results is hours, not days. Starting tomorrow, they will\nbe available to the general public at " + toAddToTestingText);
                    if(playerOne.getInfected()){
                        JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + " is infected.");
                    } else if (!playerOne.getInfected()){
                        JOptionPane.showMessageDialog(null, playerOne.getPlayerOneName() + " is not infected.");
                    }
                    if(playerTwo.getInfected()){
                        JOptionPane.showMessageDialog(null,playerTwo.getPlayerTwoName() + " is infected.");
                    } else if(!playerTwo.getInfected()){
                        JOptionPane.showMessageDialog(null, playerTwo.getPlayerTwoName() + " is not infected.");
                    }
                    if(playerThree.getInfected()){
                        JOptionPane.showMessageDialog(null, playerThree.getPlayerThreeName() + " is infected.");
                    }else if(!playerThree.getInfected()){
                        JOptionPane.showMessageDialog(null, playerThree.getPlayerThreeName() + " is not infected.");
                    }
                    if(playerFour.getInfected()){
                        JOptionPane.showMessageDialog(null, playerFour.getPlayerFourName() + " is infected.");
                    } else if (!playerFour.getInfected()){
                        JOptionPane.showMessageDialog(null, playerFour.getPlayerFourName() + " is not infected.");
                    }
                }
            }
            else if(cardDrawn == 6){
                if(!eventTime.getEssentialBusiness()){
                    eventTime.essentialClosings();
                    eventHappened = true;
                }
            }
            else if(cardDrawn == 7){
                if(eventTime.getTimesSD() < 3){
                    eventTime.socialDistancing();
                    eventHappened = true;
                }
            }
            else{
                //Nothing? Hospital event?
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
            playerOne.setX(-50);
            playerOne.setY(-50);
            //player one death text
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
            playerTwo.setX(-50);
            playerTwo.setY(-50);
            //Player two death text
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
            playerThree.setX(-50);
            playerThree.setY(-50);
            //player three death text
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
            playerFour.setX(-50);
            playerFour.setY(-50);
            //player four death text
        }

        String alivePlayers = "";
        if(playerOne.getHealth() > 0){
            alivePlayers += playerOne.getPlayerOneName() + "\n";
        }
        if (playerTwo.getHealth() > 0){
            alivePlayers += playerTwo.getPlayerTwoName() + "\n";
        }
        if(playerThree.getHealth() > 0){
            alivePlayers += playerThree.getPlayerThreeName() + "\n";
        }
        if (playerFour.getHealth() > 0){
            alivePlayers += playerFour.getPlayerFourName();
        }

        JOptionPane.showMessageDialog(null, "Remaining Players: " + alivePlayers);



        DayTen dayten = new DayTen(playerOne.getPlayerOneName(), playerOne.getHealth(), playerOne.getSupplies(), playerOne.getFood(),
                playerOne.getSymptoms(), playerOne.getMoney(), playerOne.getX(), playerOne.getY(), playerOne.getInfected(),
                playerTwo.getPlayerTwoName(), playerTwo.getHealth(), playerTwo.getSupplies(), playerTwo.getFood(),
                playerTwo.getSymptoms(), playerTwo.getMoney(), playerTwo.getX(), playerTwo.getY(), playerTwo.getInfected(),
                playerThree.getPlayerThreeName(), playerThree.getHealth(), playerThree.getSupplies(), playerThree.getFood(),
                playerThree.getSymptoms(), playerThree.getMoney(), playerThree.getX(), playerThree.getY(), playerThree.getInfected(),
                playerFour.getPlayerFourName(), playerFour.getHealth(), playerFour.getSupplies(), playerFour.getFood(),
                playerFour.getSymptoms(), playerFour.getMoney(), playerFour.getX(), playerFour.getY(), playerFour.getInfected(),game.getGameboardArray());
        dayten.day10();

    }
}