public class TestMathUtils {

    public static void main(String[] args) {

        System.out.println("===== Testing Static Methods =====");

        // Normal cases
        System.out.println("Add (5 + 3): " + MathUtils.add(5, 3));
        System.out.println("Subtract (10 - 4): " + MathUtils.subtract(10, 4));
        System.out.println("Multiply (6 * 2): " + MathUtils.multiply(6, 2));
        System.out.println("Divide (8 / 2): " + MathUtils.divide(8, 2));

        // Edge case: division by zero
        System.out.println("Divide (5 / 0): " + MathUtils.divide(5, 0));

        System.out.println("\n===== Testing Object Features =====");

        // Default constructor
        MathUtils obj1 = new MathUtils();
        System.out.println("Default Object: " + obj1);

        // Parameterized constructor
        MathUtils obj2 = new MathUtils(10, 5);
        System.out.println("Parameterized Object: " + obj2);

        // Using getters
        System.out.println("num1: " + obj2.getNum1());
        System.out.println("num2: " + obj2.getNum2());

        // Using setters
        obj2.setNum1(20);
        obj2.setNum2(4);

        System.out.println("Updated Object: " + obj2);

        System.out.println("\n===== Additional Edge Cases =====");

        // Edge cases for math
        System.out.println("Add (0 + 0): " + MathUtils.add(0, 0));
        System.out.println("Multiply (0 * 10): " + MathUtils.multiply(0, 10));
        System.out.println("Subtract (0 - 5): " + MathUtils.subtract(0, 5));
        System.out.println("Divide (0 / 5): " + MathUtils.divide(0, 5));

        System.out.println("\n===== Testing Complete =====");
    }
}