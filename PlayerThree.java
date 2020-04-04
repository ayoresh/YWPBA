public class PlayerThree {
    public String playerThreeName;
    public int infection;

    PlayerThree(){
        playerThreeName = "";
        infection = 0;
    }


    PlayerThree(String playerThreeName){
        this.playerThreeName = playerThreeName;
    }

    public void setPlayerThreeName(String playerThreeName){
        this.playerThreeName = playerThreeName;
    }
    public String getPlayerThreeName(){return playerThreeName;}
}
