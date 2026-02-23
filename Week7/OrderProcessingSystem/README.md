# Assignment IT212: E-Commerce Order Processing System (Extra credit assignment)

---

## 📂 Project Overview
This project simulates an e-commerce order processing system where orders arrive in sequence (first order at the head of the list). Due to a fulfillment strategy change, we reverse the singly linked list so the **most recent orders are processed first**.

---

## 🚀 How it works
- Orders are stored in a **custom singly linked list** (not Java’s built-in LinkedList).
- Each node contains:
  - `Order data`
  - `Node next`
- The list tracks the first node using `head`.
- `append(order)` adds a new order to the tail.
- `reverse()` reverses the links **in-place**:
  - Time complexity: **O(N)**
  - Extra space: **O(1)**

---

## ✨ Features
- ✅ Create orders with:
  - Order ID
  - Customer name
  - Order details
  - Timestamp (created automatically)
- ✅ Append orders to a singly linked list
- ✅ Display list contents from head → null
- ✅ Reverse list to process most recent orders first
- ✅ Industry-style automated testing using **JUnit 5**
  - At least 3 normal test cases
  - At least 3 edge test cases

---

## 📁 Project structure
```text
OrderProcessingSystem/
├─ Main.java
├─ SinglyLinkedList.java
├─ Node.java
├─ Order.java
└─ Tests.java
```

---

## 🛠️ How to Run

### 1) Run the demo application
```bash
javac *.java
java Main
```

### 2) Run all test cases
```bash
java Tests
```

---

## 📺 Demos

| Component | Walkthrough Link |
| :--- | :--- |
| **Featuring Order Processing System** | [Watch on YouTube](https://youtu.be/HJP9GArjZIY) |