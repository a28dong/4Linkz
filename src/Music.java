import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//The music class for controlling audio
//Enables songs to played in the background
public class Music {

    //Creates objects for playing music
    private MediaPlayer mediaPlayer;
    private Media menu;
    private Media song[] = new Media [6];

    private int playList = 0; //Helps control song order

    /**
     * constructor
     * pre: none
     * post: A Music object created. Medias are initialized with files
     */
    public Music(){
        menu = new Media(new File("res/main.mp3").toURI().toString());
        song[1] = new Media(new File("res/song1.mp3").toURI().toString());
        song[2] = new Media(new File("res/song2.mp3").toURI().toString());
        song[3] = new Media(new File("res/song3.mp3").toURI().toString());
        song[4] = new Media(new File("res/song4.mp3").toURI().toString());
        song[5] = new Media(new File("res/song5.mp3").toURI().toString());
    }

    /**
     * Plays the menu song and adjusts the media
     * pre: none
     * post: Media has been changed and song is played
     */
    public void menuPlay(){
        mediaPlayer = new MediaPlayer(menu);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); //Allows for looping
        mediaPlayer.play();
    }

    /**
     * Stops the song
     * pre: none
     * post: Song has been stopped
     */
    public void stop(){
        mediaPlayer.stop();
    }

    /**
     * Plays the game song and adjusts the media
     * pre: none
     * post: Media has been changed and song is played
     */
    public void play(){
        next();
        mediaPlayer = new MediaPlayer(song[playList]);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); //Allows for looping
        mediaPlayer.play();
    }

    /**
     * Changes the value of playList
     * pre: none
     * post: The value of playList has been changed.
     */
    public void next(){
        playList +=1;
        if (playList>5)
            playList = 1;
    }

}