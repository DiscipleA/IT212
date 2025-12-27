public class Box_P2<T> {
    
    private T value;

    public Box_P2() {
    }

    public Box_P2(T value) {
        setBox_P2(value);
    }

    public T getBox_P2() {
        return value;
    }

    public void setBox_P2(T value) {
        if (value instanceof String){
            if (((String) value).isEmpty()){
                throw new IllegalArgumentException("String value cannot be null");
            }
        }
        this.value = value;
    }

    public static <U> void printBox(Box_P2<U> value) {
        System.out.println("Box contains: " + value.getBox_P2());
    }

    public static void printNumberBox(Box_P2<? extends Number> value) {
        System.out.println("Number Box contains: " + value.getBox_P2());
    }
}
