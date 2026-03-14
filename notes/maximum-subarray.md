# Maximum Subarray (Kadane's Algorithm)

## Problem
Given an array of integers, find the maximum sum of any contiguous subarray.
Contiguous means consecutive elements — no skipping.

```
Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]  → Output: 6   // [4, -1, 2, 1]
Input:  [1]                                → Output: 1
Input:  [-1, -2, -3]                       → Output: -1  // single element
```

---

## Key Insight

At every element you have exactly TWO choices:
1. Start fresh from this element
2. Extend the current running sum

If the current element alone is GREATER than (currentSum + element),
starting fresh is better — the previous sum is dragging you down.

You never need to track WHERE the subarray starts or ends.
You only need the highest value the array can produce.

---

## Brute Force — O(n²) time, O(1) space

```java
public int largestSum(int[] array) {
    int highestSum = array[0];

    for (int i = 0; i < array.length; i++) {
        int currentValue = array[i];
        if (currentValue > highestSum) highestSum = currentValue;

        for (int j = i + 1; j < array.length; j++) {
            currentValue = currentValue + array[j];
            if (currentValue > highestSum) highestSum = currentValue;
        }
    }

    return highestSum;
}
```

---

## Optimal — Kadane's Algorithm — O(n) time, O(1) space

```java
public int optimalLargestSum(int[] array) {
    int highestSum = array[0];
    int currentSum = array[0];

    for (int i = 0; i < array.length; i++) {

        // start fresh or extend?
        if (array[i] > currentSum + array[i]) {
            currentSum = array[i];          // start fresh
        } else {
            currentSum = currentSum + array[i]; // extend
        }

        // update highest if current is better
        if (currentSum > highestSum) {
            highestSum = currentSum;
        }
    }

    return highestSum;
}
```

---

## The two decisions simplified

```
currentSum = max(array[i], currentSum + array[i])
highestSum = max(highestSum, currentSum)
```

---

## Common mistakes

- Trying to track subarray start/end indices — not needed, just track the value
- Starting loop at i=1 without adjusting initialization — use array[0] for both
- Using i.length instead of array.length — arrays use .length (no parentheses, it's a field not a method)
- Forgetting to handle all-negative arrays — initializing to array[0] handles this

---

## Big O

Brute force: O(n²) time, O(1) space
Kadane's:    O(n)  time, O(1) space
