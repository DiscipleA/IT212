# Assignment IT212: Implementing and Analyzing Selection Sort (JavaScript)

## 📂 Project Overview
This project implements **Selection Sort** in JavaScript in two ways:
1. **Regular Selection Sort** (classic approach)
2. **Optimized Selection Sort** (min + max selection per pass)

It includes:
- Automated **Jest tests**
- A benchmark script that generates a **Markdown report** comparing runtimes and operation counts.

---

## ✨ Features

- ✅ Two Selection Sort implementations (regular + optimized)
- ✅ Unit tests covering required scenarios:
  - Random array
  - Already sorted
  - Descending order
  - All elements same
  - Empty array (edge)
  - Single element (edge)
- ✅ Benchmarking (high-resolution timing)
- ✅ Auto-generated report: `output/REPORT.md`
- ✅ Clean “industry-style” folder structure

---

## 📖 Project Structure

```txt
selection-sort-assignment/
├─ src/
│  ├─ algorithms/
│  ├─ utils/
│  └─ index.js
├─ tests/
├─ scripts/
└─ output/
```
---

## 🚀 How it Works

### Regular Selection Sort
 - Walks the array from left to right.
 - For each position i, finds the smallest element in the remaining unsorted portion and swaps it into place.

### Optimized Variant (Min + Max per pass)
 - Each pass finds both the minimum and maximum in the remaining range.
 - Places min at the left boundary and max at the right boundary.
 - Shrinks inward each pass.
 - Still O(n²), but can reduce passes/swaps in practice.

## 🛠️ How to Run

### 1) Install dependencies
```bash
npm install
```

### 2) Run unit tests
```bash
npm test
```

### 3) Generate the performance report
```bash
npm run report
```
This will create:
```txt
output/REPORT.md
```

### 4) Optional: run the demo
```bash
npm run start
```
