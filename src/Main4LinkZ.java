//Main4LinkZ.java
//Developed by Andrew Dong
//November 27, 2018
//Mr Kordbacheh   ICS4U    L'Amoreaux C.I.

/* Two-Player Game: 4LinkZ (modified version of Connect 4)
 *
 * OBJECTIVE:
 * The objective of this game is to have four tokens/pieces (of your own individual colour)
 * aligned together in such a way that they form a straight line.
 * For Example:
 * Horizontal       Vertical        Diagonal
 * o o o o             o             o
 *                     o               o
 *                     o				 o
 *                     o   				   o
 *
 * Note: Diagonal can be formed from both angles whether it'd forward or backward
 *
 * GAMEPLAY:
 * Players take turns dropping tokens* of their colour in a 7 by 7 grid.
 * The game concludes when the first player clears the objective fore-mentioned earlier.
 * Player 1 begins the game and is allowed to drop the first token.
 *
 * Player 1 is represented by Orange and Player 2 is represented by Blue.
 *
 * *Dropping tokens follows gravity physics in which tokens will drop to the first available
 * 	location in the selected column.
 *
 * Controls/How to Play:
 * The are there 3 main controls in playing 4LinkZ.
 * To select between columns, alternate pressing the 'Left Arrowkey' and the 'Right Arrowkey'.
 * When dropping your token, press 'Space'.
 *
 * There are additional buttons on the side:
 * 'Reroll Song' - Changes the current played background song to the next one on the list.
 * 'Reset Game' - Resets the board pieces and allows the users to continue playing additional rounds.
 *
 * This program uses all classes, subclasses, instances, class members, methods, and method parameters
 *
 * -CLASSES-
 * Definition: A class defines the type of data and actions that will be associated with
 * an object of that class, but not the actual data for an individual object.
 *
 * Usage: In this program I create objects of many classes to organize my game in a
 * modular approach. These classes each define a general topic which contains
 * specific methods to complete tasks.
 *
 * -SUBCLASSES-
 * Definition: A class below another class in a class hierarchy.
 * A class that 'inherits' another class.
 *
 * Usage: All my classes are subclasses of the Object class in which they inherit methods
 * such as equals() and toString() (those methods are not used in this program specifically).
 * In addition, my KeyInput class is a subclass of the KeyAdapter class which inherits
 * fields and methods so my program can respond to the keyboard as well as my ActionListeners.
 *
 * -INSTANCES-
 * Definition: An object of a class.
 *
 * Usage: I have created many instances of classes when I instantiated my objects.
 * Many of these classes contain instance variables which only apply and affect each specific instance.
 * These instances help keep the program not only tidy but also synchronized.
 *
 * -CLASS MEMBERS-
 * Definition: Fields and methods that belong to a class. Tagged with the keyword static.
 *
 * Usage: Some fields(variables, etc) and methods of my classes are tagged with static
 * which enables another classes to call upon and access these values without the need of
 * instantiating an object/instance of the class.
 *
 * -METHODS-
 * Definition: A named set of statements that perform a single, well-defined task.
 *
 * Usage: I created many methods to organize the program in a modular approach.
 * Each of my methods execute a task which helps to run the game.
 *
 * -METHOD PARAMETERS-
 * Definition: The part of a method declaration that accepts values from the method call.
 *
 * Usage: Many of my methods require parameters which relay information from the method call
 * to the method so that the method can execute accurately.
 */

public class Main4LinkZ {
    //Instantiates an object/instance of the main class that controls the game.
    public static Play4LinkZ linkZ = new Play4LinkZ();

    public static void main(String[] args) {
        //Calls upon a method in the object that initiates the game.
        linkZ.start();
    }
}