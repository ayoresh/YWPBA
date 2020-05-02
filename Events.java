import javax.swing.JOptionPane;

public class Events {

    public boolean supplyShortage = false, economicRelief = false;
    public int reliefAmount = 5;
    public int timesQ = 0;
    GameBoard game = new GameBoard();


    public void supplyShortageEvent(){

        RandomNum rando = new RandomNum();

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
            economicRelief = true;
            return reliefAmount;
        }
        else {
            return 0;
        }
    }

    public void govQuarantine(){
        game.governmentQuarantine();
        timesQ++;

    }


    public boolean getEconomicRelief(){
        return economicRelief;
    }

    public int getTimesQ(){
        return  timesQ;
    }

    public boolean getSupplyShortage(){
        return supplyShortage;
    }








}
