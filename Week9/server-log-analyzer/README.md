# Assignment IT212: The Server Log Analyzer

---

## 📌 Project Overview

The **Server Log Analyzer** is a Java application designed to process and analyze server log files.
It reads raw log data, filters critical errors, generates summary reports, and produces a cleaned version of the logs for easier readability.

This project simulates real-world backend log processing used in production systems.

---

## 🎯 Objective

The objective of this assignment is to:

* Practice file handling using **BufferedReader / BufferedWriter**
* Use **try-with-resources** for safe resource management
* Apply **string parsing techniques** to extract structured data
* Implement **Modern Java NIO.2 (Path, Files)**
* Analyze and transform log data into meaningful outputs

---

## ⚙️ Features

* 📥 Reads log data from `server.log`
* 🚨 Extracts all `[ERROR]` messages into a separate file
* 📊 Generates a summary report of log levels (INFO, WARN, ERROR)
* 🧹 Cleans logs by removing timestamps
* 🧪 Includes automated test cases (normal + edge cases)
* 📁 Uses organized project structure for scalability

---

## 🗂️ Project Structure

```text
server-log-analyzer/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ServerLogAnalyzer.java
│   │   └── resources/
│   │       └── server.log
│   └── test/
│       └── java/
│           └── ServerLogAnalyzerTest.java
└── output/
```

---

## 🔍 How It Works

### 🔹 Level 1: Basic Filtering

* Reads `server.log`
* Finds all lines containing `[ERROR]`
* Writes them to `output/errors.txt`

---

### 🔹 Level 2: Data Parsing & Report

* Extracts log level between `[ ]`
* Counts:

  * INFO
  * WARN
  * ERROR
* Generates `output/report.txt`

---

### 🔹 Level 3: Clean Log Generation

* Removes timestamps from each log line

Example:

**Input:**

```text
2023-10-01 10:00:01 [INFO] Server started
```

**Output:**

```text
[INFO] Server started
```

Saved to:

```text
output/clean.log
```

---

## 📥 Input File

Place your input log file here:

```text
src/main/resources/server.log
```

---

## 📤 Output Files

After running the program:

* 📄 `output/errors.txt` → contains only `[ERROR]` logs
* 📄 `output/report.txt` → summary of log counts
* 📄 `output/clean.log` → cleaned log without timestamps

---

## 🧪 Test Cases

### ✅ Normal Cases

* Correctly filters `[ERROR]` lines
* Accurately counts INFO, WARN, ERROR
* Properly removes timestamps

### ⚠️ Edge Cases

* Handles empty log file
* Ignores malformed log entries safely
* Skips blank lines

---

## 🛠️ Technologies Used

* ☕ Java 17
* 📦 Maven
* 📂 Java NIO.2 (`Path`, `Files`)
* 🧾 Buffered I/O
* 🧪 JUnit 5

---

## ▶️ How to Run

### 1️⃣ Compile the project

```bash
mvn clean compile
```

### 2️⃣ Run the application

```bash
mvn clean package
java -cp target/classes ServerLogAnalyzer
```

### 3️⃣ Run tests

```bash
mvn test
```

---

## 📌 Sample Outputs

### 🚨 errors.txt

```text
2023-10-01 10:03:45 [ERROR] Database connection failed: Timeout detected
2023-10-01 10:05:15 [ERROR] NullPointerException at AuthService.java:45
```

---

### 📊 report.txt

```text
Server Log Analysis Report
--------------------------
INFO  : 5
WARN  : 2
ERROR : 3

Total Logs Processed: 10
```

---

### 🧹 clean.log

```text
[INFO] Server started
[WARN] CPU usage spike: 95%
[ERROR] Database connection failed
```
---

## 🎥 Demo

| 🎬 Demo Type | 📖 Description                    | 🔗 Link                          |
| ------------ | --------------------------------- | -------------------------------- |
| Overview     | Explain project structure & logic | [Video](https://youtu.be/QZkVDvB9IK8) |
