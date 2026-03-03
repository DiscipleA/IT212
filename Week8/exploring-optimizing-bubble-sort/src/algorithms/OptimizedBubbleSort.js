const SortAlgorithm = require("./SortAlgorithm");
const { ensureIntegerArray } = require("../utils/validate");

class OptimizedBubbleSort extends SortAlgorithm {
  constructor() {
    super("BubbleSort (Optimized Early-Exit)");
  }

  _sortInPlace(arr) {
    ensureIntegerArray(arr);

    const n = arr.length;
    let hasSwapped = true;

    // Matches the "flag" technique shown in your screenshots:
    // while(hasSwapped) { hasSwapped=false; ... if swap then hasSwapped=true }
    for (let pass = 0; pass < n - 1 && hasSwapped; pass++) {
      this.stats.passes++;
      hasSwapped = false;

      for (let i = 0; i < n - 1 - pass; i++) {
        this.stats.comparisons++;

        if (arr[i] > arr[i + 1]) {
          const tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;

          this.stats.swaps++;
          hasSwapped = true;
        }
      }
    }

    return arr;
  }
}

module.exports = OptimizedBubbleSort;