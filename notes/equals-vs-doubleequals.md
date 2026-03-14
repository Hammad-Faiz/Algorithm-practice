# == vs .equals()

## The Rule
- Primitives (int, double, boolean) → use ==
- Objects (String, Employee, anything with new) → use .equals()

---

## What each compares

== compares MEMORY ADDRESS — are these the exact same object in memory?
.equals() compares CONTENT — do these objects have the same value?

---

## String example

```java
String a = "hello";
String b = "hello";
String c = new String("hello");

a == b        // true  — Java reuses same object from String pool
a == c        // false — new String() forces a brand new object in memory
a.equals(c)  // true  — same content, doesn't matter where it lives
```

## Why this causes production bugs

```java
String status = getStatusFromDatabase(); // returns "active"

if (status == "active") {     // might be false even if value is "active"
    // this might never run
}

if (status.equals("active")) { // always checks content correctly
    // correct
}
```

The == version works sometimes locally and fails silently in production.
That's the worst kind of bug — no crash, just wrong behavior.
