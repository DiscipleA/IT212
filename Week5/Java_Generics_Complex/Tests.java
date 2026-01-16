import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Test.java
 *
 * This file contains test cases for all 3 parts of the Java Generics assignment.
 *
 * Requirement:
 *  - At least 3 NORMAL test cases
 *  - At least 3 EDGE test cases
 *
 * This class ONLY tests functionality.
 * Implementation classes are defined elsewhere:
 *   Pair.java
 *   Stack.java
 *   Cache.java
 *   GenericUtils.java
 *   Custom Comparable class (not defined here)
 * 
 * @author Dmitriy Chernichenko
 * @version IT212 Generics 2 - Test Class
 */
public class Tests {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Java Generics Assignment - Test Cases");
        System.out.println("======================================\n");

        // ============================================================
        // PART 1 TESTS: Pair<K,V> and Stack<T>
        // ============================================================

        // ---------- NORMAL TEST 1: Pair basic usage ----------
        System.out.println("PART 1 - NORMAL TEST 1: Pair basic usage");
        Pair<String, Integer> pair = new Pair<>("Age", 20);
        System.out.println("Initial pair: " + pair);
        pair.setValue(21);
        System.out.println("After setValue(21): " + pair);
        System.out.println("getKey(): " + pair.getKey());
        System.out.println("getValue(): " + pair.getValue());
        System.out.println();

        // ---------- EDGE TEST 1: Pair with null values ----------
        System.out.println("PART 1 - EDGE TEST 1: Pair with null key/value");
        Pair<String, String> nullPair = new Pair<>(null, null);
        System.out.println("Pair(null, null): " + nullPair);
        nullPair.setKey("nowHasKey");
        System.out.println("After setKey(): " + nullPair);
        System.out.println();

        // ---------- NORMAL TEST 2: Stack LIFO behavior ----------
        System.out.println("PART 1 - NORMAL TEST 2: Stack LIFO behavior");
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack after pushes: " + stack);
        System.out.println("Pop (expect Third): " + stack.pop());
        System.out.println("Pop (expect Second): " + stack.pop());
        System.out.println("Stack now: " + stack);
        System.out.println();

        // ---------- EDGE TEST 2: Stack underflow ----------
        System.out.println("PART 1 - EDGE TEST 2: Stack underflow (pop empty)");
        Stack<Integer> emptyStack = new Stack<>();
        try {
            emptyStack.pop();
            System.out.println("ERROR: Expected EmptyStackException.");
        } catch (EmptyStackException e) {
            System.out.println("PASS: Caught expected EmptyStackException.");
        }
        System.out.println();

        // ---------- EDGE TEST 3: Stack isEmpty correctness ----------
        System.out.println("PART 1 - EDGE TEST 3: Stack isEmpty()");
        Stack<Integer> s2 = new Stack<>();
        System.out.println("New stack isEmpty() (expect true): " + s2.isEmpty());
        s2.push(42);
        System.out.println("After push isEmpty() (expect false): " + s2.isEmpty());
        s2.pop();
        System.out.println("After pop isEmpty() (expect true): " + s2.isEmpty());
        System.out.println();


        // ============================================================
        // PART 2 TESTS: GenericUtils + Wildcards
        // ============================================================

        // ---------- NORMAL TEST 3: sort integers ----------
        System.out.println("PART 2 - NORMAL TEST 3: sort(ArrayList<Integer>)");
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(5, 1, 3, 2));
        System.out.println("Before sort: " + intList);
        GenericUtils.sort(intList);
        System.out.println("After sort:  " + intList + " (expect [1, 2, 3, 5])");
        System.out.println();

        // ---------- NORMAL TEST 4: sort strings ----------
        System.out.println("PART 2 - NORMAL TEST 4: sort(ArrayList<String>)");
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("banana", "apple", "cherry"));
        System.out.println("Before sort: " + strList);
        GenericUtils.sort(strList);
        System.out.println("After sort:  " + strList + " (expect [apple, banana, cherry])");
        System.out.println();

        // ---------- EDGE TEST 4: sort empty list ----------
        System.out.println("PART 2 - EDGE TEST 4: sort(empty list)");
        ArrayList<Integer> emptyList = new ArrayList<>();
        System.out.println("Before sort: " + emptyList);
        GenericUtils.sort(emptyList);
        System.out.println("After sort:  " + emptyList + " (expect [])");
        System.out.println();

        // ---------- NORMAL TEST 5: sumOfNumberList ----------
        System.out.println("PART 2 - NORMAL TEST 5: sumOfNumberList");
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        System.out.println("List: " + numbers);
        System.out.println("Sum (expect 60.0): " +
                GenericUtils.sumNumbers(numbers));
        System.out.println();

        // ---------- EDGE TEST 5: sumOfNumberList empty ----------
        System.out.println("PART 2 - EDGE TEST 5: sumOfNumberList(empty)");
        List<Double> emptyNums = new ArrayList<>();
        System.out.println("List: " + emptyNums);
        System.out.println("Sum (expect 0.0): " +
                GenericUtils.sumNumbers(emptyNums));
        System.out.println();


        // ============================================================
        // PART 3 TESTS: Cache<T>
        // ============================================================

        // ---------- NORMAL TEST 6: Cache add/get ----------
        System.out.println("PART 3 - NORMAL TEST 6: Cache add/get");
        Cache<String> cache = new Cache<>();
        cache.add("greeting", "hello");
        cache.add("farewell", "goodbye");
        System.out.println("Cache: " + cache);
        System.out.println("Get greeting (expect hello): " +
                cache.get("greeting"));
        System.out.println();

        // ---------- EDGE TEST 6: Cache missing key ----------
        System.out.println("PART 3 - EDGE TEST 6: Cache get missing key");
        System.out.println("Get unknown (expect null): " +
                cache.get("unknown"));
        System.out.println();

        // ---------- EDGE TEST 7: Cache clear ----------
        System.out.println("PART 3 - EDGE TEST 7: Cache clear()");
        Cache<Integer> intCache = new Cache<>();
        intCache.add("a", 10);
        intCache.add("b", 20);
        System.out.println("Before clear: " + intCache);
        intCache.clear();
        System.out.println("After clear:  " + intCache + " (expect empty)");
        System.out.println();

        // ---------- NORMAL TEST 7: Cache addAll with compatible types ----------
        System.out.println("PART 3 - NORMAL TEST 7: Cache addAll()");
        Cache<Integer> source = new Cache<>();
        source.add("x", 1);
        source.add("y", 2);

        Cache<Number> destination = new Cache<>();
        destination.add("pi", 3.14);

        System.out.println("Before addAll:");
        System.out.println("source:      " + source);
        System.out.println("destination: " + destination);

        destination.addAll(source); // Integer extends Number

        System.out.println("After destination.addAll(source):");
        System.out.println("destination: " + destination);
        System.out.println();

        // ---------- EDGE NOTE: compile-time safety ----------
        System.out.println("PART 3 - EDGE NOTE:");
        System.out.println("The following line should NOT compile (kept as comment):");
        System.out.println("// source.addAll(destination);  // unsafe and correctly rejected by compiler");

        System.out.println("\nALL TESTS COMPLETED.");
    }
}