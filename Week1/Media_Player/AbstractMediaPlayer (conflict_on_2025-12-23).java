/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public abstract class AbstractMediaPlayer {

    private String title;

    public AbstractMediaPlayer (String title) {
        setTitle(title);
    }

    public String getTitle() {return title;}
    
    
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be null or Empty.");
        }
        this.title = title;
    }

}