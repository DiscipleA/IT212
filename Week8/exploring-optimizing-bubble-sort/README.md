
# Assignment IT212: Exploring and Optimizing Bubble Sort (JavaScript, OOP)

## 📂 Project Overview
This project implements **Bubble Sort** in two ways:

- **Basic Bubble Sort** (traditional)
- **Optimized Bubble Sort** (early-exit using a `hasSwapped` flag)

It includes:
- Automated **Jest** tests (correctness + edge cases)
- A **benchmark + report generator** that creates a fancy Markdown report comparing runtime metrics

---

## ✨ Features

- OOP-style algorithm design (base class + concrete implementations)
- Two Bubble Sort implementations:
  - Basic: always completes all passes
  - Optimized: exits early when no swaps occur
- Test suite covering:
  - Random data
  - Already sorted (best case)
  - Descending (worst case)
  - Uniform elements
  - Edge cases: empty array, single element, negatives + duplicates
- Generates `reports/bubble-sort-report.md` automatically with:
  - Code snippets
  - Benchmark results table
  - Complexity analysis
  - Representative operation counts (passes/comparisons/swaps)

---

## 🚀 How it Works

Bubble Sort repeatedly compares adjacent elements and swaps them if they are out of order. Each pass “bubbles” the largest remaining value toward the end.

The optimized version uses a boolean flag:

- Start a pass assuming no swaps will happen
- If any swap happens, set `hasSwapped = true`
- If a full pass completes with no swaps, the array is already sorted → stop early

This can reduce best-case time from **O(n²)** to **O(n)**.

---

## 📖 Project Structure

```text
src/algorithms/  -> sorting implementations (OOP)
src/utils/       -> helpers (generators, validation, metrics)
tests/           -> Jest tests
src/report/      -> benchmark + report generator
reports/         -> generated Markdown report
```

## 🛠️ How to Run

### 1) Install dependencies
```bash
npm install
```

### 2) Run tests
```bash
npm test
```

### 3) Generate the benchmark report
```bash
npm run report
```

After running, open:
```text
reports/bubble-sort-report.md
```