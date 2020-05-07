//Class keeping track of infected squares, player movement, and the board in general

import org.w3c.dom.html.HTMLObjectElement;

import javax.swing.*;

public class GameBoard {

    RandomNum rando = new RandomNum();
    public int numOfVectors = 0;

    public int v1x = -50, v1y = -50, v2x = -50, v2y = -50, v3x = -50, v3y = -50, v4x = -50, v4y = -50, v5x = -50, v5y = -50, v6x = -50, v6y = -50, v1d = -1, v2d = -1, v3d = -1, v4d = -1, v5d = -1, v6d = -1;
    public boolean v1 = false, v2 = false, v3 = false, v4 = false, v5 = false, v6 = false;

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
        String quarantinedSpots = "";
        for (int x = 0; x < 3; x++){
            int xQ = rando.outOfTen();
            int yQ = rando.outOfTen();
            int getBoard = getGameboard(xQ,yQ);
            while(getBoard != 0){
                xQ=rando.outOfTen();
                yQ = rando.outOfTen();
                getBoard = getGameboard(xQ,yQ);
            }
            setGameboard(xQ ,yQ ,13);
            quarantinedSpots += "(" + xQ + "," + yQ + ") ";
        }
        JOptionPane.showMessageDialog(null, quarantinedSpots);
    }

    public void setV1x(int v1x) {
        this.v1x = v1x;
    }

    public void setV1y(int v1y) {
        this.v1y = v1y;
    }

    public void setV2x(int v2x) {
        this.v2x = v2x;
    }

    public void setV2y(int v2y) {
        this.v2y = v2y;
    }

    public void setV3x(int v3x) {
        this.v3x = v3x;
    }

    public void setV3y(int v3y) {
        this.v3y = v3y;
    }

    public void setV4x(int v4x) {
        this.v4x = v4x;
    }

    public void setV4y(int v4y) {
        this.v4y = v4y;
    }

    public void setV5x(int v5x) {
        this.v5x = v5x;
    }

    public void setV5y(int v5y) {
        this.v5y = v5y;
    }

    public void setV6x(int v6x) {
        this.v6x = v6x;
    }

    public void setV6y(int v6y) {
        this.v6y = v6y;
    }

    public void initialInfectionAndSetStores(){
        RandomNum randonum = new RandomNum();
        int foodStoreCounter = 0, supplyStoreCounter = 0, initialInfectionsCounter = 0, initialVectors = 0;
        String initialInfections = "", foodLocations = "", supplyLocations = "", vectorLocations = "";
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
            do{
                int x = randonum.outOfTen();
                int y = randonum.outOfTen();

                if(gameboard[x][y] == 0){
                    addVector(x, y);
                    setV1x(x);
                    setV1y(y);
                    initialVectors++;
                }
            } while(initialVectors < 1);

            initialVectors = 0;
        do{
            int x = randonum.outOfTen();
            int y = randonum.outOfTen();

            if(gameboard[x][y] == 0){
                addVector(x, y);
                setV2x(x);
                setV2y(y);
                initialVectors++;
            }
        } while(initialVectors < 1);

        JOptionPane.showMessageDialog(null, "Initial infected areas: " + initialInfections);
        JOptionPane.showMessageDialog(null, "Food store locations: " + foodLocations);
        JOptionPane.showMessageDialog(null, "Supply store locations: " + supplyLocations);
    }


    //Vectors

    public void addVector(int x, int y){

        if(!v1){
            v1x = x;
            v1y = y;
            v1d = rando.fourSidedDie();
            v1 = true;
            String toAdd = "";
            if(v1d == 1){
                toAdd = "right";
            } else if(v1d == 2){
                toAdd = "left";
            } else if(v1d == 3){
                toAdd = "up";
            } else if(v1d == 4){
                toAdd = "down";
            }
            JOptionPane.showMessageDialog(null,"Vector created at (" + v1x + "," + v1y + "). Direction: " + toAdd);
        }
        else if(!v2){
            v2x = x;
            v2y = y;
            v2d = rando.fourSidedDie();
            v2 = true;
            String toAdd = "";
            if(v2d == 1){
                toAdd = "right";
            } else if(v2d == 2){
                toAdd = "left";
            } else if(v2d == 3){
                toAdd = "up";
            } else if(v2d == 4){
                toAdd = "down";
            }
            JOptionPane.showMessageDialog(null,"Vector created at (" + v2x + "," + v2y + "). Direction: " + toAdd);
        }
        else if(!v3){
            v3x = x;
            v3y = y;
            v3d = rando.fourSidedDie();
            v3 = true;
            String toAdd = "";
            if(v3d == 1){
                toAdd = "right";
            } else if(v3d == 2){
                toAdd = "left";
            } else if(v3d == 3){
                toAdd = "up";
            } else if(v3d == 4){
                toAdd = "down";
            }
            JOptionPane.showMessageDialog(null,"Vector created at (" + v3x + "," + v3y + "). Direction: " + toAdd);
        }
        else if(!v4){
            v4x = x;
            v4y = y;
            v4d = rando.fourSidedDie();
            v4 = true;
            String toAdd = "";
            if(v4d == 1){
                toAdd = "right";
            } else if(v4d == 2){
                toAdd = "left";
            } else if(v4d == 3){
                toAdd = "up";
            } else if(v4d == 4){
                toAdd = "down";
            }
            JOptionPane.showMessageDialog(null,"Vector created at (" + v4x + "," + v4y + "). Direction: " + toAdd);
        } else if(!v5){
            v5x = x;
            v5y = y;
            v5d = rando.fourSidedDie();
            v5 = true;
            String toAdd = "";
            if(v5d == 1){
                toAdd = "right";
            } else if(v5d == 2){
                toAdd = "left";
            } else if(v5d == 3){
                toAdd = "up";
            } else if(v5d == 4){
                toAdd = "down";
            }
            JOptionPane.showMessageDialog(null,"Vector created at (" + v5x + "," + v5y + "). Direction: " + toAdd);
        } else if(!v6){
            v6x = x;
            v6y = y;
            v6d = rando.fourSidedDie();
            v6 = true;
            String toAdd = "";
            if(v6d == 1){
                toAdd = "right";
            } else if(v6d == 2){
                toAdd = "left";
            } else if(v6d == 3){
                toAdd = "up";
            } else if(v6d == 4){
                toAdd = "down";
            }
            JOptionPane.showMessageDialog(null,"Vector created at (" + v6x + "," + v5y + "). Direction: " + toAdd);
        }
    }
    public void deleteVector(){
        boolean vectorDeleted = false;
        if(v1 || v2 || v3 || v4 || v5 || v6){
        while(vectorDeleted = false) {
            int v = rando.diceRoll();
            if (v == 1) {
                JOptionPane.showMessageDialog(null, "Vector 1 Deleted.");
                v1x = -50;
                v1y = -50;
                v1d = -1;
                v1 = false;
                vectorDeleted = true;
            } else if (v == 2) {
                JOptionPane.showMessageDialog(null, "Vector 2 Deleted.");
                v2x = -50;
                v2y = -50;
                v2d = -1;
                v2 = false;
                vectorDeleted = true;
            } else if (v == 3) {
                JOptionPane.showMessageDialog(null, "Vector 3 Deleted.");
                v3x = -50;
                v3y = -50;
                v3d = -1;
                v3 = false;
                vectorDeleted = true;
            } else if (v == 4) {
                JOptionPane.showMessageDialog(null, "Vector 4 Deleted.");
                v4x = -50;
                v4y = -50;
                v4d = -1;
                v4 = false;
                vectorDeleted = true;
            } else if (v == 5) {
                JOptionPane.showMessageDialog(null, "Vector 5 Deleted.");
                v5x = -50;
                v5y = -50;
                v5d = -1;
                v5 = false;
                vectorDeleted = true;
            } else if (v == 6) {
                JOptionPane.showMessageDialog(null, "Vector 6 Deleted.");
                v6x = -50;
                v6y = -50;
                v6d = -1;
                v6 = false;
                vectorDeleted = true;
            }
        }
        } else{
            JOptionPane.showMessageDialog(null,"There are no vectors currently in play, so no vectors may be deleted.");
        }
    }

    public int getNumOfVectors(){
        int num = 0;
        if(v1){
            num++;
        }
        if(v2){
            num++;
        }
        if(v3){
            num++;
        }
        if(v4){
            num++;
        }
        if (v5) {
            num++;
        }
        if(v6){
            num++;
        }
        return num;
    }

    public int getV1x() {
        return v1x;
    }

    public int getV2x() {
        return v2x;
    }

    public int getV3x() {
        return v3x;
    }

    public int getV4x() {
        return v4x;
    }

    public int getV5x() {
        return v5x;
    }

    public int getV6x() {
        return v6x;
    }

    public String vectorOne(){
        if(v1x > -50 && v1y > -50 && v1d != -1){
            boolean dChange = false;
            if(v1y == 9 && v1d == 1){
                v1d = 3;
            }
            if (v1y == 0 && v1d == 2){
                v1d = 4;
            }
            if(v1x == 0 && v1d == 3){
                v1d = 1;
            }
            if(v1x == 9 && v1d == 4){
                v1d = 2;
            }
            if(v1x == 0 && v1y == 0){
                v1d = 1;
            }
            if(v1x == 9 && v1y == 0){
                v1d = 2;
            }
            if(v1x == 0 && v1y == 0){
                v1d = 1;
            }
            if(v1x == 9 && v1y == 9){
                v1d = 2;
            }
            if(v1d == 1){
                v1y++;
                int gB = getGameboard(v1x, v1y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v1x, v1y, gB + 1);
                }
                if(gB == 13){
                    v1y--;
                    dChange = true;
                }
            } else if (v1d == 2){
                v1y--;
                int gB = getGameboard(v1x, v1y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v1x, v1y, gB + 1);
                }
                if(gB == 13){
                    v1y++;
                    dChange = true;
                }
            } else if(v1d == 3){
                v1x--;
                int gB = getGameboard(v1x, v1y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v1x, v1y, gB + 1);
                }
                if(gB == 13){
                    v1x++;
                    dChange = true;
                }
            } else if(v1d == 4){
                v1x++;
                int gB = getGameboard(v1x, v1y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v1x, v1y, gB + 1);
                }
                if(gB == 13){
                    v1x--;
                    dChange = true;
                }
            }

            if(dChange){
                if(v1d == 1){
                    v1d = 2;
                } else if(v1d == 2){
                    v1d = 1;
                } else if(v1d == 3){
                    v1d = 4;
                } else if(v1d == 4){
                    v1d = 3;
                }
            }
            if(v1y == 9 && v1d == 1){
                v1d = 3;
            }
            if (v1y == 0 && v1d == 2){
                v1d = 4;
            }
            if(v1x == 0 && v1d == 3){
                v1d = 1;
            }
            if(v1x == 9 && v1d == 4){
                v1d = 2;
            }
            if(v1x == 0 && v1y == 0){
                v1d = 1;
            }
            if(v1x == 9 && v1y == 0){
                v1d = 2;
            }
            if(v1x == 0 && v1y == 0){
                v1d = 1;
            }
            if(v1x == 9 && v1y == 9){
                v1d = 2;
            }

            //Vector change direction?
            int changeD = rando.diceRoll();
            if(changeD == 1){
                v1d++;
                if(v1d == 5){
                    v1d = 1;
                }
            } else if(changeD == 2){
                v1d--;
                if(v1d == 0){
                    v1d = 4;
                }
            }
            if(v1y == 9 && v1d == 1){
                v1d = 3;
            }
            if (v1y == 0 && v1d == 2){
                v1d = 4;
            }
            if(v1x == 0 && v1d == 3){
                v1d = 1;
            }
            if(v1x == 9 && v1d == 4){
                v1d = 2;
            }
            if(v1x == 0 && v1y == 0){
                v1d = 1;
            }
            if(v1x == 9 && v1y == 0){
                v1d = 2;
            }
            if(v1x == 0 && v1y == 0){
                v1d = 1;
            }
            if(v1x == 9 && v1y == 9){
                v1d = 2;
            }
            String direction = "";
            if(v1d == 1){
                direction = "right";
            } else if (v1d == 2){
                direction = "left";
            } else if (v1d == 3){
                direction = "up";
            } else if(v1d == 4){
                direction = "down";
            }


        }
        String toreturn = "";
        String v1dTXT = "";
        if(v1d == 1){
            v1dTXT = "right";
        }
        else if(v1d == 2){
            v1dTXT = "left";
        } else if(v1d == 3){
            v1dTXT = "up";
        } else{
            v1dTXT = "left";
        }
        toreturn = "New vector infected: (" + v1x + "," + v1y + ")\nMove Vector One to this location. Direction: " + v1dTXT;
        return toreturn;
    }
    public String vectorTwo(){
        if(v2x != -50 && v2y != -50 && v2d != -1){
            boolean dChange = false;
            if(v2y == 9 && v2d == 1){
                v2d = 3;
            }
            if (v2y == 0 && v2d == 2){
                v2d = 4;
            }
            if(v2x == 0 && v2d == 3){
                v2d = 1;
            }
            if(v2x == 9 && v2d == 4){
                v2d = 2;
            }
            if(v2x == 0 && v2y == 0){
                v2d = 1;
            }
            if(v2x == 9 && v2y == 0){
                v2d = 2;
            }
            if(v2x == 0 && v2y == 0){
                v2d = 1;
            }
            if(v2x == 9 && v2y == 9){
                v2d = 2;
            }
            if(v2d == 1){
                v2y++;
                int gB = getGameboard(v2x, v2y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v2x, v2y, gB + 1);
                }
                if(gB == 13){
                    v2y--;
                    dChange = true;
                }
            } else if (v2d == 2){
                v2y--;
                int gB = getGameboard(v2x, v2y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v2x, v2y, gB + 1);
                }
                if(gB == 13){
                    v2y++;
                    dChange = true;
                }
            } else if(v2d == 3){
                v2x--;
                int gB = getGameboard(v2x, v2y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v2x, v2y, gB + 1);
                }
                if(gB == 13){
                    v2x++;
                    dChange = true;
                }
            } else if(v2d == 4){
                v2x++;
                int gB = getGameboard(v2x, v2y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v2x, v2y, gB + 1);
                }
                if(gB == 13){
                    v2x--;
                    dChange = true;
                }
            }

            if(dChange){
                if(v2d == 1){
                    v2d = 2;
                } else if(v2d == 2){
                    v2d = 1;
                } else if(v2d == 3){
                    v2d = 4;
                } else if(v2d == 4){
                    v2d = 3;
                }
            }
            if(v2y == 9 && v2d == 1){
                v2d = 3;
            }
            if (v2y == 0 && v2d == 2){
                v2d = 4;
            }
            if(v2x == 0 && v2d == 3){
                v2d = 1;
            }
            if(v2x == 9 && v2d == 4){
                v2d = 2;
            }
            if(v2x == 0 && v2y == 0){
                v2d = 1;
            }
            if(v2x == 9 && v2y == 0){
                v2d = 2;
            }
            if(v2x == 0 && v2y == 0){
                v2d = 1;
            }
            if(v2x == 9 && v2y == 9){
                v2d = 2;
            }

            //Vector change direction?
            int changeD = rando.diceRoll();
            if(changeD == 1){
                v2d++;
                if(v2d == 5){
                    v2d = 1;
                }
            } else if(changeD == 2){
                v2d--;
                if(v2d == 0){
                    v2d = 4;
                }
            }
            if(v2y == 9 && v2d == 1){
                v2d = 3;
            }
            if (v2y == 0 && v2d == 2){
                v2d = 4;
            }
            if(v2x == 0 && v2d == 3){
                v2d = 1;
            }
            if(v2x == 9 && v2d == 4){
                v2d = 2;
            }
            if(v2x == 0 && v2y == 0){
                v2d = 1;
            }
            if(v2x == 9 && v2y == 0){
                v2d = 2;
            }
            if(v2x == 0 && v2y == 0){
                v2d = 1;
            }
            if(v2x == 9 && v2y == 9){
                v2d = 2;
            }
            String direction = "";
            if(v2d == 1){
                direction = "right";
            } else if (v2d == 2){
                direction = "left";
            } else if (v2d == 3){
                direction = "up";
            } else if(v2d == 4){
                direction = "down";
            }


        }
        String toreturn = "";
        String v2dTXT = "";
        if(v1d == 1){
            v2dTXT = "right";
        }
        else if(v1d == 2){
            v2dTXT = "left";
        } else if(v1d == 3){
            v2dTXT = "up";
        } else{
            v2dTXT = "left";
        }
        toreturn = "New vector infected: (" + v2x + "," + v2y + ")\nMove Vector Two to this location. Direction: " + v2dTXT;
        return toreturn;
    }
    public String vectorThree(){
        if(v3x > -1 && v3y > -1 && v3d != -1){
            boolean dChange = false;
            if(v3y == 9 && v3d == 1){
                v3d = 3;
            }
            if (v3y == 0 && v3d == 2){
                v3d = 4;
            }
            if(v3x == 0 && v3d == 3){
                v3d = 1;
            }
            if(v3x == 9 && v3d == 4){
                v3d = 2;
            }
            if(v3x == 0 && v3y == 0){
                v3d = 1;
            }
            if(v3x == 9 && v3y == 0){
                v3d = 2;
            }
            if(v3x == 0 && v3y == 0){
                v3d = 1;
            }
            if(v3x == 9 && v3y == 9){
                v3d = 2;
            }
            if(v3d == 1){
                v3y++;
                int gB = getGameboard(v3x, v3y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v3x, v3y, gB + 1);
                }
                if(gB == 13){
                    v3y--;
                    dChange = true;
                }
            } else if (v3d == 2){
                v3y--;
                int gB = getGameboard(v3x, v3y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v3x, v3y, gB + 1);
                }
                if(gB == 13){
                    v3y++;
                    dChange = true;
                }
            } else if(v3d == 3){
                v3x--;
                int gB = getGameboard(v3x, v3y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v3x, v3y, gB + 1);
                }
                if(gB == 13){
                    v3x++;
                    dChange = true;
                }
            } else if(v3d == 4){
                v3x++;
                int gB = getGameboard(v3x, v3y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v3x, v3y, gB + 1);
                }
                if(gB == 13){
                    v3x--;
                    dChange = true;
                }
            }

            if(dChange){
                if(v3d == 1){
                    v3d = 2;
                } else if(v3d == 2){
                    v3d = 1;
                } else if(v3d == 3){
                    v3d = 4;
                } else if(v3d == 4){
                    v3d = 3;
                }
            }
            if(v3y == 9 && v3d == 1){
                v3d = 3;
            }
            if (v3y == 0 && v3d == 2){
                v3d = 4;
            }
            if(v3x == 0 && v3d == 3){
                v3d = 1;
            }
            if(v3x == 9 && v3d == 4){
                v3d = 2;
            }
            if(v3x == 0 && v3y == 0){
                v3d = 1;
            }
            if(v3x == 9 && v3y == 0){
                v3d = 2;
            }
            if(v3x == 0 && v3y == 0){
                v3d = 1;
            }
            if(v3x == 9 && v3y == 9){
                v3d = 2;
            }

            //Vector change direction?
            int changeD = rando.diceRoll();
            if(changeD == 1){
                v3d++;
                if(v3d == 5){
                    v3d = 1;
                }
            } else if(changeD == 2){
                v3d--;
                if(v3d == 0){
                    v3d = 4;
                }
            }
            if(v3y == 9 && v3d == 1){
                v3d = 3;
            }
            if (v3y == 0 && v3d == 2){
                v3d = 4;
            }
            if(v3x == 0 && v3d == 3){
                v3d = 1;
            }
            if(v3x == 9 && v3d == 4){
                v3d = 2;
            }
            if(v3x == 0 && v3y == 0){
                v3d = 1;
            }
            if(v3x == 9 && v3y == 0){
                v3d = 2;
            }
            if(v3x == 0 && v3y == 0){
                v3d = 1;
            }
            if(v3x == 9 && v3y == 9){
                v3d = 2;
            }
            String direction = "";
            if(v3d == 1){
                direction = "right";
            } else if (v3d == 2){
                direction = "left";
            } else if (v3d == 3){
                direction = "up";
            } else if(v3d == 4){
                direction = "down";
            }


        }
        String toreturn = "";
        String v3dTXT = "";
        if(v1d == 1){
            v3dTXT = "right";
        }
        else if(v1d == 2){
            v3dTXT = "left";
        } else if(v1d == 3){
            v3dTXT = "up";
        } else{
            v3dTXT = "left";
        }
        toreturn = "New vector infected: (" + v3x + "," + v3y + ")\nMove Vector Three to this location. Direction: " + v3dTXT;
        return toreturn;
    }
    public String vectorFour(){
        if(v4x > -1 && v4y > -1 && v4d != -1){
            boolean dChange = false;
            if(v4y == 9 && v4d == 1){
                v4d = 3;
            }
            if (v4y == 0 && v4d == 2){
                v4d = 4;
            }
            if(v4x == 0 && v4d == 3){
                v4d = 1;
            }
            if(v4x == 9 && v4d == 4){
                v4d = 2;
            }
            if(v4x == 0 && v4y == 0){
                v4d = 1;
            }
            if(v4x == 9 && v4y == 0){
                v4d = 2;
            }
            if(v4x == 0 && v4y == 0){
                v4d = 1;
            }
            if(v4x == 9 && v4y == 9){
                v4d = 2;
            }
            if(v4d == 1){
                v4y++;
                int gB = getGameboard(v4x, v4y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v4x, v4y, gB + 1);
                }
                if(gB == 13){
                    v4y--;
                    dChange = true;
                }
            } else if (v4d == 2){
                v4y--;
                int gB = getGameboard(v4x, v4y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v4x, v4y, gB + 1);
                }
                if(gB == 13){
                    v4y++;
                    dChange = true;
                }
            } else if(v4d == 3){
                v4x--;
                int gB = getGameboard(v4x, v4y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v4x, v4y, gB + 1);
                }
                if(gB == 13){
                    v4x++;
                    dChange = true;
                }
            } else if(v4d == 4){
                v4x++;
                int gB = getGameboard(v4x, v4y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v4x, v4y, gB + 1);
                }
                if(gB == 13){
                    v4x--;
                    dChange = true;
                }
            }

            if(dChange){
                if(v4d == 1){
                    v4d = 2;
                } else if(v4d == 2){
                    v4d = 1;
                } else if(v4d == 3){
                    v4d = 4;
                } else if(v4d == 4){
                    v4d = 3;
                }
            }
            if(v4y == 9 && v4d == 1){
                v4d = 3;
            }
            if (v4y == 0 && v4d == 2){
                v4d = 4;
            }
            if(v4x == 0 && v4d == 3){
                v4d = 1;
            }
            if(v4x == 9 && v4d == 4){
                v4d = 2;
            }
            if(v4x == 0 && v4y == 0){
                v4d = 1;
            }
            if(v4x == 9 && v4y == 0){
                v4d = 2;
            }
            if(v4x == 0 && v4y == 0){
                v4d = 1;
            }
            if(v4x == 9 && v4y == 9){
                v4d = 2;
            }

            //Vector change direction?
            int changeD = rando.diceRoll();
            if(changeD == 1){
                v4d++;
                if(v4d == 5){
                    v4d = 1;
                }
            } else if(changeD == 2){
                v4d--;
                if(v4d == 0){
                    v4d = 4;
                }
            }
            if(v4y == 9 && v4d == 1){
                v4d = 3;
            }
            if (v4y == 0 && v4d == 2){
                v4d = 4;
            }
            if(v4x == 0 && v4d == 3){
                v4d = 1;
            }
            if(v4x == 9 && v4d == 4){
                v4d = 2;
            }
            if(v4x == 0 && v4y == 0){
                v4d = 1;
            }
            if(v4x == 9 && v4y == 0){
                v4d = 2;
            }
            if(v4x == 0 && v4y == 0){
                v4d = 1;
            }
            if(v4x == 9 && v4y == 9){
                v4d = 2;
            }
            String direction = "";
            if(v4d == 1){
                direction = "right";
            } else if (v4d == 2){
                direction = "left";
            } else if (v4d == 3){
                direction = "up";
            } else if(v4d == 4){
                direction = "down";
            }

        }
        String toreturn = "";
        String v4dTXT = "";
        if(v1d == 1){
            v4dTXT = "right";
        }
        else if(v1d == 2){
            v4dTXT = "left";
        } else if(v1d == 3){
            v4dTXT = "up";
        } else{
            v4dTXT = "left";
        }
        toreturn = "New vector infected: (" + v4x + "," + v4y + ")\nMove Vector Four to this location. Direction: " + v4dTXT;
        return toreturn;
    }
    public String vectorFive(){
        if(v5x > -1 && v5y > -1 && v5d != -1){
            boolean dChange = false;
            if(v5y == 9 && v5d == 1){
                v5d = 3;
            }
            if (v5y == 0 && v5d == 2){
                v5d = 4;
            }
            if(v5x == 0 && v5d == 3){
                v5d = 1;
            }
            if(v5x == 9 && v5d == 4){
                v5d = 2;
            }
            if(v5x == 0 && v5y == 0){
                v5d = 1;
            }
            if(v5x == 9 && v5y == 0){
                v5d = 2;
            }
            if(v5x == 0 && v5y == 0){
                v5d = 1;
            }
            if(v5x == 9 && v5y == 9){
                v5d = 2;
            }
            if(v5d == 1){
                v5y++;
                int gB = getGameboard(v5x, v5y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v5x, v5y, gB + 1);
                }
                if(gB == 13){
                    v5y--;
                    dChange = true;
                }
            } else if (v5d == 2){
                v5y--;
                int gB = getGameboard(v5x, v5y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v5x, v5y, gB + 1);
                }
                if(gB == 13){
                    v5y++;
                    dChange = true;
                }
            } else if(v5d == 3){
                v5x--;
                int gB = getGameboard(v5x, v5y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v5x, v5y, gB + 1);
                }
                if(gB == 13){
                    v5x++;
                    dChange = true;
                }
            } else if(v5d == 4){
                v5x++;
                int gB = getGameboard(v5x, v5y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v5x, v5y, gB + 1);
                }
                if(gB == 13){
                    v5x--;
                    dChange = true;
                }
            }

            if(dChange){
                if(v5d == 1){
                    v5d = 2;
                } else if(v5d == 2){
                    v5d = 1;
                } else if(v5d == 3){
                    v5d = 4;
                } else if(v5d == 4){
                    v5d = 3;
                }
            }
            if(v5y == 9 && v5d == 1){
                v5d = 3;
            }
            if (v5y == 0 && v5d == 2){
                v5d = 4;
            }
            if(v5x == 0 && v5d == 3){
                v5d = 1;
            }
            if(v5x == 9 && v5d == 4){
                v5d = 2;
            }
            if(v5x == 0 && v5y == 0){
                v5d = 1;
            }
            if(v5x == 9 && v5y == 0){
                v5d = 2;
            }
            if(v5x == 0 && v5y == 0){
                v5d = 1;
            }
            if(v5x == 9 && v5y == 9){
                v5d = 2;
            }

            //Vector change direction?
            int changeD = rando.diceRoll();
            if(changeD == 1){
                v5d++;
                if(v5d == 5){
                    v5d = 1;
                }
            } else if(changeD == 2){
                v5d--;
                if(v5d == 0){
                    v5d = 4;
                }
            }
            if(v5y == 9 && v5d == 1){
                v5d = 3;
            }
            if (v5y == 0 && v5d == 2){
                v5d = 4;
            }
            if(v5x == 0 && v5d == 3){
                v5d = 1;
            }
            if(v5x == 9 && v5d == 4){
                v5d = 2;
            }
            if(v5x == 0 && v5y == 0){
                v5d = 1;
            }
            if(v5x == 9 && v5y == 0){
                v5d = 2;
            }
            if(v5x == 0 && v5y == 0){
                v5d = 1;
            }
            if(v5x == 9 && v5y == 9){
                v5d = 2;
            }

        }
        String toreturn = "";
        String v5dTXT = "";
        if(v1d == 1){
            v5dTXT = "right";
        }
        else if(v1d == 2){
            v5dTXT = "left";
        } else if(v1d == 3){
            v5dTXT = "up";
        } else{
            v5dTXT = "left";
        }
        toreturn = "New vector infected: (" + v5x + "," + v5y + ")\nMove Vector Five to this location. Direction: " + v5dTXT;
        return toreturn;
    }
    public String vectorSix(){
        if(v6x > -1 && v6y > -1 && v6d != -1){
            boolean dChange = false;
            if(v6y == 9 && v6d == 1){
                v6d = 3;
            }
            if (v6y == 0 && v6d == 2){
                v6d = 4;
            }
            if(v6x == 0 && v6d == 3){
                v6d = 1;
            }
            if(v6x == 9 && v6d == 4){
                v6d = 2;
            }
            if(v6x == 0 && v6y == 0){
                v6d = 1;
            }
            if(v6x == 9 && v6y == 0){
                v6d = 2;
            }
            if(v6x == 0 && v6y == 0){
                v6d = 1;
            }
            if(v6x == 9 && v6y == 9){
                v6d = 2;
            }
            if(v6d == 1){
                v6y++;
                int gB = getGameboard(v6x, v6y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v6x, v6y, gB + 1);
                }
                if(gB == 13){
                    v6y--;
                    dChange = true;
                }
            } else if (v6d == 2){
                v6y--;
                int gB = getGameboard(v6x, v6y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v6x, v6y, gB + 1);
                }
                if(gB == 13){
                    v6y++;
                    dChange = true;
                }
            } else if(v6d == 3){
                v6x--;
                int gB = getGameboard(v6x, v6y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v6x, v6y, gB + 1);
                }
                if(gB == 13){
                    v6x++;
                    dChange = true;
                }
            } else if(v6d == 4){
                v6x++;
                int gB = getGameboard(v6x, v6y);
                if(gB == 0 || gB == 4 || gB == 8){
                    setGameboard(v6x, v6y, gB + 1);
                }
                if(gB == 13){
                    v6x--;
                    dChange = true;
                }
            }

            if(dChange){
                if(v6d == 1){
                    v6d = 2;
                } else if(v6d == 2){
                    v6d = 1;
                } else if(v6d == 3){
                    v6d = 4;
                } else if(v6d == 4){
                    v6d = 3;
                }
            }
            if(v6y == 9 && v6d == 1){
                v6d = 3;
            }
            if (v6y == 0 && v6d == 2){
                v6d = 4;
            }
            if(v6x == 0 && v6d == 3){
                v6d = 1;
            }
            if(v6x == 9 && v6d == 4){
                v6d = 2;
            }
            if(v6x == 0 && v6y == 0){
                v6d = 1;
            }
            if(v6x == 9 && v6y == 0){
                v6d = 2;
            }
            if(v6x == 0 && v6y == 0){
                v6d = 1;
            }
            if(v6x == 9 && v6y == 9){
                v6d = 2;
            }

            //Vector change direction?
            int changeD = rando.diceRoll();
            if(changeD == 1){
                v6d++;
                if(v6d == 5){
                    v6d = 1;
                }
            } else if(changeD == 2){
                v6d--;
                if(v6d == 0){
                    v6d = 4;
                }
            }
            if(v6y == 9 && v6d == 1){
                v6d = 3;
            }
            if (v6y == 0 && v6d == 2){
                v6d = 4;
            }
            if(v6x == 0 && v6d == 3){
                v6d = 1;
            }
            if(v6x == 9 && v6d == 4){
                v6d = 2;
            }
            if(v6x == 0 && v6y == 0){
                v6d = 1;
            }
            if(v6x == 9 && v6y == 0){
                v6d = 2;
            }
            if(v6x == 0 && v6y == 0){
                v6d = 1;
            }
            if(v6x == 9 && v6y == 9){
                v6d = 2;
            }
            String direction = "";
            if(v6d == 1){
                direction = "right";
            } else if (v6d == 2){
                direction = "left";
            } else if (v6d == 3){
                direction = "up";
            } else if(v6d == 4){
                direction = "down";
            }


        }
        String toreturn = "";
        String v6dTXT = "";
        if(v1d == 1){
            v6dTXT = "right";
        }
        else if(v1d == 2){
            v6dTXT = "left";
        } else if(v1d == 3){
            v6dTXT = "up";
        } else{
            v6dTXT = "left";
        }
        toreturn = "New vector infected: (" + v6x + "," + v6y + ")\nMove Vector Six to this location. Direction: " + v6dTXT;
        return toreturn;
    }









}
