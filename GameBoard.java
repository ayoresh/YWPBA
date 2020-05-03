//Class keeping track of infected squares, player movement, and the board in general

import javax.swing.*;

public class GameBoard {

    RandomNum rando = new RandomNum();

    /**
     * 0 = uninfected spot
     * 1 = infected spot
     * 4 = uninfected food store
     * 5 = infected food store
     * 8 = uninfected supply store
     * 9 = infected supply store
     * 13 = quarantined space
     */

    GameBoard(){
        for(int x = 0; x < gameboard.length; x++){
            for (int y = 0; y < gameboard[x].length; y++){
                gameboard[x][y] = 0;
            }
        }
    }
    GameBoard(int[][] gameboard){
        this.gameboard = gameboard;
    }

    int[][] gameboard = new int[10][10];

    public int getGameboard(int x, int y){
        return gameboard[x][y];
    }

    public int[][] getGameboardArray(){
        return gameboard;
    }


    public void setGameboard(int x, int y, int z){
        gameboard[x][y] = z;
    }

    public void quarantineArea(int x, int y){
        gameboard[x][y] = 13;
    }

    public void governmentQuarantine(){
        for (int x = 0; x < 3; x++){
            int xQ = rando.outOfTen();
            int yQ = rando.outOfTen();
            int getBoard = getGameboard(xQ,yQ);
            while(getBoard == 13){
                xQ=rando.outOfTen();
                yQ = rando.outOfTen();
                getBoard = getGameboard(xQ,yQ);
            }
            setGameboard(xQ ,yQ ,13);
        }
    }

    public void initialInfectionAndSetStores(){
        RandomNum randonum = new RandomNum();
        int foodStoreCounter = 0, supplyStoreCounter = 0, initialInfectionsCounter = 0;
        String initialInfections = "", foodLocations = "", supplyLocations = "";
        //Set infected spots
        do{
            int x = randonum.outOfTen();
            int y = randonum.outOfTen();
            if (gameboard[x][y] == 0) {
                gameboard[x][y] = 1;
                String toAdd = "(" + x + "," + y + ") ";
                initialInfections += toAdd;
                initialInfectionsCounter++;
            }
        } while(initialInfectionsCounter < 4);

        //Set food stores

            do {
                int x = randonum.outOfTen();
                int y = randonum.outOfTen();

                if (gameboard[x][y] == 0) {
                    gameboard[x][y] = 4;
                    String toAdd = "(" + x + "," + y + ") ";
                    foodLocations += toAdd;
                    foodStoreCounter++;
                }
            }
            while(foodStoreCounter < 3);

            //Set Supply Stores
            do {
                int x = randonum.outOfTen();
                int y = randonum.outOfTen();

                if (gameboard[x][y] == 0) {
                    gameboard[x][y] = 8;
                    supplyStoreCounter++;
                    String toAdd = "(" + x + "," + y + ") ";
                    supplyLocations += toAdd;
                }
            }
            while(supplyStoreCounter < 3);

        JOptionPane.showMessageDialog(null, "Initial infected areas: " + initialInfections);
        JOptionPane.showMessageDialog(null, "Food store locations: " + foodLocations);
        JOptionPane.showMessageDialog(null, "Supply store locations: " + supplyLocations);
    }









}
