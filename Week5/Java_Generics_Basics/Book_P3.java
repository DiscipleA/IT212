public class Book_P3 {
    private String title;

    public Book_P3() {
            this("unknown");
    }

    public Book_P3(String title) {
        setTitle(title);
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}