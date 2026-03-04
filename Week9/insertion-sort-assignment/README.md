# Assignment IT212: Implementing and Analyzing Insertion Sort(Java + JavaScript)

## 📂 Project Overview
This project implements and analyzes **Insertion Sort** using a Java “engine” (algorithms + metrics) and a JavaScript (Node.js) runner for testing and reporting.

---

## 🚀 How it Works

- Java implements:
  - Regular **stable insertion sort**
  - Optimized **binary insertion sort** (fewer comparisons; still stable)
  - Metrics captured per run: time (ns), comparisons, writes/moves
- Node.js (JavaScript) calls the Java JAR using `child_process` and exchanges data via JSON.
- Jest integration tests verify:
  - correctness on edge cases
  - stability behavior via a Pair/object demo
- A report generator script benchmarks both algorithms and outputs a Markdown report.

---

## ✨ Features

- ✅ Stable insertion sort (regular)
- ✅ Optimized binary insertion sort (stable upper-bound insertion)
- ✅ Metrics: elapsed time, comparisons, writes/moves
- ✅ Jest integration tests (industry-style)
- ✅ Auto-generated analysis report in Markdown

---

## 📖 Project Structure

```text
java/   -> Java engine (Maven)
js/     -> Node.js runner + Jest tests + report generation
reports/-> Generated REPORT.md
```

---

## 🛠️ How to Run

### 1) Build Java
```bash
cd java
mvn -q -DskipTests package
```

### 2) Install JS dependencies
```bash
cd ../js
npm install
```

### 3) Run tests
```bash
npm test
```

### 4) Generate the report
```bash
npm run report
```

The report will be generated at:
```text
reports/REPORT.md
```