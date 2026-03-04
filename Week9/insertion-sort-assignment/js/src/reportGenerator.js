const fs = require("node:fs");
const path = require("node:path");
const { sortWithJava, stabilityDemo } = require("./javaRunner");

function makeRandomArray(n, seed = 12345) {
  // deterministic-ish PRNG for repeatable results
  let x = seed >>> 0;
  const a = new Array(n);
  for (let i = 0; i < n; i++) {
    x = (1103515245 * x + 12345) >>> 0;
    a[i] = (x % 100000) - 50000;
  }
  return a;
}

function makeNearlySortedArray(n) {
  const a = Array.from({ length: n }, (_, i) => i);
  // introduce a few small swaps
  for (let k = 0; k < Math.max(1, Math.floor(n * 0.01)); k++) {
    const i = Math.floor((k * 97) % n);
    const j = Math.floor((k * 193) % n);
    [a[i], a[j]] = [a[j], a[i]];
  }
  return a;
}

function makeReversedArray(n) {
  return Array.from({ length: n }, (_, i) => n - i);
}

function runMany(algorithm, dataFactory, runs) {
  const samples = [];
  for (let i = 0; i < runs; i++) {
    const data = dataFactory(i);
    const r = sortWithJava(algorithm, data);
    samples.push(r);
  }
  return samples;
}

function avg(nums) {
  if (nums.length === 0) return 0;
  return Math.round(nums.reduce((a, b) => a + b, 0) / nums.length);
}

function summarize(samples) {
  return {
    n: samples[0]?.n ?? 0,
    avgElapsedNanos: avg(samples.map(s => s.elapsedNanos)),
    avgComparisons: avg(samples.map(s => s.comparisons)),
    avgWrites: avg(samples.map(s => s.writes))
  };
}

function nanosToMs(nanos) {
  return (nanos / 1e6).toFixed(3);
}

function tableRow(label, reg, bin) {
  return `| ${label} | ${reg.n} | ${nanosToMs(reg.avgElapsedNanos)} | ${reg.avgComparisons} | ${reg.avgWrites} | ${nanosToMs(bin.avgElapsedNanos)} | ${bin.avgComparisons} | ${bin.avgWrites} |`;
}

function ensureReportsDir() {
  const reportsDir = path.resolve(__dirname, "../../reports");
  fs.mkdirSync(reportsDir, { recursive: true });
  return reportsDir;
}

function main() {
  // Part 1 test arrays
  const small = [5, 2, 9, 1, 5, 6];
  const largeN = 5000;          // keep reasonable for insertion sort
  const nearlyN = 5000;
  const reversedN = 5000;

  // Part 2 analysis sampling
  const randomSizes = [200, 500, 1000, 2000];
  const runsPerSize = 5;

  // Correctness quick check (Part 1 style)
  const part1RegularSmall = sortWithJava("regular", small);
  const part1BinarySmall = sortWithJava("binary", small);

  // Best-case (nearly sorted)
  const bestReg = summarize(runMany("regular", () => makeNearlySortedArray(nearlyN), 3));
  const bestBin = summarize(runMany("binary", () => makeNearlySortedArray(nearlyN), 3));

  // Worst-case (reversed)
  const worstReg = summarize(runMany("regular", () => makeReversedArray(reversedN), 3));
  const worstBin = summarize(runMany("binary", () => makeReversedArray(reversedN), 3));

  // Average-case (random)
  const avgResults = [];
  for (const n of randomSizes) {
    const regSamples = runMany("regular", (i) => makeRandomArray(n, 1000 + i), runsPerSize);
    const binSamples = runMany("binary", (i) => makeRandomArray(n, 2000 + i), runsPerSize);
    avgResults.push({
      n,
      regular: summarize(regSamples),
      binary: summarize(binSamples)
    });
  }

  // Stability demo (Part 2)
  const stab = stabilityDemo();

  const reportLines = [];

  reportLines.push(`# Insertion Sort — Implementation & Analysis Report`);
  reportLines.push(``);
  reportLines.push(`Generated: ${new Date().toISOString()}`);
  reportLines.push(``);

  reportLines.push(`## Part 1 — Implementation Summary`);
  reportLines.push(`Two Java implementations were built and called from JavaScript (Node.js):`);
  reportLines.push(`- **Regular Insertion Sort** (stable by shifting only elements \`>\` key)`);
  reportLines.push(`- **Binary Insertion Sort** (optimized comparisons using upper-bound binary search; still stable)`);
  reportLines.push(``);
  reportLines.push(`**Small array sanity check:**`);
  reportLines.push(`- Regular sortedOk: \`${part1RegularSmall.sortedOk}\`, result: \`${JSON.stringify(part1RegularSmall.sorted)}\``);
  reportLines.push(`- Binary sortedOk: \`${part1BinarySmall.sortedOk}\`, result: \`${JSON.stringify(part1BinarySmall.sorted)}\``);
  reportLines.push(``);

  reportLines.push(`## Part 2 — Performance Analysis (Metrics from Java)`);
  reportLines.push(`**Metrics tracked:** elapsed time (ns), comparisons, writes/moves.`);
  reportLines.push(``);
  reportLines.push(`### Best-case (Nearly Sorted)`);
  reportLines.push(`Insertion sort performs well here because very few elements need shifting; the inner loop exits quickly.`);
  reportLines.push(``);
  reportLines.push(`### Worst-case (Reversed)`);
  reportLines.push(`This forces maximum shifting: each new key moves to the front, producing ~O(n²) writes and comparisons.`);
  reportLines.push(``);

  reportLines.push(`#### Summary table (best vs worst)`);
  reportLines.push(`| Scenario | n | Regular ms | Regular comparisons | Regular writes | Binary ms | Binary comparisons | Binary writes |`);
  reportLines.push(`|---|---:|---:|---:|---:|---:|---:|---:|`);
  reportLines.push(tableRow("Best (nearly)", bestReg, bestBin));
  reportLines.push(tableRow("Worst (reversed)", worstReg, worstBin));
  reportLines.push(``);

  reportLines.push(`### Average-case (Random arrays)`);
  reportLines.push(`Average-case remains **O(n²)**, but the binary variant typically reduces comparisons (still must shift).`);
  reportLines.push(``);
  reportLines.push(`| n | Regular ms | Regular comparisons | Regular writes | Binary ms | Binary comparisons | Binary writes |`);
  reportLines.push(`|---:|---:|---:|---:|---:|---:|---:|`);
  for (const row of avgResults) {
    reportLines.push(
      `| ${row.n} | ${nanosToMs(row.regular.avgElapsedNanos)} | ${row.regular.avgComparisons} | ${row.regular.avgWrites} | ` +
      `${nanosToMs(row.binary.avgElapsedNanos)} | ${row.binary.avgComparisons} | ${row.binary.avgWrites} |`
    );
  }
  reportLines.push(``);

  reportLines.push(`### Space Complexity Discussion`);
  reportLines.push(`Both implementations are **in-place**: they sort within the array using a constant amount of extra memory (O(1) auxiliary space).`);
  reportLines.push(``);

  reportLines.push(`### Stability Analysis`);
  reportLines.push(`A Java stability demo sorts pairs by key and returns the relative order of tags with the same key.`);
  reportLines.push(`- Expected order for key=2: \`["A","B","C"]\``);
  reportLines.push(`- Observed: \`${JSON.stringify(stab.key2Order)}\``);
  reportLines.push(``);

  reportLines.push(`## Part 3 — Reflection`);
  reportLines.push(`### Efficiency Discussion`);
  reportLines.push(`- **Small arrays:** insertion sort is often very competitive due to low overhead and cache-friendly behavior.`);
  reportLines.push(`- **Large arrays:** O(n²) growth becomes expensive; algorithms like QuickSort/MergeSort are typically preferred.`);
  reportLines.push(`- **Binary insertion:** reduces comparisons but does not eliminate O(n²) shifts, so improvements are noticeable mostly in comparison-heavy contexts.`);
  reportLines.push(``);
  reportLines.push(`### Practical Applications`);
  reportLines.push(`- Sorting small lists (UI items, short buffers).`);
  reportLines.push(`- Nearly-sorted datasets (incremental updates).`);
  reportLines.push(`- As a building block in hybrid sorts (e.g., TimSort uses insertion sort on small runs).`);
  reportLines.push(``);
  reportLines.push(`### Improvements and Variations`);
  reportLines.push(`- **Binary insertion sort:** reduces comparisons using binary search (implemented here).`);
  reportLines.push(`- **Hybrid algorithms:** TimSort combines merge strategies with insertion sort for small partitions/runs.`);
  reportLines.push(`- **Sentinel optimization / gap insertion variants:** reduce bounds checks or shift patterns in low-level implementations.`);
  reportLines.push(``);

  reportLines.push(`## Code Snippets (from Java)`);
  reportLines.push(`### Regular stable inner loop`);
  reportLines.push("```java\nwhile (j >= 0) {\n    comparisons++;\n    if (a[j] > key) {\n        a[j + 1] = a[j];\n        writes++;\n        j--;\n    } else {\n        break;\n    }\n}\n```");
  reportLines.push(``);
  reportLines.push(`### Binary insertion stable position (upper bound)`);
  reportLines.push("```java\nif (a[mid] <= key) {\n    lo = mid + 1;\n} else {\n    hi = mid;\n}\n```");
  reportLines.push(``);

  const reportsDir = ensureReportsDir();
  const reportPath = path.join(reportsDir, "REPORT.md");
  fs.writeFileSync(reportPath, reportLines.join("\n"), "utf-8");

  console.log(`Report generated: ${reportPath}`);
}

main();