const { performance } = require("perf_hooks");
const BubbleSort = require("../algorithms/BubbleSort");
const OptimizedBubbleSort = require("../algorithms/OptimizedBubbleSort");
const {
  makeRandomArray,
  makeAscendingArray,
  makeDescendingArray,
  makeUniformArray
} = require("../utils/generators");

function timeOne(sorter, input, iterations = 50) {
  // Warmup + average timing
  let total = 0;

  for (let i = 0; i < iterations; i++) {
    const t0 = performance.now();
    sorter.sort(input);
    const t1 = performance.now();
    total += (t1 - t0);
  }

  return total / iterations;
}

function runBenchmarks() {
  const basic = new BubbleSort();
  const optimized = new OptimizedBubbleSort();

  // Keep sizes moderate so Bubble Sort doesn't take forever
  const size = 800;

  const datasets = [
    { name: "Random", data: makeRandomArray(size) },
    { name: "Already Sorted (Best Case)", data: makeAscendingArray(size) },
    { name: "Descending (Worst Case)", data: makeDescendingArray(size) },
    { name: "All Identical", data: makeUniformArray(size, 7) },
    { name: "Empty (Edge)", data: [] },
    { name: "Single Element (Edge)", data: [42] }
  ];

  const results = datasets.map(({ name, data }) => {
    const basicMs = timeOne(basic, data);
    const optMs = timeOne(optimized, data);

    // Collect one representative stats run (not averaged)
    basic.sort(data);
    const basicStats = { ...basic.stats };

    optimized.sort(data);
    const optStats = { ...optimized.stats };

    return {
      name,
      size: data.length,
      basicMs,
      optimizedMs: optMs,
      basicStats,
      optimizedStats: optStats
    };
  });

  return {
    timestamp: new Date().toISOString(),
    node: process.version,
    results
  };
}

module.exports = { runBenchmarks };