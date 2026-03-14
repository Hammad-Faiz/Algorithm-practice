# Spring Boot Annotations

## @Component vs @Service vs @Repository vs @RestController

All register a Spring bean in the IoC container on startup.
All are specializations of @Component.
Technically interchangeable — but always use the right one.

| Annotation | Layer | Extra behavior |
|-----------|-------|----------------|
| @Component | Generic | None — use when nothing else fits |
| @Service | Business logic | None technical — signals intent |
| @Repository | Database/persistence | Exception translation: wraps JPA/Hibernate exceptions into Spring's DataAccessException |
| @RestController | HTTP layer | Handles requests + adds @ResponseBody automatically |

Key point for @Repository:
The JPA methods (findById, save, deleteById) come from extending JpaRepository<T, ID>
NOT from the @Repository annotation. What @Repository adds is exception translation.

---

## @Transactional

Wraps a method in a database transaction:
- All operations succeed → COMMIT (changes saved to DB)
- Anything throws an exception → ROLLBACK (all changes undone)

Classic bank transfer example:
```java
@Transactional
public void transferMoney(int fromId, int toId, double amount) {
    Account from = accountRepository.findById(fromId);
    Account to = accountRepository.findById(toId);

    from.debit(amount);
    accountRepository.save(from);  // step 1

    to.credit(amount);
    accountRepository.save(to);    // if this fails, step 1 is rolled back
}
```

Without @Transactional: step 1 saves, step 2 crashes → money disappears forever.
With @Transactional: step 2 crashes → entire transaction rolls back → money stays safe.

Where to put it: SERVICE layer methods, not controller or repository.

When to use it:
- Multiple DB writes that must all succeed together
- Updating multiple tables atomically
- Any operation where partial writes would cause data corruption

---

## @Autowired vs Constructor Injection

@Autowired (field injection):
```java
@Autowired
private EmployeeService employeeService; // Spring injects this
```

Constructor injection (preferred):
```java
private final EmployeeService employeeService;

public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
}
```

Why constructor injection is better:
- final field — dependency can never be swapped out after creation
- Easier to test — you can pass a mock directly in the constructor
- Makes dependencies explicit and visible
- Spring team recommends it

---

## Spring Boot Layered Architecture

Request → Controller → Service → Repository → Database

Controller: receives HTTP request, calls service, returns response
Service: contains business logic, calls repository
Repository: talks to the database (JPA operations)
Model/Entity: represents the data (maps to a DB table)

Kafka-based apps skip the Controller:
Kafka Consumer → Execute method → Service → Repository → Database
