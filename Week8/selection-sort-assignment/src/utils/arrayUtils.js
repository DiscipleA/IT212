export function isSortedAscending(arr) {
  for (let i = 1; i < arr.length; i++) {
    if (arr[i - 1] > arr[i]) return false;
  }
  return true;
}

export function randomIntArray(length, min = -1000, max = 1000) {
  const out = [];
  for (let i = 0; i < length; i++) {
    const val = Math.floor(Math.random() * (max - min + 1)) + min;
    out.push(val);
  }
  return out;
}