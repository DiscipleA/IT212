/**
* StrimingPlayer class extending AbstractMediaPlayer and implementing MediaPlayer interface
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class StreamingPlayer extends AbstractMediaPlayer implements MediaPlayer {

    // Constructor for StrimingPlayer
    public StreamingPlayer(String title) {
        super(title);
    }

    // Methods to play, pause and stop the song in the streaming player
    public void play() {
        System.out.println(getClass().getSimpleName() + " PLAYING series titled: " + super.getTitle());
    }

    public void pause() {
        System.out.println(getClass().getSimpleName() + " PAUSED series titled: " + super.getTitle());
    } 
    
    public void stop() {
        System.out.println(getClass().getSimpleName() + " STOPED series titled: " + super.getTitle());
    }

}