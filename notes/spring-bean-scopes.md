# Spring Bean Scopes

## What is a bean scope?

When Spring creates a bean (@Service, @Repository, @Component etc.)
the scope controls HOW MANY instances get created and HOW LONG they live.

---

## Singleton (default)

Spring creates the bean ONCE and reuses the same instance everywhere.
Every class that injects it gets the exact same object.

```java
@Service
public class EmployeeService { ... } // one instance for the entire app
```

Good for: stateless services (no instance variables that change per user)
Bad for: anything that holds user-specific state

---

## Prototype

Spring creates a brand new instance every time someone requests the bean.

```java
@Scope("prototype")
@Component
public class ReportGenerator { ... } // new instance every injection
```

Good for: stateful beans where each caller needs their own copy
Rarely used in practice — 99% of Spring apps use singleton for everything

---

## Why singleton is dangerous with user-specific state

```java
@Service // singleton — one instance shared by ALL users
public class UserService {
    private String currentUser; // dangerous state in a singleton

    public void setUser(String user) { this.currentUser = user; }
    public String getUser() { return currentUser; }
}

// Thread A sets currentUser = "Alice"
// Thread B sets currentUser = "Bob"
// Thread A calls getUser() → gets "Bob" — data corruption
```

One shared instance = one shared variable.
Two users can overwrite each other's data.
Singleton beans should NEVER hold user-specific state.

---

## Rule of thumb

Bean holds no state (most services) → singleton (default)
Bean holds state that differs per user/request → prototype
