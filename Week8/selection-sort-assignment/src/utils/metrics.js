/**
 * Measure runtime of a function using high-resolution clock.
 * Returns elapsed time in milliseconds.
 */
export function timeMs(fn) {
  const start = process.hrtime.bigint();
  fn();
  const end = process.hrtime.bigint();
  const ns = end - start;
  return Number(ns) / 1_000_000; // ms
}

/**
 * Runs sorter.sort multiple times and returns average ms + last result.
 * @param {SorterBase} sorter
 * @param {number[]} input
 * @param {number} iterations
 */
export function benchmarkSorter(sorter, input, iterations = 50) {
  let last = null;
  const ms = timeMs(() => {
    for (let i = 0; i < iterations; i++) {
      last = sorter.sort(input);
    }
  });

  return {
    avgMs: ms / iterations,
    lastResult: last
  };
}