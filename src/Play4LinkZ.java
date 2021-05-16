//The main class for controlling and operating the game
//Accesses all other classes through objects and enables the game to run smoothly and in sync.

public class Play4LinkZ {
    //Object instantiation
    GameMechanics engine = new GameMechanics(); //Controls Mechanics of the game
    GameGraphics graphic = new GameGraphics();  //Controls Graphics
    Music song = new Music();   //Controls audio

    //Variable and Constant Declaration
    private int winP1 = 0, winP2 = 0; //Keeps track of numbers of wins
    private boolean game = true; //Keeps the game running
    private final int player1 = 1, player2 = 2; //Represents the players
    private boolean keyDisable = true; //Controls when the keyboard is active
    private int colNum, rowNum; //Provides information regarding placement of tokens
    private int counter, turn;  //Keeps track of the status of the game

    /**
     * Initiates the program by calling upon methods that organize the game
     * pre: none
     * post: The program will open.
     */
    public void start(){
        graphic.gameOn();
        song.menuPlay();
    }

    /**
     * Resets all necessary values so that the game may reset.
     * pre: none
     * post: The game is restarted from the beginning and values are reset.
     */
    public void newGame(){
        //Changes song
        song.stop();
        song.play();

        //Resets values
        keyDisable = false;
        game = true;
        turn = 1;
        counter = 1;
        colNum = 1;

        //Resets Graphics and Game Status
        engine.resetCord();
        graphic.resetGraphics();
        Main4LinkZ.linkZ.graphic.tokenOrange[1].setVisible(true);

        //Adjusts/Updates game text
        graphic.oWin.setText("" + winP1);
        graphic.oWin.setBounds(10,650,100,120);
        graphic.bWin.setText("" + winP2);
        graphic.bWin.setBounds(930,650,100,120);

        graphic.oMove.setText("");
        graphic.oMove.setBounds(50,215,150,50);
        graphic.bMove.setText("");
        graphic.bMove.setBounds(50,320,150,50);
    }

    /**
     * Carries out a turn in the game.
     * pre: none
     * post: The player's turn is initiated and then ended
     */
    public void startTurn(){
        //Calls upon a method to select the column
        selectCol(colNum);

        //Prepares graphics
        graphic.prep();

        //Determines whether the column is empty
        if (keyDisable == true){
            //Refreshes the graphics
            graphic.dropRefresh();
            //Checks the status of the game (ie if a player has won)
            engine.checkGame(turn);

            //Determines the winner
            if (game == false){
                switch (turn){
                    case 1: graphic.orangeWin.setVisible(true);
                        winP1++;
                        break;
                    case 2: graphic.blueWin.setVisible(true);
                        winP2++;
                        break;
                    case 3: graphic.tie.setVisible(true);
                        break;
                }
            }

            //Prepares the other player's turn
            if (game == true) {
                //Checks whose turn it is and adjusts accordingly
                if (turn == player1){
                    turn = player2;

                    //Refreshes the information
                    graphic.oMove.setText("[" + colNum + ", " + rowNum + "]");
                    graphic.oMove.setBounds(50,215,150,50);
                } else if (turn == player2){
                    turn = player1;
                    counter++;

                    //Refreshes the information
                    graphic.bMove.setText("[" + colNum + ", " + rowNum + "]");
                    graphic.bMove.setBounds(50,320,150,50);
                }
                keyDisable = false; //Allows keyboard inputs
                graphic.prep(); //Prepares graphics
            }
        }

    }

    /**
     * Checks if the column is full and calls upon the drop method if available
     * pre: none
     * post: A token has been placed or user is allowed to retry keyboard inputs.
     */
    public void selectCol(int col) {
        //Calls upon a method to check whether the column is full.
        if (!(engine.colFull(col)))
            engine.drop(col, turn);
        else if (engine.colFull(col))
            keyDisable = false;
    }

    /**
     * Adjusts the value of colNum to match the keyboard movement.
     * pre: none
     * post: The value of colNum has been increased.
     */
    public void rightShift(){
        colNum++;
        //Ensures that colNum cannot be greater than 7
        if (colNum>7)
            colNum=7;
    }

    /**
     * Adjusts the value of colNum to match the keyboard movement.
     * pre: none
     * post: The value of colNum has been decreased.
     */
    public void leftShift(){
        colNum--;
        //Ensures that colNum cannot be less than 1
        if (colNum<1)
            colNum=1;
    }

    /**
     * Changes the value of endGame to false.
     * pre: none
     * post: The value of endGame has been changed.
     */
    public void endGame() {
        game = false;
    }

    /**
     * Returns the value of getGame.
     * pre: none
     * post: The value of getGame has been returned.
     */
    public boolean getGame(){
        return(game);
    }

    /**
     * Returns the value of keyDisable.
     * pre: none
     * post: The value of keyDisable has been returned.
     */
    public boolean getKeyDisable(){
        return keyDisable;
    }

    /**
     * Changes the value of keyDisable.
     * pre: none
     * post: keyDisable has been changed.
     */
    public void setKeyDisable(boolean disable){
        keyDisable = disable;
    }

    /**
     * Changes the value of colNum.
     * pre: 0<col<8
     * post: colNum has been changed.
     */
    public void setCol(int col){
        colNum = col;
    }

    /**
     * Changes the value of rowNum.
     * pre: 0<row<8
     * post: rowNum has been changed.
     */
    public void setRow(int row){
        rowNum = row;
    }

    /**
     * Returns the value of colNum.
     * pre: none
     * post: The value of colNum has been returned.
     */
    public int getCol(){
        return(colNum);
    }

    /**
     * Returns the value of rowNum.
     * pre: none
     * post: The value of rowNum has been returned.
     */
    public int getRow(){
        return(rowNum);
    }

    /**
     * Returns the value of counter.
     * pre: none
     * post: The value of counter has been returned.
     */
    public int getCounter(){
        return(counter);
    }

    /**
     * Returns the value of turn.
     * pre: none
     * post: The value of turn has been returned.
     */
    public int getTurn(){
        return(turn);
    }

    /**
     * Changes the value of turn to force a tie.
     * pre: none
     * post: Turn has been changed.
     */
    public void tieGame(){
        turn = 3;
    }
}