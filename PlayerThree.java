public class PlayerThree {
    public String playerThreeName;
    public int supplies, food, symptoms;
    public boolean infected;



    PlayerThree(){
        playerThreeName = "";
        supplies = 0;
        food = 0;
        symptoms = 0;
        infected = false;
    }


    PlayerThree(String playerThreeName){
        this.playerThreeName = playerThreeName;
    }

    public void setPlayerThreeName(String playerThreeName){
        this.playerThreeName = playerThreeName;
    }
    public String getPlayerThreeName(){return playerThreeName;}
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
