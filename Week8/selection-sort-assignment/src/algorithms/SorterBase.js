/**
 * Abstract-ish base class for sorters.
 * Concrete classes should implement `sort(inputArray)`.
 */
export class SorterBase {
  constructor(name) {
    this.name = name;
  }

  /**
   * @param {number[]} inputArray
   * @returns {{ sorted: number[], metrics: { comparisons: number, swaps: number } }}
   */
  sort(inputArray) {
    throw new Error("sort() must be implemented by subclasses.");
  }
}