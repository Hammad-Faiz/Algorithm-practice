# final Keyword (3 Uses)

## 1. final variable or field — cannot be reassigned

```java
// Primitives — value is completely locked, even += is reassignment
final int x = 5;
x = 3;    // compile error
x += 1;   // compile error (same as x = x + 1, which is reassignment)

// Objects — reference is locked, but contents can still change
final List<String> names = new ArrayList<>();
names = new ArrayList<>();  // compile error — can't reassign the reference
names.add("Alice");         // fine — contents can still change
```

Common use: constructor injection in Spring
```java
private final EmployeeService employeeService; // can never be reassigned after constructor
```

---

## 2. final class — cannot be extended

```java
public final class String { ... } // you cannot do: class MyString extends String
```

Used to protect immutability. If a class is final, nobody can override its methods
by extending it.

---

## 3. final method — cannot be overridden

```java
public final void doSomething() { ... } // subclasses cannot override this
```

---

## Key distinction — final on objects

final locks the REFERENCE, not the contents:
```java
final List<String> names = new ArrayList<>();
names.add("Alice");   // fine — contents can change
names = new List<>(); // compile error — reference cannot change
```
