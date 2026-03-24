# Assignment IT212: Building and Testing a Java Utility Class

## Project Overview

This project implements a Java class named `MathUtils` that performs basic mathematical operations using static methods. It also demonstrates object-oriented programming concepts such as constructors, getters, setters, and the `toString()` method.

A separate class, `TestMathUtils`, is used to test all functionality using a `main` method.

---

## Project Structure

```
MathUtils
├── MathUtils.java
├── TestMathUtils.java
├── junit-platform-console-standalone-1.10.2.jar
└── MathUtilsTest.java

```

---

## Features

* Static mathematical operations:

  * Addition
  * Subtraction
  * Multiplication
  * Division (with division-by-zero handling)

* Object-oriented features:

  * Default constructor
  * Parameterized constructor
  * Getters and setters
  * `toString()` method

* Testing:

  * Normal test cases
  * Edge cases (e.g., division by zero, zero values)

---

## How It Works

### Static Methods

The `MathUtils` class provides static methods that can be used without creating an object.

Example:

```java
MathUtils.add(5, 3);  // returns 8
MathUtils.divide(5, 0);  // returns NaN
```

### Object Usage

The class also allows storing two integer values using constructors and accessing them with getters/setters.

Example:

```java
MathUtils obj = new MathUtils(10, 5);
System.out.println(obj);  // MathUtils{num1=10, num2=5}
```

---

## Testing

The `TestMathUtils` class includes a `main` method that:

* Calls each static method
* Prints results to the console
* Tests edge cases such as division by zero
* Demonstrates constructors, getters, setters, and `toString()`

---

## Example Output

```
===== Testing Static Methods =====
Add (5 + 3): 8
Subtract (10 - 4): 6
Multiply (6 * 2): 12
Divide (8 / 2): 4.0
Divide (5 / 0): NaN

===== Testing Object Features =====
Default Object: MathUtils{num1=0, num2=0}
Parameterized Object: MathUtils{num1=10, num2=5}
num1: 10
num2: 5
Updated Object: MathUtils{num1=20, num2=4}

===== Additional Edge Cases =====
Add (0 + 0): 0
Multiply (0 * 10): 0
Subtract (0 - 5): -5
Divide (0 / 5): 0.0
```

---

## How to Run

### Step 1: Compile

Open terminal in the project folder and run:

```bash
javac MathUtils.java TestMathUtils.java
```

### Step 2: Run

```bash
java TestMathUtils
```

---

## Demo Videos

| Demo Topic               | YouTube Link         |
| ------------------------ | -------------------- |
| Running the Program      | https://youtu.be/gXRaLoaMbXY |