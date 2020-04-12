//This file will be used to manipulate the first player's character



public class PlayerOne {

    public String playerOneName;
    public int supplies, food, symptoms;
    public boolean infected;

    PlayerOne(){
        playerOneName = "";
        supplies = 0;
        food = 0;
        symptoms = 0;
        infected = false;
    }

    PlayerOne(String playerOneName){
        this.playerOneName = playerOneName;
        supplies = 0;
        food = 0;
        symptoms = 0;
        infected = false;
    }

    public void setPlayerOneName(String playerOneName){
        this.playerOneName = playerOneName;
    }
    public String getPlayerOneName(){return playerOneName;}

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
