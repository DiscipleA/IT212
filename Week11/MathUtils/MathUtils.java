// The MathUtils class provides both static math operations
// and object-based features (fields, constructors, getters/setters)
public class MathUtils {

    // Instance variables (fields) to store two integer values
    private int num1;
    private int num2;

    // Default constructor
    // Initializes num1 and num2 to 0
    public MathUtils() {
        this.num1 = 0;
        this.num2 = 0;
    }

    // Parameterized constructor
    // Allows setting initial values for num1 and num2 when creating an object
    public MathUtils(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Getter method for num1
    // Returns the value of num1
    public int getNum1() {
        return num1;
    }

    // Setter method for num1
    // Updates the value of num1
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    // Getter method for num2
    // Returns the value of num2
    public int getNum2() {
        return num2;
    }

    // Setter method for num2
    // Updates the value of num2
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    // Static method to add two integers
    // Returns the sum of a and b
    public static int add(int a, int b) {
        return a + b;
    }

    // Static method to subtract two integers
    // Returns the result of a minus b
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Static method to multiply two integers
    // Returns the product of a and b
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Static method to divide two integers
    // Returns the result as a double
    // If b is 0, returns Double.NaN to avoid division by zero error
    public static double divide(int a, int b) {
        if (b == 0) {
            return Double.NaN; // Not a Number (undefined result)
        }
        return (double) a / b; // Cast to double for decimal result
    }

    // Overrides the default toString() method
    // Returns a string representation of the object
    @Override
    public String toString() {
        return "MathUtils{num1=" + num1 + ", num2=" + num2 + "}";
    }
}