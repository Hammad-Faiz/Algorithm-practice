# hashCode() and equals()

## The Rule
Always override BOTH together.
If two objects are equal → they MUST have the same hashCode.

---

## How HashMap uses both internally

Step 1: calls hashCode() on the key → decides which BUCKET to store it in
Step 2: calls equals() on keys in that bucket → checks if the key already exists

Mental model:
- hashCode() = which DRAWER to open in a filing cabinet
- equals()   = which FILE to grab inside that drawer

---

## Default behavior (no overrides)

- equals()   → compares MEMORY ADDRESS — two different objects are never equal even with identical content
- hashCode() → based on MEMORY ADDRESS — two different objects always produce different hash codes

Why memory address? Java doesn't know which fields matter to you.
Two objects created at different times live at different memory addresses.
You must override explicitly to change this.

---

## What breaks when you only override one

Override hashCode() but NOT equals():
- Same id → same bucket (hashCode works)
- But equals() still compares memory addresses → returns false
- HashMap thinks they are different keys → stores BOTH in the same bucket
- Result: duplicate entries for the same id

Override equals() but NOT hashCode():
- equals() correctly returns true for same id
- But hashCode() uses memory address → different bucket for each object
- HashMap looks in the wrong bucket → returns null
- Result: can never find what you stored

Override neither:
- Wrong bucket + wrong equality check → completely broken

Override both:
- Same id → same bucket → equals() returns true → works correctly

---

## The fix — always goes inside the class (e.g. Employee.java)

```java
@Override
public boolean equals(Object o) {
    Employee other = (Employee) o; // cast Object to Employee so you can access .id
    return this.id == other.id;    // this = object you call equals ON, other = passed in
}

@Override
public int hashCode() {
    return Integer.hashCode(this.id); // same id always produces the same hash number
}
```

---

## Edge cases

Same id, different other fields:
```java
Employee e1 = new Employee(1, "Alice", "Engineering", 90000);
Employee e2 = new Employee(1, "Bob", "Finance", 50000);

hashMap.put(e1, "data");
hashMap.get(e2); // returns "data" — equals() only checks id, other fields ignored
```
This is intentional — YOU defined equality as "same id = same employee"

Identical content, no overrides:
```java
Employee e1 = new Employee(1, "Alice", "Engineering", 90000); // memory address 0x1234
Employee e2 = new Employee(1, "Alice", "Engineering", 90000); // memory address 0x5678

e1.equals(e2)  // false — different memory addresses
e1.hashCode()  // different from e2 — different memory addresses
hashMap.get(e2) // null — wrong bucket, wrong equality check
```
