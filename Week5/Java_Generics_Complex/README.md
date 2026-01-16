# Java Generics Complex: Advanced Data Structures & Utilities

This project demonstrates advanced proficiency in Java Generics, including multi-type classes, bounded wildcards, and type-safe collection utilities. It explores the power of generics in building reusable, type-safe, and efficient code.

## 📂 Project Structure

The project is contained within the `Java_Generics_Complex` directory:

* **Part 1: Complex Data Structures**
    * `Pair.java`: A multi-type generic container for Key-Value pairs.
    * `Stack.java`: A type-safe LIFO (Last-In-First-Out) implementation with custom exception handling.
* **Part 2: Generic Collections & Utilities**
    * `GenericUtils.java`: Contains static utilities for sorting and wildcard-based printing/summation.
    * `Custom.java`: A custom class implementing `Comparable` to demonstrate utility flexibility.
* **Part 3: Cache Implementation**
    * `Cache.java`: A generic storage system utilizing bounded wildcards for cross-cache compatibility.
* **Execution & Validation**
    * `Java_Generics_Complex.java`: The main entry point demonstrating all features.
    * `Tests.java`: Comprehensive test suite containing normal and edge case validations.

---

## 🚀 How It Works

### Part 1: Generic Data Structures
* **`Pair<K, V>`**: Uses two independent type parameters to store a mapping. It is essential for representing entries or coordinates.
* **`Stack<T>`**: Implements a dynamic stack. It includes "Graceful Underflow" protection, throwing an `EmptyStackException` if a pop is attempted on an empty structure.



### Part 2: Utilities & Wildcards
* **Sort Utility**: Uses the bound `<T extends Comparable<T>>` to ensure that any list passed to the method can be logically ordered.
* **Wildcards**: 
    * `printCollection(Collection<?>)`: Demonstrates **unbounded wildcards** for maximum flexibility.
    * `sumOfNumberList(List<? extends Number>)`: Demonstrates **Upper Bounded Wildcards**, allowing the method to process `Integer`, `Double`, or `Float` interchangeably.

### Part 3: Generic Cache
* **Bounded Wildcards**: The `addAll` method uses `<? extends T>` to allow merging a cache of a subtype into a cache of a supertype (e.g., adding a Cache of Integers into a Cache of Numbers).

---

## ✨ Features

* **Multi-Type Generics**: Support for different Key and Value types.
* **Type Bounds**: Restricted generic types to ensure functionality (e.g., `Comparable` or `Number`).
* **Robust Error Handling**: Prevents application crashes during stack underflow.
* **Flexible Merging**: Bounded wildcards enable interoperability between compatible generic types.

---

## 🧪 Testing & Validation (`Tests.java`)

The project includes a robust testing suite focusing on reliability across various scenarios.

### Normal Cases
1.  **Integer Stack Operations**: Pushing and popping integers to verify LIFO order.
2.  **String List Sorting**: Sorting an `ArrayList<String>` using the `GenericUtils.sort` method.
3.  **Cache Merging**: Successfully using `addAll` to transfer data between two compatible caches.

### Edge Cases
1.  **Stack Underflow**: Attempting to `pop()` from an empty stack to ensure the correct Exception is thrown.
2.  **Empty List Sorting**: Passing an empty list to the sort utility to ensure no errors occur.
3.  **Null Values in Cache**: Adding and retrieving `null` keys/values within the `Cache<T>` implementation to test null safety.

---

## 🛠️ How to Run

Ensure you have **JDK 8 or higher** installed.

1.  **Navigate to the project folder:**
    ```bash
    cd Java_Generics_Complex
    ```
2.  **Compile the project:**
    ```bash
    javac *.java
    ```
3.  **Run the Main demonstration:**
    ```bash
    java Java_Generics_Complex
    ```
4.  **Run the Test suite:**
    ```bash
    java Tests
    ```

---

## 📺 Demos

| Component | Walkthrough Link |
| :--- | :--- |
| **Generics, Stack Implementation, Utilities & Cache Logic** | [Watch on YouTube](https://youtu.be/UeNmxSRt9TY) |
