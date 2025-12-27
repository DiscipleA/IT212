/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class VideoPlayer extends AbstractMediaPlayer implements MediaPlayer {

    public VideoPlayer(String title) {
        super(title);
    }

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