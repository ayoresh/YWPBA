import javax.swing.JOptionPane;

public class Events {

    public boolean supplyShortage = false, economicRelief = false, storeLooted = false, testsAvailable = false, essentialBusinesses = false;
    public int reliefAmount = 5;
    public int timesQ = 0, timesSD = 0;
    GameBoard game = new GameBoard();
    RandomNum rando = new RandomNum();

    public void supplyShortageEvent(){



        int randoText = rando.fourSidedDie();
        String randoTextString = "";

        if (randoText == 1){
            randoTextString = "workers striking for sanitation supplies and safety equipment";
        } else if (randoText == 2){
            randoTextString = "hoarding by price gougers";
        } else if (randoText == 3){
            randoTextString = "an outbreak of infections at wholesale warehouses";
        } else if (randoText == 4){
            randoTextString = "reallocation of manufacturing resources";
        }

        JOptionPane.showMessageDialog(null, "Due to " + randoTextString + ", stores can no longer keep up with the demand for essential supplies." +
                "\nEssential items are now limited to 2 items per store visit.");
        supplyShortage = true;
    }

    public int economicReliefEvent(){
        if (!(getEconomicRelief())){
            JOptionPane.showMessageDialog(null,"Long promised economic aid has finally arrived. " +
                    "\nEach player has received a one-time check for $5.\nHopefully this will get you" +
                    " through the next couple months, or until more aid arrives.");
            economicRelief = true;
            return reliefAmount;
        }
        else {
            return 0;
        }
    }

    public void govQuarantine(){
        JOptionPane.showMessageDialog(null,"The CDC has set up quarantine checkpoints in the following spaces: ");
        game.governmentQuarantine();
        timesQ++;

    }

    public void looting(){
        while (!storeLooted){

            int x = rando.outOfTen();
            int y = rando.outOfTen();
            int isStore = game.getGameboard(x,y);
            if(isStore==4 || isStore == 5 || isStore == 8 || isStore == 9){
                if(isStore == 4 || isStore == 8){
                    game.setGameboard(x,y,0);
                } else if(isStore == 5 || isStore == 9){
                    game.setGameboard(x,y,1);
                }
                storeLooted = true;
                int whichtext = rando.coinFlip();
                if(whichtext == 1) {
                    JOptionPane.showMessageDialog(null, "The fear of future shortages, economic uncertainty, and soaring unemployment\n" +
                            "has created a quickly escalating volatile situation. It isn't long before the looting starts.\nShops at (" + x + "," + y + ")" +
                            " have been cleaned out. No one may purchase items here anymore.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "An angry mob has gathered dissatisfied with the local governments response to the outbreak." +
                            "\nIt only took one brick to hit the storefront for the shop at (" + x + "," + y +") to be looted.\nShop is closed indefinitely.");
                }
            }
        }
    }


    public void essentialClosings(){
        JOptionPane.showMessageDialog(null,"Essential businesses have now closed to limit the spread of the virus.\n" +
                "Working is no longer available, however each player will receive $4 daily from their employer\nthanks to the Paycheck Protection Program.");
        essentialBusinesses = true;
    }

    public void socialDistancing(){
        timesSD++;
        JOptionPane.showMessageDialog(null,"Social distancing has become stricter across your town.\n" + timesSD + " vectors removed.");
        if(timesSD == 1){
            game.deleteVector();
        } else if(timesSD == 2){
            game.deleteVector();
            game.deleteVector();
        } else if(timesSD == 3){
            game.deleteVector();
            game.deleteVector();
            game.deleteVector();
        }
    }

    public boolean getEconomicRelief(){
        return economicRelief;
    }

    public int getTimesQ(){
        return  timesQ;
    }

    public int getTimesSD(){
        return timesSD;
    }

    public boolean getSupplyShortage(){
        return supplyShortage;
    }

    public boolean getLooting(){
        return storeLooted;
    }

    public void setTestsAvailable(boolean testsAvailable){
        this.testsAvailable = testsAvailable;
    }
    public boolean getTests(){
        return testsAvailable;
    }

    public boolean getEssentialBusiness(){
        return essentialBusinesses;
    }



}
