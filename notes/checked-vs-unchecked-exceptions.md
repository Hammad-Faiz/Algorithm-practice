# Checked vs Unchecked Exceptions

## The Hierarchy

```
Throwable
├── Error (OutOfMemoryError — never catch these)
└── Exception
    ├── Checked:   IOException, SQLException, FileNotFoundException
    └── RuntimeException (Unchecked): NullPointerException, EmployeeNotFoundException
```

---

## The Difference

Checked exceptions:
- Extend Exception (but NOT RuntimeException)
- Compiler FORCES you to handle them — try/catch or declare throws in method signature
- Represent recoverable errors the caller should expect

Unchecked exceptions:
- Extend RuntimeException
- Compiler does NOT check — you can let them bubble up without handling
- Represent programming errors or conditions you don't expect to recover from

---

## Examples

```java
// Checked — compiler won't let you ignore this
FileReader file = new FileReader("data.txt"); // must wrap in try/catch

// Unchecked — compiles fine, crashes at runtime
String s = null;
s.length(); // NullPointerException
```

---

## Connection to our code

EmployeeNotFoundException extends RuntimeException — it's unchecked.
That's why controllers don't need try/catch around every service call.
Spring handles it automatically via @RestControllerAdvice.

If it extended Exception instead, every caller would be forced to catch it.
That's why Spring exceptions are almost always unchecked.
