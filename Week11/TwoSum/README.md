# Final Assignment IT212 (Part 1): Two Sum Leetcode Code & Recording

## Problem Overview

This project implements an efficient solution to the Two Sum problem using Java.

The goal is to find two indices in an integer array such that their values add up to a given target. The solution uses a HashMap to achieve optimal performance.

---

## Problem Summary

Given:

* An integer array `nums`
* An integer `target`

Return:

* The indices of the two numbers such that:
  nums[i] + nums[j] == target

Constraints:

* Exactly one valid solution exists
* You may not use the same element twice
* The answer can be returned in any order

---

## How It Works

The solution uses a HashMap to store numbers and their indices as we iterate through the array.

### Steps:

1. Create a HashMap to store value → index
2. Loop through the array
3. For each element:

   * Compute complement:
     complement = target - nums[i]
   * Check if complement exists in the map
   * If found → return indices
   * If not → store current number in map

---

## Features

* Efficient HashMasp Operation O(1) time complexity
* Uses HashMap for constant-time lookup
* Single-pass solution (no nested loops)
* Handles duplicate values correctly
* Clean and well-commented implementation

---

## Java Implementation

```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
```

---

## Complexity Analysis

### HashMap Operation O(1)

The array is traversed once, and each HashMap operation runs in constant time on average.

### Space Complexity: O(n)

The HashMap stores up to n elements in the worst case.

---

## Data Structure Used

HashMap:

* Stores number → index pairs
* Enables fast lookup
* Eliminates need for nested loops

---

## How to Run

### Option 1: LeetCode

1. Open the Two Sum problem
2. Select Java
3. Paste the solution
4. Run or submit

### Option 2: Local Java

1. Save as `Solution.java`
2. Compile:
   javac Solution.java
3. Run:
   java Solution

---

## Demo Video

| Part 1 | Description                               | Link                 |
| ------ | ----------------------------------------- | -------------------- |
| Problem Walkthrough  | https://youtu.be/jbbvZw0kch4 |

---

## Video Requirements Checklist

### Problem Summary

* Explained the problem clearly

### Data Structure Selection

* Used HashMap
* Justified choice over nested loops

### Code Walkthrough

* Explained:

  * containsKey()
  * get()
  * put()

### Complexity Analysis

* HashMap Operation Time: O(1)
* Space: O(n)
