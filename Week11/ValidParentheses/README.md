# Final Assignment IT212 (Part2): Valid Parentheses LeetCode Recording & Code

## Problem Overview

This assignment solves the LeetCode problem **Valid Parentheses** using Java.

The goal is to determine whether a string containing only parentheses and brackets is valid.

A string is valid if:

* Every opening bracket has a matching closing bracket
* Brackets are closed in the correct order
* Each closing bracket matches the correct type

---

## Problem Summary

Given a string `s` containing only:
`()`, `{}`, `[]`

Return `true` if the string is valid, otherwise return `false`.

---

## Features

* Uses an efficient **Stack-based solution**
* Handles all edge cases (invalid order, missing brackets)
* Clean and readable Java implementation
* Optimal time and space complexity
* Easy to understand logic

---

## Data Structure Used

### Stack

A **Stack** follows Last-In-First-Out (LIFO).

This is important because:

* The most recent opening bracket must be matched first
* It avoids re-checking earlier elements (efficient)

---

## Algorithm (Step-by-Step)

1. Create a stack to store opening brackets
2. Loop through each character in the string
3. If it is an opening bracket → push to stack
4. If it is a closing bracket:

   * Check if stack is empty → return false
   * Pop from stack
   * Compare if it matches the correct type
5. After loop ends:

   * If stack is empty → return true
   * Otherwise → return false

---

## Java Implementation

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
```

---

## Example Walkthrough

Input:

```
([])
```

| Step | Character | Action      | Stack |
| ---- | --------- | ----------- | ----- |
| 1    | (         | push        | (     |
| 2    | [         | push        | ([    |
| 3    | ]         | pop & match | (     |
| 4    | )         | pop & match | empty |

Result: **true**

---

## Complexity Analysis

### Time Complexity: O(n)

* Each character is processed once

### Space Complexity: O(n)

* Stack may store all opening brackets in worst case

---

## How to Run

### Run on LeetCode

1. Open the problem
2. Paste code
3. Click Run or Submit

### Run Locally

```
javac Solution.java
java Solution
```

---

## Video Demonstration

| Description Part 2          | Link                  |
| --------------------------- | --------------------- |
| Problem + Code Walkthrough  | [Access Video Here](https://youtu.be/ITKXgWpAG1g) |

---

## Conclusion

Using a Stack provides the most efficient way to validate parentheses by ensuring correct order and matching types in a single pass.