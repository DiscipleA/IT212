/**
 * Part 2
 * A custom class for Part 2 sorting demo.
 * 
 * It implements Comparable<Custom> for sort utility to compare them.
 * 
 * @author Dmitriy Chernichenko
 * @version IT212 Generics 2 - Custom Class
 */

public class Custom implements Comparable<Custom> {
    // Instance variables
    private String name;
    private int value;

    // Constructor
    public Custom(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    /**
     * Define the sorting rule:
     *   -Compare Custom objects based on their 'value' field.
     */
    @Override
    public int compareTo(Custom other) {
        // Compare based on the 'value' field
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return name + ", (value=" + value + ")";
    }
}