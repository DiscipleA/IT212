# Assignment IT212: Integrating Patient Records from Two Healthcare Providers | Doubly Linked List

## 📂 Project Overview

This project merges patient records from two healthcare providers (HealthMerge and CarePlus).
Each provider stores patient records in a **sorted doubly linked list**, ordered by **SSN**.
The system merges the two sorted lists into **one sorted doubly linked list** while preserving **all records** (including duplicates).

---

## 🚀 How it works

- Each patient record is represented by `PatientRecord` (SSN, age, full name).
- Records are stored in a custom `DoublyLinkedList` using `Node` objects:
  - Each `Node` has `data`, `next`, and `prev`.
  - The list tracks `head` and `tail` with null terminators at boundaries.
- The merge operation uses a **two-pointer technique**:
  - Walk through both sorted lists
  - Always append the smaller SSN node to the merged list
  - If SSNs are equal, append from the first list first, then the second (duplicates preserved)
- The merge reuses existing nodes (pointer manipulation), achieving:
  - **Time Complexity:** O(n + m)
  - **Extra Space Complexity:** O(1)

---

## ✨ Features

- Custom Doubly Linked List implementation
- Insert operations (`insertAtEnd`, `insertAtBeginning`)
- Traversal (forward & backward)
- Search by SSN
- Update by SSN (data change only)
- **Merge two sorted doubly linked lists by SSN (core requirement)**
- JUnit test suite with normal + edge case coverage

---

## 📁 Project Structure
```text
MergeHealthcareProviders/
├─ Main.java
├─ DoublyLinkedList.java
├─ Node.java
├─ PatientRecord.java
└─ Tests.java
```

---

## 🛠️ How to Run

### Requirements
- Java (JDK 17 recommended)
- VS Code with Java extensions (recommended)

### Run the Demo
Option 1 (VS Code):
- Open MergeHealthcareProviders/Main.java`
- Click **Run**

Option 2 (Terminal):
```bash
javac *.java
java Main
```
### Run Tests
```bash
java Tests
```

---

## 📺 Demos

| Component | Walkthrough Link |
| :--- | :--- |
| **Featuring Merge Doubly Linked Lists** | [Watch on YouTube](https://youtu.be/Vvc0zj2_KB4) |
