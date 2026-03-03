import { OptimizedSelectionSort } from "../src/algorithms/OptimizedSelectionSort.js";
import { isSortedAscending } from "../src/utils/arrayUtils.js";

describe("OptimizedSelectionSort (min+max)", () => {
  const sorter = new OptimizedSelectionSort();

  test("Random array sorts ascending", () => {
    const input = [10, 2, 8, 2, -1, 3];
    const { sorted } = sorter.sort(input);
    expect(isSortedAscending(sorted)).toBe(true);
    expect(sorted).toEqual([-1, 2, 2, 3, 8, 10]);
  });

  test("Already sorted array remains sorted", () => {
    const input = [1, 2, 3, 4, 5, 6];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([1, 2, 3, 4, 5, 6]);
  });

  // Edge cases
  test("Empty array", () => {
    const input = [];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([]);
  });
});