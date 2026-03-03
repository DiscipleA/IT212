const SortAlgorithm = require("./SortAlgorithm");
const { ensureIntegerArray } = require("../utils/validate");

class BubbleSort extends SortAlgorithm {
  constructor() {
    super("BubbleSort (Basic)");
  }

  _sortInPlace(arr) {
    ensureIntegerArray(arr);

    const n = arr.length;
    // Traditional bubble sort: always does (n-1) passes
    for (let pass = 0; pass < n - 1; pass++) {
      this.stats.passes++;

      for (let i = 0; i < n - 1 - pass; i++) {
        this.stats.comparisons++;

        if (arr[i] > arr[i + 1]) {
          // swap
          const tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;

          this.stats.swaps++;
        }
      }
    }

    return arr;
  }
}

module.exports = BubbleSort;