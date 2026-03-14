# Two Sum

## Problem
Given an array of integers, return the indices of the two numbers that add up to a target sum.

```
Input:  nums = [2, 7, 11, 15], target = 9   → Output: [0, 1]
Input:  nums = [3, 2, 4],      target = 6   → Output: [1, 2]
Input:  nums = [3, 3],         target = 6   → Output: [0, 1]
```

Rules:
- Each input has exactly one solution
- Cannot use the same element twice
- Return the indices, not the values

---

## Approach

Brute force: two nested loops checking every pair → O(n²) — not acceptable at interview level

Optimal: HashMap in a single loop → O(n)

Key insight:
- For each element, you need `target - currentValue` to exist somewhere in the array
- Store each value as a KEY in the HashMap, its index as the VALUE
- Each iteration: check if the complement (`target - nums[i]`) already exists in the map
- If yes → found both indices — return immediately
- If no → store current value and index, move on

One loop. Done.

---

## Solution

```java
public int[] returnTwoSumIndices(int[] array, int target) {

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
        int complement = target - array[i];

        if (hashMap.containsKey(complement)) {
            return new int[]{hashMap.get(complement), i};
        } else {
            hashMap.put(array[i], i);
        }
    }

    return new int[]{}; // never reached — problem guarantees exactly one solution
}
```

---

## Inline array return syntax

```java
return new int[]{value1, value2};  // ✅ correct — no size when providing values
return new int[2]{value1, value2}; // ❌ wrong — cannot specify size AND values together
```

---

## Big O

Time:  O(n) — single loop through the array
Space: O(n) — HashMap stores at most n elements

---

## Interview tip

When returning the fallback always mention:
"Since the problem guarantees exactly one solution, this line is never reached —
but Java requires a return statement outside the loop."
