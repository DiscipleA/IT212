function randomInt(min, max) {
  // inclusive
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function makeRandomArray(size, min = -1000, max = 1000) {
  return Array.from({ length: size }, () => randomInt(min, max));
}

function makeAscendingArray(size) {
  return Array.from({ length: size }, (_, i) => i);
}

function makeDescendingArray(size) {
  return Array.from({ length: size }, (_, i) => size - 1 - i);
}

function makeUniformArray(size, value = 7) {
  return Array.from({ length: size }, () => value);
}

module.exports = {
  makeRandomArray,
  makeAscendingArray,
  makeDescendingArray,
  makeUniformArray
};