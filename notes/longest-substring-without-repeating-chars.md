# Longest Substring Without Repeating Characters

**Difficulty:** Medium
**LeetCode:** Problem #3
**Pattern:** Sliding Window + HashMap
**Result:** Accepted — 988/988 test cases, 5ms (beats 86.82%)

---

## Problem
Given a string `s`, find the length of the longest substring without repeating characters.

**Examples:**
- `"abcabcbb"` → `3` ("abc")
- `"bbbbb"` → `1` ("b")
- `"pwwkew"` → `3` ("wke")
- `"dvdf"` → `3` ("vdf")
- `"abba"` → `2` ("ab" or "ba")

---

## Approach: Sliding Window with HashMap

Store each character's **last seen 1-based position** in a HashMap.
Use a `resetValue` to track the left boundary of the current window.

**Key insight:**
- If a character was seen **inside** the current window → it's a real duplicate → shrink window
- If a character was seen **before** the current window → treat it as new → extend window

**How to check:** `hashMap.get(c) > resetValue`
- If true → duplicate is inside window → recalculate length from old occurrence
- If false → outside window → just increment countLength

**When duplicate found:**
- `countLength = l - hashMap.get(c)` (distance from old occurrence to current)
- `resetValue = hashMap.get(c)` (move window start to old occurrence position)
- Update hashMap with new position

---

## Solution

```java
public int findLongestSubstring(String s) {
    if (s.length() == 0) { return 0; }

    HashMap<Character, Integer> hashMap = new HashMap<>();

    int highestLength = 1;
    int countLength = 0;
    int resetValue = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        int l = i + 1;  // 1-based position

        if (hashMap.containsKey(c) && hashMap.get(c) > resetValue) {
            countLength = l - hashMap.get(c);
            resetValue = hashMap.get(c);
            hashMap.put(c, l);
        } else {
            hashMap.put(c, l);
            countLength += 1;
        }

        if (countLength > highestLength) { highestLength = countLength; }
    }

    return highestLength;
}
```

---

## Complexity
| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — HashMap |

---

## Mistakes Made During Practice
- Initially tried clearing the HashSet on duplicate → broke "dvdf" case
- `hashMap.containsKey(c) > resetValue` — containsKey returns boolean, not int → fix: `hashMap.get(c)`
- `resetValue = l` (current position) → too aggressive, caused missed duplicates → fix: `resetValue = hashMap.get(c)` (old position)

---

## Trace: "abba"
| i | c | l | containsKey? | get(c) > reset? | countLength | resetValue | highestLength |
|---|---|---|---|---|---|---|---|
| 0 | a | 1 | No | — | 1 | 0 | 1 |
| 1 | b | 2 | No | — | 2 | 0 | 2 |
| 2 | b | 3 | Yes | 2 > 0 ✓ | 1 | 2 | 2 |
| 3 | a | 4 | Yes | 1 > 2 ✗ | 2 | 2 | 2 |

**Result: 2** ✓
