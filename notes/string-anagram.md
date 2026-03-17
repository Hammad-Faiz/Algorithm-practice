# String Anagram

## Problem
Given two strings s and t, return true if t is an anagram of s.
An anagram uses all original letters exactly once, just rearranged.

```
s = "anagram", t = "nagaram" → true
s = "rat",     t = "car"     → false
s = "hello",   t = "world"   → false
```

---

## Approach — HashMap frequency count

1. If lengths don't match → return false immediately
2. Loop through s → build frequency map (char → count)
3. Loop through t → decrement count for each char found
   - If char not in map → return false
   - If count > 1 → decrement
   - If count == 1 → remove from map
4. Return true

---

## Solution

```java
public boolean stringAnagram(String s, String t) {

    if (s.length() != t.length()) return false;

    HashMap<Character, Integer> hashMap = new HashMap<>();

    // build frequency map from s
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
    }

    // verify against t
    for (int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        if (hashMap.containsKey(c)) {
            int getValue = hashMap.get(c);
            if (getValue > 1) {
                hashMap.put(c, getValue - 1);
            } else {
                hashMap.remove(c);
            }
        } else {
            return false;
        }
    }

    return true;
}
```

---

## Key points

- Length check first — if lengths differ they can never be anagrams
- getOrDefault(c, 0) replaces the if/else containsKey check in loop 1
- hashMap.remove(key) removes the entry entirely ✅
- Duplicate characters handled by decrementing count instead of removing

---

## Big O

Time:  O(n) — two separate loops
Space: O(n) — HashMap stores at most n unique characters
