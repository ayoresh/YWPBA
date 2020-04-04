public class PlayerTwo {

    public String playerTwoName;
    public int infection;

    PlayerTwo(){
        playerTwoName = "";
        infection = 0;
    }

    PlayerTwo(String playerTwoName){
        this.playerTwoName = playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName){
        this.playerTwoName = playerTwoName;
    }
    public String getPlayerTwoName(){return playerTwoName;}
}
