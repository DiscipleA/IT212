import { SelectionSort } from "./algorithms/SelectionSort.js";
import { OptimizedSelectionSort } from "./algorithms/OptimizedSelectionSort.js";
import { randomIntArray } from "./utils/arrayUtils.js";

const data = randomIntArray(12, 0, 50);

const regular = new SelectionSort();
const optimized = new OptimizedSelectionSort();

console.log("Input:", data);
console.log(regular.name, regular.sort(data));
console.log(optimized.name, optimized.sort(data));