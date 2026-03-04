const { sortWithJava, stabilityDemo } = require("../src/javaRunner");

function isSortedAscending(a) {
  for (let i = 1; i < a.length; i++) {
    if (a[i - 1] > a[i]) return false;
  }
  return true;
}

describe("Insertion Sort via Java engine (integration)", () => {
  test("Edge case: empty array", () => {
    const r1 = sortWithJava("regular", []);
    const r2 = sortWithJava("binary", []);
    expect(r1.sorted).toEqual([]);
    expect(r2.sorted).toEqual([]);
    expect(r1.sortedOk).toBe(true);
    expect(r2.sortedOk).toBe(true);
  });

  test("Edge case: single element", () => {
    const r1 = sortWithJava("regular", [42]);
    const r2 = sortWithJava("binary", [42]);
    expect(r1.sorted).toEqual([42]);
    expect(r2.sorted).toEqual([42]);
  });

  test("Edge case: duplicates + general correctness", () => {
    const input = [3, 1, 2, 2, 5, 2, 1];
    const r1 = sortWithJava("regular", input);
    const r2 = sortWithJava("binary", input);

    expect(isSortedAscending(r1.sorted)).toBe(true);
    expect(isSortedAscending(r2.sorted)).toBe(true);

    // Same multiset check by comparing to JS numeric sort
    const expected = [...input].sort((a, b) => a - b);
    expect(r1.sorted).toEqual(expected);
    expect(r2.sorted).toEqual(expected);
  });

  test("Stability demo: equal keys preserve original order", () => {
    // Java sorts pairs by key and returns order of tags for key=2
    const demo = stabilityDemo();
    expect(demo.key2Order).toEqual(["A", "B", "C"]);
  });
});