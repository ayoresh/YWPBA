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
        //JOptionPane.showMessageDialog(null,"The CDC has set up quarantine checkpoints in the following spaces: ");
        String quarText = "";
        int randoText = rando.fourSidedDie();
        switch (randoText) {
            case 1:
                quarText += "Due to community transmissions, the CDC is performing temperature screening before letting citizens pass through the following spaces: ";
                break;
            case 2:
                quarText += "Local police are interviewing pedestrians who may have come in contact with infected persons to prevent the further spread of the virus at: ";
                break;
            case 3:
                quarText += "PSA's have been posted reminding people to maintain 6 feet of seperation. Billboards and bust stop adverts keep people from forgetting at:";
                break;
            case 4:
                quarText += "Police are making the rounds, adivising people to disperse in the following areas:";
                break;
            default:
                //throw error
                break;

        }
        JOptionPane.showMessageDialog(null,quarText);
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
        String socialDistText = "";
        int randoText = rando.fourSidedDie();
        //JOptionPane.showMessageDialog(null,"Social distancing has become stricter across your town.\n" + timesSD + " vectors removed.");
        if(timesSD == 1){
            switch (randoText) {
                case 1:
                    socialDistText += "Local city guidelines advise that residents not gather in groups of ten or more.";
                    break;
                case 2:
                    socialDistText += "Local officials have closed public parks, gyms, and playgrounds to slow the spread of COVID-19.";
                    break;
                case 3:
                    socialDistText += "Public transportation in the city is limiting the service hours and closing some bus lines.";
                    break;
                case 4:
                    socialDistText += "Local and State governemnt workers are advised to utilize emergency telework procedures when possible.";
                    break;
                default:
                    //throw error
                    break;

            }

            game.deleteVector();
        } else if(timesSD == 2){
            switch (randoText) {
                case 1:
                    socialDistText += "The governor invoked emergency powers to mandate that residents not gather in groups of five or more.";
                    break;
                case 2:
                    socialDistText += "Local officials have closed restaurants and bars except for delivery and carry-out orders.";
                    break;
                case 3:
                    socialDistText += "Public transportation is limited to essential routes and trainlines will close overnight for decontamination.";
                    break;
                case 4:
                    socialDistText += "City government is closed to nonesential business and all nonessential employees are on paid leave.";
                    break;
                default:
                    //throw error
                    break;

            }

            game.deleteVector();
            game.deleteVector();
        } else if(timesSD == 3){
            switch (randoText) {
                case 1:
                    socialDistText += "The governor mandates that all residents stay in their homes excpet for essential activities such as grocery shopping.";
                    break;
                case 2:
                    socialDistText += "Citizens are required to wear masks or other face coverings in public, if they must leave their homes.";
                    break;
                case 3:
                    socialDistText += "High-risk inmates are having their sentences commuted to prevent the rapid spread of COVID-19 in overcrowded prisons.";
                    break;
                case 4:
                    socialDistText += "Open casket funerals have been banned for those who are suspected to have become deceased due to COVID-19.";
                    break;
                default:
                    //throw error
                    break;

            }



            game.deleteVector();
            game.deleteVector();
            game.deleteVector();
        }
        JOptionPane.showMessageDialog(null, socialDistText + "/n" + timesSD + " vectors removed.");

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

        String testText = "After being fast tracked by the FDA, a new test for the virus has become available the wait for results to hours rather than days. Starting tomorrow";
        int randoText = rando.fourSidedDie();
        switch (randoText) {
            case 1:
                testText += " tests will be available at drive through testing centers in repurposed mall parking lots.";
                break;
            case 2:
                testText += " tests will be available at select pharmacies and urgent care clinics.";
                break;
            case 3:
                testText += " tests will be available from primary care physicians and certain specialists";
                break;
            case 4:
                testText += " the state government will be dispensing mail in test kits to every citizen";
                break;
            default:
                //throw error
                break;
        }
    }
    public boolean getTests(){
        return testsAvailable;
    }

    public boolean getEssentialBusiness(){
        return essentialBusinesses;
    }



}
