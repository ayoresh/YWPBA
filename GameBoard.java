//Class keeping track of infected squares, player movement, and the board in general

import javax.swing.*;

public class GameBoard {

    /**
     * 0 = uninfected spot
     * 1 = infected spot
     * 2 = inhabited uninfected spot
     * 3 = inhabited infected spot
     * 4 = uninfected food store
     * 5 = infected food store
     * 6 = inhabited uninfected food store
     * 7 = inhabited infected food store
     * 8 = uninfected supply store
     * 9 = infected supply store
     * 10 = inhabited uninfected supply store
     * 11 = inhabited infected supply store
     * 12 = home square
     */

    int[][] gameboard = new int[10][10];

    public int getGameboard(int x, int y){
        return gameboard[x][y];
    }

    public void setGameboard(int x, int y, int z){
        gameboard[x][y] = z;
    }


    public void initialInfectionAndSetStores(){
        RandomNum randonum = new RandomNum();
        int foodStoreCounter = 0, supplyStoreCounter = 0;
        String initialInfections = "", foodLocations = "", supplyLocations = "";
        //Set infected spots
        for (int counter = 0; counter < 4; counter++){
            int x = randonum.outOfTen();
            int y = randonum.outOfTen();
            if (gameboard[x][y] == 0) {
                gameboard[x][y] = 1;
                String toAdd = "(" + x + "," + y + ") ";
                initialInfections += toAdd;
            }
        }

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
