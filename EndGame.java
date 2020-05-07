import javax.swing.*;
public class EndGame {


    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    PlayerFour playerFour;



    EndGame(String playerOneName, int health1, int supplies1, int food1, int symptoms1, int money1, int x1, int y1, boolean infected1,
            String playerTwoName, int health2, int supplies2, int food2, int symptoms2, int money2, int x2, int y2, boolean infected2,
            String playerThreeName, int health3, int supplies3, int food3, int symptoms3, int money3, int x3, int y3, boolean infected3,
            String playerFourName, int health4, int supplies4, int food4, int symptoms4, int money4, int x4, int y4, boolean infected4){
        playerOne = new PlayerOne(playerOneName, health1, supplies1, food1, symptoms1, money1, x1, y1, infected1);
        playerTwo = new PlayerTwo(playerTwoName, health2, supplies2,food2,symptoms2,money2, x2, y2, infected2);
        playerThree = new PlayerThree(playerThreeName, health3, supplies3, food3, symptoms3, money3, x3, y3, infected3);
        playerFour = new PlayerFour(playerFourName, health4, supplies4, food4, symptoms4, money4, x4, y4, infected4);
    }

    public void endStory() {
        ImageIcon goodEnd = new ImageIcon("GoodEnding.PNG");

        boolean p1Alive = false, p2Alive = false, p3Alive = false, p4Alive = false;
        if (playerOne.getHealth() > 0) {
            p1Alive = true;
        }
        if (playerTwo.getHealth() > 0) {
            p2Alive = true;
        }
        if (playerThree.getHealth() > 0) {
            p3Alive = true;
        }
        if (playerFour.getHealth() > 0) {
            p4Alive = true;
        }
        String PlayerOneName = playerOne.getPlayerOneName();
        String PlayerTwoName = playerTwo.getPlayerTwoName();
        String PlayerThreeName = playerThree.getPlayerThreeName();
        String PlayerFourName = playerFour.getPlayerFourName();

        if ((p1Alive && p2Alive) && (p3Alive && p4Alive)) {
            JOptionPane.showMessageDialog(null, "Congratulations! You and your friends have survived.\n" +
                            " You are not among those who succumbed to viral, poverty or mental heath related deaths caused by The Pandemic.\n" +
                            "As of the first week of May 2020, more Americans have died to The Pandemic than\n" +
                            "the Vietnam War, " +
                            "Iraq War, " +
                            "and the War in Afghanistan combined.",
                    "You Will Be Alright.", JOptionPane.INFORMATION_MESSAGE, goodEnd);
        } else if ((p1Alive && p2Alive && p3Alive && !p4Alive) || (p1Alive && p2Alive && !p3Alive && p4Alive) || (p1Alive && !p2Alive && p3Alive && p4Alive) || (!p1Alive && p2Alive && p3Alive && p4Alive)) {
            if (!p1Alive || !p2Alive) {
                if (!p1Alive) {
                    JOptionPane.showMessageDialog(null, "Both " + PlayerThreeName + " and " + PlayerFourName +
                            "were able to weather the pandemic together.\n" + PlayerTwoName + ", their friend and neighbor made it through as well,\nbut without the person they love most, "
                            + PlayerOneName + ".\n Unfortunately, " + PlayerOneName + " wasn't able to make it. Maybe they\n weren't " + PlayerThreeName + "'s or "
                            + PlayerFourName + "'s family or spouse, but they were " + PlayerTwoName + "'s.\nEveryone knows someone who's lost someone, or they certainly will...\n\n\nBe kind",
                            "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
                }
                //(!p2Alive)
                else {
                    JOptionPane.showMessageDialog(null, "Both " + PlayerThreeName + " and " + PlayerFourName + " were able to weather the pandemic together.\n"
                            + PlayerOneName + ", their friend and neighbor made it through as well,\nbut without the person they love most, " + PlayerTwoName + ".\n Unfortunately, "
                            + PlayerTwoName + " wasn't able to make it. Maybe they\n weren't " + PlayerThreeName + "'s or " + PlayerFourName +
                            "'s family or spouse, but they were " + PlayerOneName + "'s.\nEveryone knows someone who's lost someone, or they certainly will...\n\n\nBe kind",
                            "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
                }
            } else {
                if (!p3Alive) {
                    JOptionPane.showMessageDialog(null, "Both " + PlayerOneName + " and " + PlayerTwoName + " were able to weather the pandemic together.\n"
                            + PlayerFourName + ", their friend and neighbor made it through as well,\nbut without the person they love most, " + PlayerThreeName + ".\n Unfortunately," + PlayerThreeName +
                            " wasn't able to make it. Maybe they\n weren't " + PlayerOneName + "'s or " + PlayerTwoName + "'s family or spouse, but they were " +
                            PlayerFourName + "'s.\nEveryone knows someone who's lost someone, or they certainly will...\n\n\nBe kind",
                            "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
                }
                //!p4Alive
                else {
                    JOptionPane.showMessageDialog(null, "Both " + PlayerOneName + " and " + PlayerTwoName + " were able to weather the pandemic together.\n" + PlayerThreeName +
                            ", their friend and neighbor made it through as well,\nbut without the person they love most, " + PlayerFourName +
                            ".\n Unfortunately, " + PlayerFourName + " wasn't able to make it. Maybe they\n weren't " + PlayerOneName + "'s or " + PlayerTwoName + "'s family or spouse, but they were " +
                            PlayerThreeName + "'s.\nEveryone knows someone who's lost someone, or they certainly will...\n\n\nBe kind",
                            "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
                }
            }
        }

            else if ((!p1Alive && !p2Alive && p3Alive && p4Alive) || (!p1Alive && p2Alive && !p3Alive && p4Alive) || (!p1Alive && p2Alive && p3Alive && !p4Alive) || (p1Alive && !p2Alive && !p3Alive && p4Alive)
                || (p1Alive && !p2Alive && p3Alive && !p4Alive) || (p1Alive && p2Alive && !p3Alive && !p4Alive)) {
            //p1 and p2 are dead
            if (!p1Alive && !p2Alive) {
                JOptionPane.showMessageDialog(null, "Both " + PlayerThreeName + " and " + PlayerFourName + "were able to weather the pandemic together.\n " +
                        "However their friends and neighbors "+PlayerOneName + " and " + PlayerTwoName  + "were not as lucky.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p1 and p3 dead
            //both emotional connections ruined
            else if (!p1Alive && !p3Alive) {
                JOptionPane.showMessageDialog(null, PlayerTwoName+" survived "+PlayerOneName+" and "+PlayerFourName+" survived "+PlayerThreeName+
                        ".\nThey were all friends once. Now as neighbors it's hard for "+PlayerFourName+" to even see "+PlayerTwoName+".\nUnfortunately moving forward for "+PlayerFourName+
                        " means moving\npast memories of the times that "+PlayerTwoName+" would tie them to.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p1 and p4 dead
            //both emotional connections ruined
            else if (!p1Alive && !p4Alive) {
                JOptionPane.showMessageDialog(null, PlayerTwoName+" survived "+PlayerOneName+" and "+PlayerThreeName+" survived "+PlayerFourName+
                        ".\nThey were all friends once. Now as neighbors it's hard for "+PlayerThreeName+" to even see "+PlayerTwoName+".\nUnfortunately moving forward for "+
                        PlayerThreeName+" means moving\npast memories of the times that "+PlayerTwoName+" would tie them to.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p2 and p3 dead
            //both emotional connections ruined
            else if (!p2Alive && !p3Alive) {
                JOptionPane.showMessageDialog(null, PlayerOneName+" survived "+PlayerTwoName+" and "+PlayerFourName+" survived "+
                        PlayerThreeName+".\nThey were all friends once. Now as neighbors it's hard for "+PlayerFourName+" to even see "+PlayerOneName+".\nUnfortunately moving forward for "
                        +PlayerFourName+" means moving\npast memories of the times that "+PlayerOneName+" would tie them to.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p2 and p4 dead
            //both emotional connections ruined
            else if (!p2Alive && !p4Alive) {
                JOptionPane.showMessageDialog(null,PlayerOneName+" survived "+PlayerTwoName+" and "+
                        PlayerThreeName+" survived "+PlayerFourName+".\nThey were all friends once. Now as neighbors it's hard for "+PlayerThreeName+" to even see "+PlayerOneName
                        +".\nUnfortunately moving forward for "+PlayerThreeName+" means moving\npast memories of the times that "+PlayerOneName+" would tie them to.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p3 and p4 dead
            else if (!p3Alive && !p4Alive) {
                JOptionPane.showMessageDialog(null, "Both " + PlayerOneName + " and " + PlayerTwoName +
                        "were able to weather the pandemic together,\n however their friends and neighbors PlayerThreeName and PlayerFourName were not as lucky.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }

        }
        //only one player alive
        else if ((!p1Alive && !p2Alive && !p3Alive && p4Alive) || (!p1Alive && !p2Alive && p3Alive && !p4Alive) || (!p1Alive && p2Alive && !p3Alive && !p4Alive)
                || (p1Alive && !p2Alive && !p3Alive && !p4Alive)) {
            //p1 alive only
            if (p1Alive) {
                JOptionPane.showMessageDialog(null, PlayerOneName + " survived but none of their friends or " + PlayerTwoName +", the person that cared for most were as fortunate.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p2 alive only
            else if (p2Alive) {
                JOptionPane.showMessageDialog(null, PlayerTwoName + " survived but none of their friends or " + PlayerOneName + ", the person that cared for most were as fortunate.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p3 alive only
            else if (p3Alive) {
                JOptionPane.showMessageDialog(null, PlayerThreeName + " survived but none of their friends or " + PlayerFourName+", the person that cared for most were as fortunate.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
            //p4 alive only
            else {
                JOptionPane.showMessageDialog(null,  PlayerFourName + " survived but none of their friends or " + PlayerThreeName+", the person that cared for most were as fortunate.",
                        "", JOptionPane.INFORMATION_MESSAGE, goodEnd);
            }
        }
        //no one survives
        else {
            ImageIcon gameOver = new ImageIcon("GameOver.png");
            JOptionPane.showMessageDialog(null, "None of you made it.\nG A M E   O V E R", "GAME OVER", JOptionPane.INFORMATION_MESSAGE,gameOver);

        }

    }





}
