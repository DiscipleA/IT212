/**
* AudioPlayer class extending AbstractMediaPlayer and implementing MediaPlayer interface
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class AudioPlayer extends AbstractMediaPlayer implements MediaPlayer {

    // Constructor for AudioPlayer
    public AudioPlayer(String title) {
        super(title);
    }

    // Methods to play, pause and stop the song in the audio player
    public void play() {
        System.out.println(getClass().getSimpleName() + " PLAYING song titled: " + super.getTitle());
    }

    public void pause() {
        System.out.println(getClass().getSimpleName() + " PAUSED song titled: " + super.getTitle());
    } 
    
    public void stop() {
        System.out.println(getClass().getSimpleName() + " STOPED song titled: " + super.getTitle());
    }

}