/**
* Abstract class defining the structure of a Media Player
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public abstract class AbstractMediaPlayer {

    // Instance variable for the title of the media player
    private String title;

    // Constructor for AbstractMediaPlayer
    public AbstractMediaPlayer (String title) {
        setTitle(title);
    }

    // Accessor to retriveve the title of the media player
    public String getTitle() {return title;}
    
    //mutator to set the title of the media player
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be null or Empty.");
        }
        this.title = title;
    }

}