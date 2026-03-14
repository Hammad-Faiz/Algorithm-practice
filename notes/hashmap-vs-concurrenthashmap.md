# HashMap vs ConcurrentHashMap

## The Difference

HashMap — NOT thread safe
- No locking at all
- Two threads accessing the same map can cause race conditions
- Most common bug: ConcurrentModificationException
  (one thread iterates while another modifies → crash)

ConcurrentHashMap — thread safe
- Locks per BUCKET (not the entire map)
- Thread A can write to key "Alice" while Thread B reads key "Bob" simultaneously
- Much faster than Hashtable

Hashtable — thread safe but slow (old, avoid it)
- Locks the ENTIRE map for every single read and write
- One thread at a time for everything

---

## Quick reference

| | Thread Safe | How |
|--|--|--|
| HashMap | NO | No locking |
| Hashtable | YES | Locks entire map (slow) |
| ConcurrentHashMap | YES | Locks per bucket (fast) |

---

## When to use each

Use HashMap when only one thread accesses the map.
Use ConcurrentHashMap when multiple threads read/write the same map.
Never use Hashtable in new code.

---

## Race condition example with HashMap

```java
// Thread A and Thread B both read balance = 100
// Thread A: balance = 100 + 50 = 150, writes 150
// Thread B: balance = 100 + 30 = 130, writes 130 (overwrites Thread A's result)
// Final balance: 130 — Thread A's update is lost
```
