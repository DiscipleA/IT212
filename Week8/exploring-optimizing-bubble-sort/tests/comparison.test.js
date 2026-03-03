const BubbleSort = require("../src/algorithms/BubbleSort");
const OptimizedBubbleSort = require("../src/algorithms/OptimizedBubbleSort");

describe("Basic vs Optimized produce identical results", () => {
  test("same output for multiple inputs", () => {
    const basic = new BubbleSort();
    const opt = new OptimizedBubbleSort();

    const cases = [
      [],
      [1],
      [2, 1],
      [3, 1, 2],
      [5, 4, 3, 2, 1],
      [7, 7, 7],
      [10, -2, 0, 10, 3]
    ];

    for (const input of cases) {
      expect(opt.sort(input)).toEqual(basic.sort(input));
    }
  });
});