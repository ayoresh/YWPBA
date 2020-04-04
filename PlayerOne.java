//This file will be used to manipulate the first player's character



public class PlayerOne {

    public String playerOneName;
    public int infection;

    PlayerOne(){
        playerOneName = "";
        infection = 0;
    }

    PlayerOne(String playerOneName){
        this.playerOneName = playerOneName;
    }

    public void setPlayerOneName(String playerOneName){
        this.playerOneName = playerOneName;
    }
    public String getPlayerOneName(){return playerOneName;}

}
