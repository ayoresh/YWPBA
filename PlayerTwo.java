public class PlayerTwo {

    public String playerTwoName;
    public int supplies, food, symptoms;
    public boolean infected;


    PlayerTwo(){
        playerTwoName = "";
        supplies = 0;
        food = 0;
        symptoms = 0;
        infected = false;
    }

    PlayerTwo(String playerTwoName){
        this.playerTwoName = playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName){
        this.playerTwoName = playerTwoName;
    }
    public String getPlayerTwoName(){return playerTwoName;}
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
