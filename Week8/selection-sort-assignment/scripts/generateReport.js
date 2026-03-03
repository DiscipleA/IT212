import path from "path";
import { fileURLToPath } from "url";

import { SelectionSort } from "../src/algorithms/SelectionSort.js";
import { OptimizedSelectionSort } from "../src/algorithms/OptimizedSelectionSort.js";
import { benchmarkSorter } from "../src/utils/metrics.js";
import { writeTextFile } from "../src/utils/reportWriter.js";
import { randomIntArray } from "../src/utils/arrayUtils.js";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

function formatMs(ms) {
  return `${ms.toFixed(4)} ms`;
}

function speedupPct(base, improved) {
  if (base <= 0) return 0;
  return ((base - improved) / base) * 100;
}

// Test inputs for benchmarking (mirrors assignment test categories)
const cases = [
  {
    name: "Random (n=200)",
    input: randomIntArray(200, -1000, 1000)
  },
  {
    name: "Already Sorted (n=200)",
    input: Array.from({ length: 200 }, (_, i) => i)
  },
  {
    name: "Descending (n=200)",
    input: Array.from({ length: 200 }, (_, i) => 200 - i)
  },
  {
    name: "All Same (n=200)",
    input: Array.from({ length: 200 }, () => 7)
  },
  {
    name: "Empty (n=0)",
    input: []
  },
  {
    name: "Single Element (n=1)",
    input: [42]
  }
];

const regular = new SelectionSort();
const optimized = new OptimizedSelectionSort();

const iterations = 80;

const results = cases.map((c) => {
  const regBench = benchmarkSorter(regular, c.input, iterations);
  const optBench = benchmarkSorter(optimized, c.input, iterations);

  const regMs = regBench.avgMs;
  const optMs = optBench.avgMs;

  const regMetrics = regBench.lastResult.metrics;
  const optMetrics = optBench.lastResult.metrics;

  return {
    caseName: c.name,
    n: c.input.length,
    regularMs: regMs,
    optimizedMs: optMs,
    speedup: speedupPct(regMs, optMs),
    regularMetrics: regMetrics,
    optimizedMetrics: optMetrics
  };
});

const avgRegular = results.reduce((s, r) => s + r.regularMs, 0) / results.length;
const avgOptimized = results.reduce((s, r) => s + r.optimizedMs, 0) / results.length;
const avgSpeedup = speedupPct(avgRegular, avgOptimized);

const now = new Date().toISOString();

const reportMd = `# Selection Sort Implementation & Analysis Report

> Generated automatically by \`npm run report\`  
> Timestamp: **${now}**

---

## Implementations Included

### 1) Regular Selection Sort (ascending)

\`\`\`js
// src/algorithms/SelectionSort.js (excerpt)
for (let i = 0; i < arr.length - 1; i++) {
  let minIndex = i;
  for (let j = i + 1; j < arr.length; j++) {
    if (arr[j] < arr[minIndex]) minIndex = j;
  }
  if (minIndex !== i) [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
}
\`\`\`

### 2) Optimized Variant: Min + Max per pass

\`\`\`js
// src/algorithms/OptimizedSelectionSort.js (excerpt)
while (left < right) {
  let minIndex = left;
  let maxIndex = left;

  for (let i = left; i <= right; i++) {
    if (arr[i] < arr[minIndex]) minIndex = i;
    if (arr[i] > arr[maxIndex]) maxIndex = i;
  }

  // swap min to left, max to right ...
  left++; right--;
}
\`\`\`

---

## Test Cases Used for Benchmarking

These cases mirror the assignment requirements:

- Random array
- Already sorted ascending
- Sorted descending
- All elements same
- Empty array (edge)
- Single-element array (edge)

---

## Benchmark Results (Average over ${iterations} iterations)

| Case | n | Regular Avg | Optimized Avg | Speedup |
|---|---:|---:|---:|---:|
${results
  .map(
    (r) =>
      `| ${r.caseName} | ${r.n} | ${formatMs(r.regularMs)} | ${formatMs(
        r.optimizedMs
      )} | ${r.speedup.toFixed(2)}% |`
  )
  .join("\n")}

### Overall Average
- Regular: **${formatMs(avgRegular)}**
- Optimized: **${formatMs(avgOptimized)}**
- Average speedup: **${avgSpeedup.toFixed(2)}%**

---

## Operation Counts (from the last run of each case)

> Counts come from internal instrumentation: comparisons + swaps.

| Case | Regular (comparisons, swaps) | Optimized (comparisons, swaps) |
|---|---|---|
${results
  .map((r) => {
    const a = r.regularMetrics;
    const b = r.optimizedMetrics;
    return `| ${r.caseName} | (${a.comparisons}, ${a.swaps}) | (${b.comparisons}, ${b.swaps}) |`;
  })
  .join("\n")}

---

## Analysis

### Time Complexity: Why it is **O(n²)**
Regular selection sort uses:
- An outer loop that runs roughly **n** times.
- An inner loop that scans the unsorted portion, on average **~n/2**, totaling about **n(n-1)/2 comparisons**.

Therefore, runtime grows proportionally to **n²**.

The optimized min+max variant still performs nested scanning across the remaining range each pass, so it remains **O(n²)**, but can reduce the number of passes and swaps in practice.

### Space Complexity: Why it is **O(1)**
Both algorithms rearrange elements using a constant amount of extra memory (a few index variables + swaps).  
That’s why Selection Sort is considered **in-place**.

### Stability: Is Selection Sort stable?
**Selection sort is generally NOT stable.**  
Reason: When you swap the minimum element into position \`i\`, you might move an element past another equal element, changing their original relative order.

Example idea:
- Suppose you have \`[ (2,a), (2,b), 1 ]\` where \`(2,a)\` and \`(2,b)\` are equal keys with different original labels.
- Selecting \`1\` and swapping it into the front can move \`(2,a)\` behind \`(2,b)\` in certain configurations.

---

## Enhancement Notes

- **Descending sort**: you would reverse the comparison (choose maximum instead of minimum), or invert the comparator.
- **Stability improvement** (conceptual): Instead of swapping, you can remove the minimum and insert it at \`i\` while shifting elements right (stable, but adds extra moves).

---

## How to Reproduce

1. Run tests: \`npm test\`
2. Generate report (this file): \`npm run report\`

`;

const outPath = path.join(__dirname, "..", "output", "REPORT.md");
writeTextFile(outPath, reportMd);

// Also print a short summary “on screen”
console.log("Report written to:", outPath);
console.log("Overall Average Regular:", formatMs(avgRegular));
console.log("Overall Average Optimized:", formatMs(avgOptimized));
console.log("Average speedup:", `${avgSpeedup.toFixed(2)}%`);