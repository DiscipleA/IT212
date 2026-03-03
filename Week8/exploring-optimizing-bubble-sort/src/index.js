const BubbleSort = require("./algorithms/BubbleSort");
const OptimizedBubbleSort = require("./algorithms/OptimizedBubbleSort");

const input = [5, 1, 4, 2, 8];

const basic = new BubbleSort();
const opt = new OptimizedBubbleSort();

console.log("Input:", input);

const sortedBasic = basic.sort(input);
console.log("\nBasic sorted:", sortedBasic);
console.log("Basic stats:", basic.stats);

const sortedOpt = opt.sort(input);
console.log("\nOptimized sorted:", sortedOpt);
console.log("Optimized stats:", opt.stats);