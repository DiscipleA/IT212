/**
* VideoPlayer class extending AbstractMediaPlayer and implementing MediaPlayer interface
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class VideoPlayer extends AbstractMediaPlayer implements MediaPlayer {

    // Constructor for VideoPlayer
    public VideoPlayer(String title) {
        super(title);
    }

    // Methods to play, pause and stop the song in the video player
    public void play() {
        System.out.println(getClass().getSimpleName() + " PLAYING movie titled: " + super.getTitle());
    }

    public void pause() {
        System.out.println(getClass().getSimpleName() + " PAUSED movie titled: " + super.getTitle());
    } 
    
    public void stop() {
        System.out.println(getClass().getSimpleName() + " STOPED movie titled: " + super.getTitle());
    }

}