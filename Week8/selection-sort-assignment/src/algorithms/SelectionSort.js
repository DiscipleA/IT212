import { SorterBase } from "./SorterBase.js";

/**
 * Regular Selection Sort (ascending).
 * Time: O(n^2), Space: O(1) extra (in-place on a copy, not on the input).
 */
export class SelectionSort extends SorterBase {
  constructor() {
    super("Regular Selection Sort");
  }

  sort(inputArray) {
    // Work on a copy to avoid mutating the caller’s array (industry-friendly).
    const arr = [...inputArray];

    let comparisons = 0;
    let swaps = 0;

    for (let i = 0; i < arr.length - 1; i++) {
      // Assume the smallest element is at i
      let minIndex = i;

      // Find the index of the smallest element in the remaining unsorted portion
      for (let j = i + 1; j < arr.length; j++) {
        comparisons++;
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      // Swap only if needed (small practical optimization; still "regular" selection sort)
      if (minIndex !== i) {
        [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
        swaps++;
      }
    }

    return { sorted: arr, metrics: { comparisons, swaps } };
  }
}