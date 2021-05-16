//The mechanic class for implementing the concepts of the game
//Contains the methods so that the game functions

public class GameMechanics {
    //Variable and Constant declaration
    private final int maxCol = 7, maxRow = 7, minCol = 1;
    private int[][] tokenCord = new int[8][8];
    private boolean win;

    /**
     * Resets the values of all coordinates on the board
     * pre: none
     * post: The values have been reset
     */
    public void resetCord() {
        for (int row = 1; row <= 7; row++) {
            for (int col = 1; col <= 7; col++) {
                tokenCord[col][row] = 0;
            }
        }
    }

    //////////////////////////////////
    //DROPPING MECHANICS
    //////////////////////////////////

    /**
     * Checks for the first available location and places the token
     * pre: none
     * post: The token has been placed.
     */
    public void drop(int col, int player) {
        //For loop to move between rows
        for (int row = 1; row <= 7; row++) {
            //Checks if the location is unoccupied
            if (tokenCord[col][row] == 0) {
                tokenCord[col][row] = player; //Places the token
                Main4LinkZ.linkZ.setRow(row); //Adjusts row value
                break;
            }
        }
    }

    /**
     * Checks whether the column is full
     * pre: none
     * post: Returns true if full and false otherwise
     */
    public boolean colFull(int col) {
        //Checks each row of the column
        if (tokenCord[col][1] > 0 && tokenCord[col][2] > 0
                && tokenCord[col][3] > 0 && tokenCord[col][4] > 0
                && tokenCord[col][5] > 0 && tokenCord[col][6] > 0
                && tokenCord[col][7] > 0) {
            return (true);
        } else {
            return (false);
        }
    }

    //////////////////////////////////
    //WIN MECHANICS
    //////////////////////////////////

    /**
     * Checks whether the player has a line of 4
     * pre: none
     * post: The status of the game is checked
     */
    public void checkGame(int player) {

        //Ensures that the game is continuing before checking
        if (Main4LinkZ.linkZ.getGame() == true) {
            //Adjust the value by calling upon a method
            win = checkHorizontal(player);
            //Calls upon a method to end the game if player has won
            checkWin();
        }
        if (Main4LinkZ.linkZ.getGame() == true) {
            //Adjust the value by calling upon a method
            win = checkVertical(player);
            //Calls upon a method to end the game if player has won
            checkWin();
        }
        if (Main4LinkZ.linkZ.getGame() == true) {
            //Adjust the value by calling upon a method
            win = checkDiagonalF(player);
            //Calls upon a method to end the game if player has won
            checkWin();
        }
        if (Main4LinkZ.linkZ.getGame() == true) {
            //Adjust the value by calling upon a method
            win = checkDiagonalB(player);
            //Calls upon a method to end the game if player has won
            checkWin();
        }
        if (Main4LinkZ.linkZ.getGame() == true) {
            //Checks whether all pieces have been played
            checkTie();
        }
    }

    /**
     * Checks whether the player has a horizontal line of 4
     * pre: none
     * post: The status of the game is checked
     */
    public boolean checkHorizontal(int player) {
        //Checks each row
        for (int r = 1; r <= maxRow; r++)
            //Moves between columns
            for (int c = 1; c <= (maxCol - 3); c++) {
                //Checks whether 4 tokens are connected
                if (tokenCord[c][r] == player && tokenCord[c + 1][r] == player
                        && tokenCord[c + 2][r] == player
                        && tokenCord[c + 3][r] == player) {
                    return (true);
                }
            }
        return (false);
    }

    /**
     * Checks whether the player has a vertical line of 4
     * pre: none
     * post: The status of the game is checked
     */
    public boolean checkVertical(int player) {
        //Checks each column
        for (int c = 1; c <= maxCol; c++)
            //Moves between rows
            for (int r = 1; r <= (maxRow - 3); r++) {
                //Checks whether 4 tokens are connected
                if (tokenCord[c][r] == player && tokenCord[c][r + 1] == player
                        && tokenCord[c][r + 2] == player
                        && tokenCord[c][r + 3] == player) {
                    return (true);
                }
            }
        return (false);
    }

    /**
     * Checks whether the player has a diagonal line of 4 (FRONT)
     * pre: none
     * post: The status of the game is checked
     */
    public boolean checkDiagonalF(int player) {
        //Moves between rows
        for (int r = 1; r <= (maxRow - 3); r++) {
            //Moves between columns
            for (int c = 1; c <= (maxCol - 3); c++) {
                //Checks whether 4 tokens are connected
                if (tokenCord[c][r] == player && tokenCord[c + 1][r + 1] == player
                        && tokenCord[c + 2][r + 2] == player
                        && tokenCord[c + 3][r + 3] == player) {
                    return (true);
                }
            }
        }

        return (false);
    }

    /**
     * Checks whether the player has a diagonal line of 4 (BACK)
     * pre: none
     * post: The status of the game is checked
     */
    public boolean checkDiagonalB(int player) {
        //Moves between rows
        for (int r = 1; r <= (maxRow - 3); r++) {
            //Moves between columns
            for (int c = 7; c >= (minCol + 3); c--) {
                //Checks whether 4 tokens are connected
                if (tokenCord[c][r] == player && tokenCord[c - 1][r + 1] == player
                        && tokenCord[c - 2][r + 2] == player
                        && tokenCord[c - 3][r + 3] == player) {
                    return (true);
                }
            }
        }
        return (false);
    }

    /**
     * Checks whether a player has won and ends the game
     * pre: none
     * post: Ends the game if a player has won
     */
    public void checkWin() {
        if (win == true){
            Main4LinkZ.linkZ.endGame();
        }
    }

    /**
     * Checks whether there are no pieces left to play
     * pre: none
     * post: Ends the game if in a deadlock
     */
    public void checkTie() {
        int counter = 0;
        //Checks for every piece
        for (int row = 1; row <= 7; row++) {
            for (int col = 1; col <= 7; col++) {
                if (tokenCord[col][row] > 0)
                    counter++;
            }
        }
        //Ends the game if applicable
        if (counter == 49){
            Main4LinkZ.linkZ.endGame();
            Main4LinkZ.linkZ.tieGame();
        }
    }
}