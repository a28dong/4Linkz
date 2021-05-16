import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javafx.embed.swing.JFXPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//The graphic class for implementing the graphics of the game
//Contains the methods so that the game graphics can reflect the state of the game

public class GameGraphics {
    //Variable and Constant declaration
    public int hookX, tokenY;
    public final String card1 = "Menu";
    public final String card2 = "Help";
    public final String card3 = "Game";

    //Creates an object for adding audio to the frame.
    private final JFXPanel fxPanel = new JFXPanel();

    //Imports all images and converts to icons to use
    private ImageIcon mainImage = new ImageIcon("res/main.png");
    private ImageIcon playImage = new ImageIcon("res/play.png");
    private ImageIcon instructionImage = new ImageIcon("res/howtoplay.png");
    private ImageIcon nextImage = new ImageIcon("res/next.png");
    private ImageIcon orangeImage = new ImageIcon("res/orange.png");
    private ImageIcon blueImage = new ImageIcon("res/blue.png");
    private ImageIcon hookImage = new ImageIcon("res/claw.png");
    private ImageIcon boardImage = new ImageIcon("res/board.png");
    private ImageIcon winOImage = new ImageIcon("res/orangewin.jpg");
    private ImageIcon winBImage = new ImageIcon("res/bluewin.jpg");
    private ImageIcon resetImage = new ImageIcon("res/reset.png");
    private ImageIcon tieImage = new ImageIcon("res/tie.jpg");
    private ImageIcon rerollImage = new ImageIcon("res/reroll.png");
    private ImageIcon lastImage = new ImageIcon("res/lastmove.png");
    private ImageIcon oBorderImage = new ImageIcon("res/oborder.png");
    private ImageIcon bBorderImage = new ImageIcon("res/bborder.png");

    //Initializes fonts to use
    public Font text = new Font ("Calibri", Font.BOLD, 40);
    public Font score = new Font ("Calibri", Font.BOLD, 100);

    //Creates JFrames
    public JFrame frame = new JFrame("4LinkZ");
    public JFrame blueWin = new JFrame("Blue Alliance Wins!");
    public JFrame orangeWin = new JFrame("Orange Alliance Wins!");
    public JFrame tie = new JFrame("No One Wins!");

    //Creates a layout and JPanels
    public CardLayout layout = new CardLayout(); //Layout swaps between cards
    public JPanel screens = new JPanel();
    public JPanel menu = new JPanel();
    public JPanel help = new JPanel();
    public JPanel game = new JPanel();

    //JLabels for the victory screens
    public JLabel blueVictory = new JLabel(winBImage);
    public JLabel orangeVictory = new JLabel(winOImage);
    public JLabel tieVictory = new JLabel(tieImage);

    //Creates JLabels for each card
    //Main card
    public JLabel mainScreen = new JLabel(mainImage);

    //Help card
    public JLabel instructionScreen = new JLabel(instructionImage);

    //Game card
    public JLabel[] tokenBlue = new JLabel[26];
    public JLabel[] tokenOrange = new JLabel[26];
    public JLabel hook = new JLabel(hookImage);
    public JLabel board = new JLabel(boardImage);
    public JLabel lastMove = new JLabel(lastImage);
    public JLabel oBorder = new JLabel(oBorderImage);
    public JLabel bBorder= new JLabel(bBorderImage);

    //Text Labels
    public JLabel oMove = new JLabel();
    public JLabel bMove = new JLabel();
    public JLabel oWin= new JLabel();
    public JLabel bWin= new JLabel();

    //Creates JButtons
    public JButton play = new JButton(playImage);
    public JButton next = new JButton(nextImage);
    public JButton reset = new JButton(resetImage);
    public JButton reroll = new JButton(rerollImage);

    // Declares the colour used for the output texts
    public static Color blue = new Color(205, 229, 243);

    /**
     * constructor
     * pre: none
     * post: A GameGraphics object created. Graphics are initialized
     */
    public GameGraphics() {
        //Applies the layout to the card container
        screens.setLayout(layout);

        ///FRAMES///

        //Main frame set-up
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit
        frame.setLocation(new Point(140, 100)); //Location
        frame.setSize(new Dimension(1000, 800)); //Size
        frame.getContentPane().setLayout(null); //Layout
        frame.setResizable(false);	//Ensures that the frame cannot be resized
        frame.add(fxPanel);	//Adds the audio panel
        frame.addKeyListener (new KeyInput ()); //Adds the keylistener to enable keyboard inputs

        //VICTORY SET UPS
        blueWin.setLocation(new Point(350, 200));
        blueWin.setSize(new Dimension(600, 400));
        blueWin.getContentPane().setLayout(null);
        blueWin.setResizable(false);

        orangeWin.setLocation(new Point(350, 200));
        orangeWin.setSize(new Dimension(600, 400));
        orangeWin.getContentPane().setLayout(null);
        orangeWin.setResizable(false);

        tie.setLocation(new Point(350, 200));
        tie.setSize(new Dimension(600, 400));
        tie.getContentPane().setLayout(null);
        tie.setResizable(false);

        //Labels for victory screens
        orangeVictory.setBorder(null); //Removes border
        orangeVictory.setBounds(0,0,600,400); //Adjusts size and location

        blueVictory.setBorder(null);
        blueVictory.setBounds(0,0,600,400);

        tieVictory.setBorder(null);
        tieVictory.setBounds(0,0,600,400);

        //CARD 1 LABELS
        mainScreen.setBorder(null); //Removes border
        mainScreen.setBounds(0,0,1000,767); //Adjusts size and location


        //CARD 2 LABELS
        instructionScreen.setBorder(null); //Removes border
        instructionScreen.setBounds(0,0,1000,800); //Adjusts size and location


        //CARD 3 LABELS
        for (int i = 1; i<=25;i++){
            tokenOrange[i] = new JLabel(orangeImage); //Adds the image to the label
            tokenOrange[i].setBorder(null); //Removes border

            tokenBlue[i] = new JLabel(blueImage);
            tokenBlue[i].setBorder(null);
        }

        //Reset graphic locations
        resetGraphics();

        hook.setBorder(null); //Removes border
        hook.setBounds(hookX,0, 100,115); //Adjusts size and location

        board.setBorder(null);
        board.setBounds(190,150,625,600);

        oBorder.setBorder(null);
        oBorder.setBounds(0,550,150,250);

        bBorder.setBorder(null);
        bBorder.setBounds(850,550,150,250);

        lastMove.setBorder(null);
        lastMove.setBounds(15,50,170,350);

        //TEXT LABELS
        oMove.setBorder(null); //Removes border
        oMove.setFont(text); //Sets the font
        oMove.setForeground(Color.white); //Sets the colour

        bMove.setBorder(null);
        bMove.setFont(text);
        bMove.setForeground(Color.white);

        oWin.setBorder(null);
        oWin.setFont(score);
        oWin.setForeground(Color.white);

        bWin.setBorder(null);
        bWin.setFont(score);
        bWin.setForeground(Color.white);

        //BUTTON LABELS
        play.setBorder(null); //Removes border
        play.setBounds(335,600,330,120); //Adjusts size and location
        play.addActionListener(new Play()); //Adds the action listener

        next.setBorder(null);
        next.setBounds(730,550,250,90);
        next.addActionListener(new Next());

        reroll.setBorder(null);
        reroll.setBounds(830,50,150,150);
        reroll.addActionListener(new Reroll());

        reset.setBorder(null);
        reset.setBounds(830,250,150,150);
        reset.addActionListener(new Reset());

        //Adjusts the cards/JPanels
        menu.setLayout(null); //Removes the boarder
        menu.setBackground(blue); //Sets the colour

        help.setLayout(null);
        help.setBackground(blue);

        game.setLayout(null);
        game.setBackground(blue);

        //Adjusts the size and location of the container
        screens.setBounds(0,0,1000, 800);

        //Adds the cards to the container
        screens.add(menu, card1);
        screens.add(help, card2);
        screens.add(game, card3);

        //Adds the contents of each JPanel/Card
        //Card 1
        menu.add(mainScreen);
        menu.add(play);

        //Card 2
        help.add(instructionScreen);
        help.add(next);

        //Card 3
        game.add(hook);
        game.add(board);
        game.add(reroll);
        game.add(reset);
        game.add(oMove);
        game.add(bMove);
        game.add(lastMove);
        game.add(oWin);
        game.add(bWin);
        game.add(oBorder);
        game.add(bBorder);

        for (int i = 1; i<=25;i++){
            game.add(tokenOrange[i]);
            game.add(tokenBlue[i]);
        }

        //Adds content the Frames
        orangeWin.getContentPane().add(orangeVictory);
        blueWin.getContentPane().add(blueVictory);
        tie.getContentPane().add(tieVictory);
        frame.getContentPane().add(screens);
    }

    /**
     * Resets the graphics
     * pre: none
     * post: Graphic information/values are reset to default
     */
    public void resetGraphics(){
        hookX = 217;
        tokenY = 60;
        for (int i = 1; i<=25;i++){
            tokenOrange[i].setVisible(false); //Turns all labels invisible
            tokenOrange[i].setBounds(hookX+23, tokenY,55,55); //Sets size and location

            tokenBlue[i].setVisible(false);
            tokenBlue[i].setBounds(hookX+23, tokenY,55,55);
        }
        hook.setBounds(hookX,0, 100,115);  //Sets size and location
    }

    /**
     * Initiates the graphics of the game
     * pre: none
     * post: Frame is visible, first card is shown
     */
    public void gameOn(){
        frame.setVisible(true); //Sets the frame visible
        layout.show(screens,card1); //Picks the card
    }

    /**
     * Syncs and refreshes graphical movement to follow keyboard input
     * pre: none
     * post: Graphics are sync'd and refreshed
     */
    public void moveRefresh(){
        //Adjusts the coordinates based on column
        switch (Main4LinkZ.linkZ.getCol()){
            case 1: hookX = 217; break;
            case 2: hookX = 296; break;
            case 3: hookX = 374; break;
            case 4: hookX = 453; break;
            case 5: hookX = 531; break;
            case 6: hookX = 610; break;
            case 7: hookX = 688; break;
        }

        //Refreshes the token location
        switch (Main4LinkZ.linkZ.getTurn()){
            case 1: tokenOrange[Main4LinkZ.linkZ.getCounter()].setBounds(hookX+23, 60,55,55);
                break;
            case 2: tokenBlue[Main4LinkZ.linkZ.getCounter()].setBounds(hookX+23, 60,55,55);
                break;
        }
        //Refreshes the hook location
        hook.setBounds(hookX,0, 100,115);
    }

    /**
     * Syncs and refreshes graphical movement to follow keyboard input
     * pre: none
     * post: Graphics are sync'd and refreshed
     */
    public void dropRefresh(){
        //Adjusts the coordinates based on row
        switch (Main4LinkZ.linkZ.getRow()){
            case 1: tokenY = 658; break;
            case 2: tokenY = 580; break;
            case 3: tokenY = 502; break;
            case 4: tokenY = 424; break;
            case 5: tokenY = 346; break;
            case 6: tokenY = 268; break;
            case 7: tokenY = 190; break;
        }

        //Refreshes the token location
        switch (Main4LinkZ.linkZ.getTurn()){
            case 1: tokenOrange[Main4LinkZ.linkZ.getCounter()].setBounds(hookX+23, tokenY,55,55);
                break;
            case 2: tokenBlue[Main4LinkZ.linkZ.getCounter()].setBounds(hookX+23, tokenY,55,55);
                break;
        }
    }

    /**
     * Prepares the next set of graphics
     * pre: none
     * post: Graphics are prepared
     */
    public void prep(){
        //Enables the next token to be visible and adjusts location
        switch (Main4LinkZ.linkZ.getTurn()){
            case 1:tokenOrange[Main4LinkZ.linkZ.getCounter()].setBounds(hookX+23, 60,55,55);
                tokenOrange[Main4LinkZ.linkZ.getCounter()].setVisible(true);
                break;

            case 2:tokenBlue[Main4LinkZ.linkZ.getCounter()].setBounds(hookX+23, 60,55,55);
                tokenBlue[Main4LinkZ.linkZ.getCounter()].setVisible(true);
                break;
        }
    }
}

//Action listener for transition 1
class Play implements ActionListener{
    public void actionPerformed (ActionEvent event)
    {
        //Shows the next card in the card layout
        Main4LinkZ.linkZ.graphic.layout.show(Main4LinkZ.linkZ.graphic.screens, Main4LinkZ.linkZ.graphic.card2);
    }
}

//Action listener for transition 2
class Next implements ActionListener {
    public void actionPerformed (ActionEvent event)
    {
        //Prepares for a new game
        Main4LinkZ.linkZ.newGame();

        //Shows the next card in the card layout
        Main4LinkZ.linkZ.graphic.layout.show(Main4LinkZ.linkZ.graphic.screens, Main4LinkZ.linkZ.graphic.card3);

        //Re-enables focus for the keyboard input
        Main4LinkZ.linkZ.graphic.frame.requestFocus();
    }
}

//Action listener for resetting board state
class Reset implements ActionListener {
    public void actionPerformed (ActionEvent event)
    {
        //Initiates a new game
        Main4LinkZ.linkZ.newGame();

        //Re-enables focus for the keyboard input
        Main4LinkZ.linkZ.graphic.frame.requestFocus();

        //Closes all victory frames
        Main4LinkZ.linkZ.graphic.orangeWin.setVisible(false);
        Main4LinkZ.linkZ.graphic.blueWin.setVisible(false);
        Main4LinkZ.linkZ.graphic.tie.setVisible(false);
    }
}

//Action listener for the music control button
class Reroll implements ActionListener {
    public void actionPerformed (ActionEvent event)
    {
        //Re-enables focus for the keyboard input
        Main4LinkZ.linkZ.graphic.frame.requestFocus();

        //Refreshes to the next song
        Main4LinkZ.linkZ.song.stop();
        Main4LinkZ.linkZ.song.play();
    }
}