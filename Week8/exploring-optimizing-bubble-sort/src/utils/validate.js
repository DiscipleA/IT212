function ensureIntegerArray(arr) {
  if (!Array.isArray(arr)) {
    throw new TypeError("Input must be an array.");
  }
  for (const v of arr) {
    if (!Number.isInteger(v)) {
      throw new TypeError("Array must contain only integers.");
    }
  }
}

module.exports = { ensureIntegerArray };