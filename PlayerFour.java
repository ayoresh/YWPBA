public class PlayerFour {
    public String playerFourName;
    public int infection;

    PlayerFour(){
        playerFourName = "";
        infection = 0;
    }

    PlayerFour(String playerFourName){
        this.playerFourName = playerFourName;
    }
    public void setPlayerFourName(String playerFourName){ this.playerFourName = playerFourName;
    }
    public String getPlayerFourName(){return playerFourName;}
}
