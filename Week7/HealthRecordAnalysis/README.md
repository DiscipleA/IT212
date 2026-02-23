# Assignment IT212: Patient Health Record Symmetry Analysis

## 📂 Project Overview
This project analyzes a patient's health record represented as a **singly linked list** and determines whether the sequence of recorded health metrics is **symmetrical (palindrome)**.

A symmetrical record can suggest a return to baseline measurements or recurrence of patterns over time.

---

## 🚀 How it works

The health record is stored in a **singly linked list** where each node contains:
- `int data` (health metric value)
- `Node next` (reference to the next day’s metric)

The core function is:

- `HealthRecordAnalyzer.isHealthRecordSymmetric(Node head)`

### Algorithm (O(N) time, O(1) extra space)
1. Use **fast/slow pointers** to find the middle of the list
2. Reverse the **second half** of the list in-place
3. Compare values from the start of the list and the reversed second half
4. Restore the list (reverse the second half back)

---

## ✨ Features

- Singly linked list implementation (`Node`, `head`, `append`, traversal)
- Efficient palindrome detection (`O(N)` time, `O(1)` extra space)
- Clean OOP structure
- **JUnit** test with junit-platform-console-standalone-1.10.2.jar
  - 3 normal test cases
  - 3 edge test cases

---

## 📁 Project Structure

```text
HealthRecordAnalysis/
├─ HealthRecordAnalyzer.java
├─ Main.java
├─ Node.java
├─ SinglyLinkedList.java
├─ Tests.java
└─ README.md
```

## 🛠️ How to Run

### Requirements
 - Java 17+
 - VS Code (recommended) + "Extension Pack for Java"

### Run the demo
```bash
javac *.java
java Main
```

### Run Tests
```bash
java Tests
```

## 📺 Demos

| Component | Walkthrough Link |
| :--- | :--- |
| **isHealthRecordSymmetric funcion** | [Watch on YouTube](https://youtu.be/XwLiRrh8wfs) |