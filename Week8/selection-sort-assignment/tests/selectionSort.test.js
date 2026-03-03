import { SelectionSort } from "../src/algorithms/SelectionSort.js";
import { isSortedAscending } from "../src/utils/arrayUtils.js";

describe("SelectionSort (regular)", () => {
  const sorter = new SelectionSort();

  test("Random array sorts ascending", () => {
    const input = [5, 1, 9, 2, 0, -3, 7];
    const { sorted } = sorter.sort(input);
    expect(isSortedAscending(sorted)).toBe(true);
    expect(sorted).toEqual([-3, 0, 1, 2, 5, 7, 9]);
  });

  test("Already sorted array remains sorted", () => {
    const input = [1, 2, 3, 4, 5];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([1, 2, 3, 4, 5]);
  });

  test("Descending array sorts ascending", () => {
    const input = [5, 4, 3, 2, 1];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([1, 2, 3, 4, 5]);
  });

  // Edge cases (at least 3)
  test("All elements same", () => {
    const input = [7, 7, 7, 7];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([7, 7, 7, 7]);
  });

  test("Empty array", () => {
    const input = [];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([]);
  });

  test("Single element array", () => {
    const input = [42];
    const { sorted } = sorter.sort(input);
    expect(sorted).toEqual([42]);
  });
});