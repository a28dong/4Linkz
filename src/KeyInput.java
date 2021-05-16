import java.awt.event.*;

//The KeyInput class for controlling keyboard listeners and user input
//Allows the program to respond to keyboard inputs

//Creates a subclass to access the Superclass methods
public class KeyInput extends KeyAdapter {

    /**
     * Responds the keyboard pressing
     * pre: none
     * post: Program responds based on specific inputs.
     */
    public void keyPressed(KeyEvent e){

        //Checks whether the game is ready to accept inputs
        if (Main4LinkZ.linkZ.getKeyDisable() == false){

            //Checks the key pressed and organizes accordingly
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                Main4LinkZ.linkZ.rightShift(); //Calls upon the method to sync graphics

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                Main4LinkZ.linkZ.leftShift(); //Calls upon the method to sync graphics

            //Refreshes the graphics
            Main4LinkZ.linkZ.graphic.moveRefresh();

            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                Main4LinkZ.linkZ.setKeyDisable(true); //Disables key inputs
                Main4LinkZ.linkZ.startTurn(); //Starts the turn
            }
        }
    }
}