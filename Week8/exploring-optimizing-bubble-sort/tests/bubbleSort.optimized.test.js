const OptimizedBubbleSort = require("../src/algorithms/OptimizedBubbleSort");

describe("BubbleSort (Optimized) correctness", () => {
  test("random array sorts ascending", () => {
    const sorter = new OptimizedBubbleSort();
    const input = [9, 1, 9, 0, -3];
    expect(sorter.sort(input)).toEqual([-3, 0, 1, 9, 9]);
  });

  test("already sorted triggers early exit (passes should be 1 for n>1)", () => {
    const sorter = new OptimizedBubbleSort();
    const input = [1, 2, 3, 4, 5];
    sorter.sort(input);
    expect(sorter.stats.passes).toBe(1);
  });

  // Edge case 3 (another edge beyond empty/single)
  test("handles negative numbers and duplicates", () => {
    const sorter = new OptimizedBubbleSort();
    const input = [0, -1, -1, 2, 1];
    expect(sorter.sort(input)).toEqual([-1, -1, 0, 1, 2]);
  });
});