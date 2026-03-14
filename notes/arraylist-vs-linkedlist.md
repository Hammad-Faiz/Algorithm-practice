# ArrayList vs LinkedList

## What they are

ArrayList:
- Backed by a regular array under the hood
- Elements stored CONTIGUOUSLY in memory (cache friendly)
- When full, creates a new bigger array and copies everything over

LinkedList:
- Each element is a NODE that holds: value + pointer to next + pointer to previous
- Elements scattered across memory (cache unfriendly)
- No resizing needed — just update pointers

---

## Big O comparison

| Operation | ArrayList | LinkedList |
|-----------|-----------|------------|
| Get by index | O(1) — jumps directly | O(n) — walks the chain from start |
| Insert at middle | O(n) — shifts all elements after | O(1) — just updates two pointers |
| Add to end | O(1) | O(1) |

---

## The interview question: 1 million items, frequent middle insertions — which do you use?

Theoretical answer: LinkedList
- ArrayList middle insert = O(n) — shifts 500,000 elements
- LinkedList middle insert = O(1) — just updates pointers

But in practice: ArrayList often still wins because:
- CPU cache loves contiguous memory (ArrayList)
- LinkedList nodes are scattered in memory → cache misses on every traversal
- Always benchmark before assuming

Full answer: "Theoretically LinkedList for O(1) insertion, but in practice
ArrayList's memory layout can outperform it due to cache efficiency.
I'd benchmark before assuming."

---

## When to actually use each

Use ArrayList: almost always — default choice, random access, iteration
Use LinkedList: implementing a queue or deque where you only add/remove from ends
