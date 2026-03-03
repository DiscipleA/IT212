const BubbleSort = require("../src/algorithms/BubbleSort");

describe("BubbleSort (Basic) correctness", () => {
  test("random array sorts ascending", () => {
    const sorter = new BubbleSort();
    const input = [3, -1, 0, 10, 2];
    expect(sorter.sort(input)).toEqual([-1, 0, 2, 3, 10]);
  });

  test("already sorted array remains sorted (best-case input)", () => {
    const sorter = new BubbleSort();
    const input = [1, 2, 3, 4, 5];
    expect(sorter.sort(input)).toEqual([1, 2, 3, 4, 5]);
  });

  test("descending array sorts (worst-case input)", () => {
    const sorter = new BubbleSort();
    const input = [5, 4, 3, 2, 1];
    expect(sorter.sort(input)).toEqual([1, 2, 3, 4, 5]);
  });

  test("uniform array stays same", () => {
    const sorter = new BubbleSort();
    const input = [7, 7, 7, 7];
    expect(sorter.sort(input)).toEqual([7, 7, 7, 7]);
  });

  // Edge case 1
  test("empty array returns empty (edge case)", () => {
    const sorter = new BubbleSort();
    expect(sorter.sort([])).toEqual([]);
  });

  // Edge case 2
  test("single element returns same (edge case)", () => {
    const sorter = new BubbleSort();
    expect(sorter.sort([42])).toEqual([42]);
  });
});