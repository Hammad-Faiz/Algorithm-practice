# First Non-Repeating Character

## Problem
Given a string, find the first non-repeating character and return its index.
If none exists return -1.

```
Input:  "leetcode"    → Output: 0  ('l' appears once, at index 0)
Input:  "aabb"        → Output: -1 (every character repeats)
Input:  "loveleetcode" → Output: 2 ('v' appears once, at index 2)
```

---

## Approach

Key insight: repeating characters don't have to be adjacent.
Two nested loops comparing adjacent characters won't work.

Use a HashMap to count frequency of each character.
Then iterate the string again in order — first character with frequency 1 is the answer.

Why iterate the string again instead of the HashMap?
Iterating the string preserves ORDER. The index i directly gives you the answer.
Iterating the HashMap has no guaranteed order.

Two loops total — NOT three.

---

## Solution

```java
public int uniqueCharacter(String s) {

    // Loop 1: build frequency map
    HashMap<Character, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (hashMap.containsKey(c)) {
            int value = hashMap.get(c);
            hashMap.put(c, value + 1);
        } else {
            hashMap.put(c, 1); // first time seeing this character
        }
    }

    // Loop 2: find first character with frequency 1
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (hashMap.get(c) == 1) {
            return i;
        }
    }

    return -1; // nothing found
}
```

---

## Cleaner version using getOrDefault

```java
hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
```

Replaces the entire if/else block in loop 1. Same logic, one line.

---

## Big O

Time:  O(n) — two separate loops, both O(n), not nested
Space: O(n) — HashMap stores at most n unique characters in worst case

---

## Common bugs to avoid

- `HashMap<Integer, Integer>` — keys are CHARACTERS not integers → `HashMap<Character, Integer>`
- Missing `new` keyword → `new HashMap<>()`
- Calling `hashMap.get(c)` BEFORE checking `containsKey` → NullPointerException
  (trying to unbox null Integer into primitive int)
- `containKey` → `containsKey` (don't forget the s)
