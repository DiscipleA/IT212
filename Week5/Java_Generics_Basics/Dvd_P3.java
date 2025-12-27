public class Dvd_P3 {
    private String name;

    public Dvd_P3() {
            this("unknown");
    }

    public Dvd_P3(String name) {
        setName(name);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}