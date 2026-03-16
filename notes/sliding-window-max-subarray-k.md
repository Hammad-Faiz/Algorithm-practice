# Sliding Window — Maximum Sum Subarray of Size K

## Problem
Given an array of integers and a number k, find the maximum sum
of any contiguous subarray of size k.

```
Input:  array = [2, 1, 5, 1, 3, 2], k = 3  → Output: 9  ([5, 1, 3])
Input:  array = [2, 3, 4, 1, 5],    k = 2  → Output: 7  ([3, 4])
```

---

## Key Insight — Sliding Window

Instead of recalculating the sum of k elements from scratch each time:
- Remove the element leaving the window (leftmost)
- Add the element entering the window (rightmost)

```
[2, 1, 5] = 8  →  remove 2, add 1  →  [1, 5, 1] = 7
[1, 5, 1] = 7  →  remove 1, add 3  →  [5, 1, 3] = 9
[5, 1, 3] = 9  →  remove 5, add 2  →  [1, 3, 2] = 6
```

Formula: newSum = oldSum - array[i - k] + array[i]

---

## Why two loops?

Loop 1: calculate sum of first k elements (i = 0 to k-1)
Loop 2: slide the window (i = k to array.length-1)

The two loops together visit each element exactly once → O(n)
Loop 1 covers indices 0 to k-1
Loop 2 covers indices k to n-1
Combined = all n elements, one pass

---

## Solution

```java
public int returnSubarrayOfK(int[] array, int k) {

    // Loop 1: calculate first window sum
    int getSum = 0;
    for (int i = 0; i < k; i++) {
        getSum += array[i];
    }

    int highestSum = getSum; // initialize to first window — handles negative arrays

    // Loop 2: slide the window
    for (int i = k; i < array.length; i++) { // i < array.length NOT i <= array.length
        getSum = getSum - array[i - k] + array[i];
        if (getSum > highestSum) {
            highestSum = getSum;
        }
    }

    return highestSum;
}
```

---

## Common mistakes

- `i <= array.length` → ArrayIndexOutOfBoundsException when i == array.length
  Always use `i < array.length`
- `highestSum = 0` → wrong for all-negative arrays
  Initialize to first window sum instead
- Trying to do it in one loop — two loops is cleaner and still O(n)
- `array[i - k]` only works because loop starts at i=k, so i-k is always >= 0

---

## Big O

Time:  O(n) — two loops that together visit each element exactly once
Space: O(1) — two primitive int variables
