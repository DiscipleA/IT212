class SortAlgorithm {
  constructor(name) {
    if (new.target === SortAlgorithm) {
      throw new Error("SortAlgorithm is abstract. Extend it.");
    }
    this.name = name;
    this.resetStats();
  }

  resetStats() {
    this.stats = {
      passes: 0,
      comparisons: 0,
      swaps: 0
    };
  }

  /**
   * Sorts a COPY of the input (so callers keep original data).
   * Subclasses should implement _sortInPlace(arr).
   */
  sort(input) {
    this.resetStats();
    const arr = Array.isArray(input) ? [...input] : [];
    return this._sortInPlace(arr);
  }

  // abstract
  _sortInPlace(_) {
    throw new Error("Not implemented");
  }
}

module.exports = SortAlgorithm;