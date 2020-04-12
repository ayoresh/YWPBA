public class PlayerFour {
    public String playerFourName;
    public int supplies, food, symptoms;
    public boolean infected;


    PlayerFour(){
        playerFourName = "";
        supplies = 0;
        food = 0;
        symptoms = 0;
        infected = false;
    }

    PlayerFour(String playerFourName){
        this.playerFourName = playerFourName;
    }
    public void setPlayerFourName(String playerFourName){ this.playerFourName = playerFourName;
    }
    public String getPlayerFourName(){return playerFourName;}
    public int getSupplies() {
        return supplies;
    }

    public void setSupplies(int supplies) {
        this.supplies = supplies;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(int symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

}
