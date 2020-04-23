//This file will be used to manipulate the first player's character



public class PlayerOne {

    public String playerOneName;
    public int supplies, food, symptoms, health, money, x, y;
    public boolean infected;

    PlayerOne(){
        playerOneName = "";
        health = 15;
        supplies = 0;
        food = 0;
        symptoms = 0;
        money = 0;
        x = 0;
        y = 0;
        infected = false;
    }

    PlayerOne(String playerOneName){
        this.playerOneName = playerOneName;
        health = 15;
        supplies = 0;
        food = 0;
        symptoms = 0;
        money = 0;
        x = 0;
        y = 0;
        infected = false;
    }

    PlayerOne(String playerOneName, int health, int supplies, int food, int symptoms, int money, int x, int y, boolean infected){
        this.playerOneName = playerOneName;
        this.health = health;
        this.supplies = supplies;
        this.food = food;
        this.symptoms = symptoms;
        this.money = money;
        this.x = x;
        this.y = y;
        this.infected = infected;
    }

    public void setPlayerOneName(String playerOneName){
        this.playerOneName = playerOneName;
    }
    public String getPlayerOneName(){return playerOneName;}

    public int getHealth(){return health;}
    public int getMoney(){return money;}

    public int getX(){ return x;}
    public int getY(){return y;}

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
}
