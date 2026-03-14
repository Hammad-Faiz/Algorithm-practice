# static Keyword

## What it means

Non-static (default): belongs to an INSTANCE — each object gets its own copy
Static: belongs to the CLASS itself — one copy shared by everyone

---

## Example 1 — static variable

```java
public class Employee {
    public static int employeeCount = 0; // belongs to the CLASS
    public String name;                   // belongs to each INSTANCE

    public Employee(String name) {
        this.name = name;
        employeeCount++; // every new employee increments the shared counter
    }
}

Employee e1 = new Employee("Alice");
Employee e2 = new Employee("Bob");

System.out.println(Employee.employeeCount); // 2 — shared across all instances
System.out.println(e1.employeeCount);       // also 2 — same variable
```

---

## Example 2 — static method

```java
public class MathHelper {
    public static int add(int a, int b) {
        return a + b;
    }
}

MathHelper.add(3, 5); // called directly on the class — no object needed
```

Why is main() static?
public static void main(String[] args)
Java needs to call main() before any objects exist — so it must belong to the class.

---

## The one rule

Static methods CANNOT access instance variables or instance methods directly.
There is no specific object to reference.

```java
public class Employee {
    private String name; // instance variable

    public static void printName() {
        System.out.println(name); // COMPILE ERROR — which employee's name?
    }
}
```

---

## When to use static

Static variable: shared state across all instances (counters, constants like Math.PI)
Static method: utility/helper methods that don't need object state (Math.abs(), Collections.sort())

## When NOT to use static

Avoid overusing static — static methods cannot be mocked with Mockito,
which makes your code harder to unit test. This is a senior-level observation.
