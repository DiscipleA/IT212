import { SorterBase } from "./SorterBase.js";

/**
 * Optimized Selection Sort variant: double-ended selection (min + max each pass).
 * Still O(n^2), but may reduce iterations/passes and swaps in practice.
 */
export class OptimizedSelectionSort extends SorterBase {
  constructor() {
    super("Optimized Selection Sort (Min+Max per pass)");
  }

  sort(inputArray) {
    const arr = [...inputArray];

    let comparisons = 0;
    let swaps = 0;

    let left = 0;
    let right = arr.length - 1;

    while (left < right) {
      let minIndex = left;
      let maxIndex = left;

      // Find min and max in [left..right]
      for (let i = left; i <= right; i++) {
        comparisons++;
        if (arr[i] < arr[minIndex]) minIndex = i;

        comparisons++;
        if (arr[i] > arr[maxIndex]) maxIndex = i;
      }

      // Move min to left
      if (minIndex !== left) {
        [arr[left], arr[minIndex]] = [arr[minIndex], arr[left]];
        swaps++;

        // If maxIndex was pointing to left, it now points to where min was
        if (maxIndex === left) {
          maxIndex = minIndex;
        }
      }

      // Move max to right
      if (maxIndex !== right) {
        [arr[right], arr[maxIndex]] = [arr[maxIndex], arr[right]];
        swaps++;
      }

      left++;
      right--;
    }

    return { sorted: arr, metrics: { comparisons, swaps } };
  }
}