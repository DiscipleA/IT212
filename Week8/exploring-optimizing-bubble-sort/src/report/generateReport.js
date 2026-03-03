const fs = require("fs");
const path = require("path");
const { runBenchmarks } = require("./benchmark");
const { percentImprovement, formatMs } = require("../utils/metrics");

function readSource(relativePathFromProjectRoot) {
  const full = path.join(process.cwd(), relativePathFromProjectRoot);
  return fs.readFileSync(full, "utf8");
}

function ensureReportsDir() {
  const dir = path.join(process.cwd(), "reports");
  if (!fs.existsSync(dir)) fs.mkdirSync(dir);
  return dir;
}

function buildMarkdown(benchmark) {
  const lines = [];
  lines.push(`# Bubble Sort Report (Basic vs Optimized)\n`);
  lines.push(`**Generated:** ${benchmark.timestamp}  `);
  lines.push(`**Node:** ${benchmark.node}\n`);

  lines.push(`## Objective\n`);
  lines.push(
    `Implement Bubble Sort, create an optimized early-exit version, verify correctness with tests, and analyze performance and complexity.\n`
  );

  lines.push(`## Implementations\n`);
  lines.push(
    `Two versions are implemented using an OOP-style interface:\n\n- **Basic Bubble Sort**: always performs the full set of passes\n- **Optimized Bubble Sort**: uses a \`hasSwapped\` flag to stop early when the array becomes sorted (matches the pseudocode technique shown in the assignment screenshots)\n`
  );

  lines.push(`### Basic Bubble Sort (source)\n`);
  lines.push("```js\n" + readSource("src/algorithms/BubbleSort.js") + "\n```\n");

  lines.push(`### Optimized Bubble Sort (source)\n`);
  lines.push("```js\n" + readSource("src/algorithms/OptimizedBubbleSort.js") + "\n```\n");

  lines.push(`## Test Cases (Correctness)\n`);
  lines.push(
    `Automated tests were written with Jest to cover:\n\n- Random integers\n- Already sorted (best case)\n- Descending (worst case)\n- Uniform elements\n- **Edge cases:** empty array, single element, negatives + duplicates\n`
  );

  lines.push(`## Benchmark Results\n`);
  lines.push(
    `Each dataset is run multiple times and averaged to estimate runtime. Times will vary by machine, but **relative** performance is what matters.\n`
  );

  lines.push(`| Case | n | Basic Avg | Optimized Avg | Improvement |\n|---|---:|---:|---:|---:|\n`);
  for (const r of benchmark.results) {
    const imp = percentImprovement(r.basicMs, r.optimizedMs);
    lines.push(
      `| ${r.name} | ${r.size} | ${formatMs(r.basicMs)} | ${formatMs(r.optimizedMs)} | ${imp.toFixed(2)}% |\n`
    );
  }
  lines.push("\n");

  lines.push(`### Representative Operation Counts (one run)\n`);
  lines.push(
    `These counts (passes/comparisons/swaps) help explain why the optimized version is much faster on best-case inputs.\n`
  );
  lines.push(`| Case | Basic Passes | Opt Passes | Basic Comparisons | Opt Comparisons | Basic Swaps | Opt Swaps |\n`);
  lines.push(`|---|---:|---:|---:|---:|---:|---:|\n`);
  for (const r of benchmark.results) {
    lines.push(
      `| ${r.name} | ${r.basicStats.passes} | ${r.optimizedStats.passes} | ${r.basicStats.comparisons} | ${r.optimizedStats.comparisons} | ${r.basicStats.swaps} | ${r.optimizedStats.swaps} |\n`
    );
  }
  lines.push("\n");

  lines.push(`## Analysis\n`);

  lines.push(`### Time Complexity\n`);
  lines.push(
    `- **Average case:** **O(n²)** — nested loops compare adjacent elements across ~n passes, doing ~n comparisons per pass.\n` +
    `- **Worst case (descending):** **O(n²)** — many swaps occur, but the number of comparisons still scales quadratically.\n` +
    `- **Best case (already sorted):**\n` +
    `  - Basic version: still **O(n²)** comparisons because it always completes all passes.\n` +
    `  - Optimized version: can stop after the first pass when no swaps occur → **O(n)** comparisons for the best case.\n`
  );

  lines.push(`### Space Complexity\n`);
  lines.push(
    `Bubble Sort is **in-place** with **O(1)** extra space: it only uses a small constant amount of additional memory (temporary variables for swaps).`
  );
  lines.push("\n");

  lines.push(`### Stability\n`);
  lines.push(
    `Bubble Sort is typically **stable** because it swaps only when the left element is strictly greater than the right element. Equal elements are not swapped, so their relative order is preserved.\n`
  );

  lines.push(`## How to Reproduce\n`);
  lines.push(`\`\`\`bash\nnpm install\nnpm test\nnpm run report\n\`\`\`\n`);

  return lines.join("");
}

function main() {
  const benchmark = runBenchmarks();
  const md = buildMarkdown(benchmark);

  const reportsDir = ensureReportsDir();
  const outPath = path.join(reportsDir, "bubble-sort-report.md");
  fs.writeFileSync(outPath, md, "utf8");

  console.log(`Report generated: ${outPath}`);
}

main();