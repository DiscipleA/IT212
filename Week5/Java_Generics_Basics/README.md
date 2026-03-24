# Assignment IT212: Java Generics Basics

## Project Overview
This project demonstrates core and advanced Java generics concepts through a small multi-file application. It includes:
- a generic `Box_P2<T>` class for storing and retrieving values of any type
- a bounded generic `NumberBox_P2<T extends Number>` class for numeric values only
- a generic `Processor_P1<T>` interface with a `StringProcessor_P1` implementation that reverses strings
- a generic `Library_P3<T>` application that manages collections of items such as books and DVDs
- JUnit 5 tests covering both normal behavior and edge cases

## How it Works
The program is split into three parts that match the assignment requirements.

1. **Understanding Generics**
   - `Box_P2<T>` stores a value of any type.
   - `getBox_P2()` returns the stored value.
   - `setBox_P2()` updates the stored value.
   - `printBox()` is a generic static method that prints the contents of a box.

2. **Advanced Usage of Generics**
   - `NumberBox_P2<T extends Number>` extends `Box_P2<T>` and only accepts numeric types.
   - `Processor_P1<T>` defines a generic `process()` method.
   - `StringProcessor_P1` implements the interface and reverses the input string.
   - `printNumberBox(Box_P2<? extends Number>)` demonstrates wildcard usage for number-based boxes.

3. **Practical Application**
   - `Library_P3<T>` stores items in an `ArrayList<T>`.
   - It supports `addItem`, `removeItem`, and `findItemByName`.
   - `Book_P3` and `Dvd_P3` are sample item types used with the library.

## Features
- Generic value storage with `Box_P2<T>`
- Type-safe numeric boxes with bounded type parameters
- Generic interface implementation with string processing
- Wildcard-based method support for number hierarchies
- Reusable generic library collection manager
- Unit tests for standard and edge-case behavior

## Project Structure
```text
Java_Generics_Basics/
├── Book_P3.java
├── Box_P2.java
├── Dvd_P3.java
├── Java_Generics_Basics.java
├── JavaGenericsBasicsTest.java
├── Library_P3.java
├── NumberBox_P2.java
├── Processor_P1.java
├── README.md
└── StringProcessor_P1.java
```

## How to Run it (including Tests)
### 1. Compile the main program
From inside the project folder:
```bash
javac *.java
```

### 2. Run the demo program
```bash
java Java_Generics_Basics
```

### 3. Compile the tests with JUnit
Place `junit-platform-console-standalone-1.10.2.jar` in the project folder, then run:
```bash
javac -cp .:junit-platform-console-standalone-1.10.2.jar *.java
```

### 4. Run the tests
```bash
java -jar junit-platform-console-standalone-1.10.2.jar --class-path . --scan-class-path
```

> On Windows, replace `:` with `;` in the compile command:
```bash
javac -cp .;junit-platform-console-standalone-1.10.2.jar *.java
```

## Demo
### Example program output
```text
Original: Generics Are Fun
Reveresed: nuF erA scireneG
Integer Box: 42
String Box: Hello Generics
Box contains: 42
Box contains: Hello Generics
Number Box contains: 100
Number Box contains: 99.99
Books in Library:
Java for Dummies
Java Programming
Java Programming
Books after removal:
Java Programming
```

### Included tests
The test file contains **6 JUnit tests**:
- **3 normal tests**
  - reverse a normal string
  - store and retrieve values in generic boxes
  - add, find, and remove items in the library
- **3 edge tests**
  - process a `null` string
  - reject an empty string in `Box_P2<String>`
  - reject an empty search name in `Library_P3`

### Note about bounded generics
This line would produce a compile-time error and is intentionally **not** included in the source:
```java
// NumberBox_P2<String> invalidBox = new NumberBox_P2<>("not allowed");
```
That error demonstrates that `NumberBox_P2` only accepts subclasses of `Number`.

## 📺 Demos

| Component | Walkthrough Link |
| :--- | :--- |
| **Generics -- Basics** | [Watch on YouTube](https://youtu.be/5K6e4gcsVBM) |
