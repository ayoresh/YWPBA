public class PlayerTwo {

    public String playerTwoName;
    public int supplies, food, symptoms, health, money, x, y;
    public boolean infected;


    PlayerTwo(){
        playerTwoName = "";
        health = 15;
        supplies = 0;
        food = 0;
        symptoms = 0;
        money = 0;
        x = 0;
        y = 0;
        infected = false;
    }

    PlayerTwo(String playerTwoName){
        this.playerTwoName = playerTwoName;
        health = 15;
        supplies = 0;
        food = 0;
        symptoms = 0;
        money = 0;
        x = 0;
        y = 0;
        infected = false;
    }

    PlayerTwo(String playerTwoName, int health, int supplies, int food, int symptoms, int money, int x, int y, boolean infected){
        this.playerTwoName = playerTwoName;
        this.health = health;
        this.supplies = supplies;
        this.food = food;
        this.symptoms = symptoms;
        this.money = money;
        this.x = x;
        this.y = y;
        this.infected = infected;
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

    public boolean getInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }
    public int getHealth(){return health;}
    public int getMoney(){return money;}

    public int getX(){ return x;}
    public int getY(){return y;}
}
