import java.util.EmptyStackException;
import java.util.ArrayList;

/**
 * Java Generics assignment Main class
 *
 * Demonstrates:
 *  - Multi-type generic Pair<K, V>
 *  - Generic Stack<T> with underflow protection
 * 
 * @author Dmitriy Chernichenko
 * @version IT212 Generics 2 - Main Class
 */

public class Java_Generics_Complex {
    public static void main(String[] args) {
        
        //Part 1: Multi-type Generic Pair<K, V>
        System.out.println("Part 1: => Generic Pair<K, V> Tests.");
        Pair<String, Integer> agePair = new Pair<>("Age", 20);
        System.out.println("Initial Pair: " + agePair);

        // using setters to modify values
        agePair.setValue(21);
        System.out.println("Updated Pair: " + agePair);

        //Another pair with different types
        Pair<Integer, String> idPair = new Pair<>(1001, "Alex");
        System.out.println("Another Pair: " + idPair);

        //Part 1: Generic Stack<T> with underflow protection
        System.out.println("\nPart 1: => Generic Stack<T> Tests.");
        Stack<String> stringStack = new Stack<>();

        // Push elements
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");

        // Pop elements (LIFO: Third, Second, First)
        while (!stringStack.isEmpty()) {
            System.out.println("Popped: " + stringStack.pop());
        }

        // Demonstrate underflow handling (pop on empty stack)
        System.out.println("\nTrying to pop an empty stack (should throw exception):");
        try {
            stringStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("=> Caught underflow exception: EmptyStackException!");
        }

        // Another stack with different type
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);

        System.out.println("\nInteger stack pop: " + intStack.pop());
        System.out.println("Integer stack pop: " + intStack.pop());

        //Part 2 Generic Sort Utility - Integer
        System.out.println("\nPart 2: => Generic Sort Utility Tests.");
        ArrayList<Integer> intList = new ArrayList<>();

        // Add unsorted integers
        intList.add(5);
        intList.add(1);
        intList.add(3);
        intList.add(2);

        // Sort using GenericUtils
        System.out.println("Before sorting integers: " + intList);
        GenericUtils.sort(intList);
        System.out.println("After sorting integers: " + intList);

        //Part 2 Generic Sort Utility - String
        ArrayList<String> strList = new ArrayList<>();

        // Add unsorted strings
        strList.add("Banana");
        strList.add("Apple");
        strList.add("Cherry");

        // Sort using GenericUtils
        System.out.println("\nBefore sorting strings: " + strList);
        GenericUtils.sort(strList);
        System.out.println("After sorting strings: " + strList);

        //Part 2 Generic Sort Utility - Custom class
        ArrayList<Custom> customList = new ArrayList<>();

        // Add unsorted Custom objects
        customList.add(new Custom("Oranges", 30));
        customList.add(new Custom("Grapes", 10));
        customList.add(new Custom("Pineapple", 20));

        // Sort using GenericUtils
        System.out.println("\nBefore sorting Custom objects: " + customList);
        GenericUtils.sort(customList);
        System.out.println("After sorting Custom objects: " + customList);

        //Part 2 Generic Utils - Print Collection
        System.out.println("\nPart 2: => Wild Card Method printCollection Tests.");
        
        // Using the printCollection method
        GenericUtils.printCollection(intList);
        GenericUtils.printCollection(strList);
        GenericUtils.printCollection(customList);

        //Part 2 Generic Utils - Sum Numbers
        System.out.println("\nPart 2: => Wild Card Method sumNumbers Tests.");
        ArrayList<Number> numberList = new ArrayList<>();
        
        // Add various Number types
        numberList.add(10);      // Integer
        numberList.add(15.5);    // Double
        numberList.add(20L);     // Long

        // Calculate sum using sumNumbers method
        double sum = GenericUtils.sumNumbers(numberList);
        System.out.println("Sum of numbers: " + sum);

        //Part 3: Generic Cache<T> Class Tests
        System.out.println("\nPart 3: => Generic Cache<T> Tests.");
        
        // Cache of Strings
        Cache<String> stringCache = new Cache<>();
        stringCache.add("greeting", "Hello");
        stringCache.add("farewell", "Goodbye");

        System.out.println("String cache: " + stringCache);
        System.out.println("Get 'greeting': " + stringCache.get("greeting"));

        // Cache of Integers
        Cache<Integer> intCache = new Cache<>();
        intCache.add("a", 10);
        intCache.add("b", 20);

        System.out.println("\nInteger cache: " + intCache);
        System.out.println("Get 'a': " + intCache.get("a"));

        // Clear caches
        stringCache.clear();
        System.out.println("\nString cache after clear: " + stringCache);

        // Demonstrate addAll with bounded wildcards
        System.out.println("\nDemonstrating addAll with bounded wildcards:");
        Cache<Integer> smallInts = new Cache<>();
        smallInts.add("x", 1);
        smallInts.add("y", 2);

        Cache<Number> numbers = new Cache<>();
        numbers.add("pi", 3.14);
        numbers.add("ten", 10);

        System.out.println("\nBefore addAll:");
        System.out.println("smallInts (Cache<Integer>): " + smallInts);
        System.out.println("numbers   (Cache<Number>):  " + numbers);

        // Add all from smallInts to numbers
        numbers.addAll(smallInts);

        System.out.println("\nAfter numbers.addAll(smallInts):");
        System.out.println("numbers (Cache<Number>): " + numbers);

    }

}