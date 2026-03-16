# @RestControllerAdvice

## What it does
Intercepts exceptions thrown from ANY controller and handles them globally.
Spring sits between your controller and the client — catches exceptions before
they ever reach the user and routes them to the right handler method.

---

## Without it — messy
```java
@GetMapping("/{id}")
public Employee getEmployee(@PathVariable int id) {
    try {
        return employeeService.getEmployeeByID(id);
    } catch (EmployeeNotFoundException e) {
        // handle in every single endpoint — messy
    }
}
```

## With it — clean
```java
@GetMapping("/{id}")
public Employee getEmployee(@PathVariable int id) {
    return employeeService.getEmployeeByID(id); // exception handled globally
}
```

---

## How it works — step by step

```
Request → Controller → Service → throws EmployeeNotFoundException
                                            ↓
                              Spring intercepts the exception
                                            ↓
                         @RestControllerAdvice class is found
                                            ↓
                    matching @ExceptionHandler method is called
                                            ↓
                         JSON error response returned to client
```

---

## Full example

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // safety net — catches anything not explicitly handled above
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something went wrong");
    }
}
```

Spring picks the MOST SPECIFIC handler available.
EmployeeNotFoundException thrown → picks EmployeeNotFoundException handler, not Exception handler.

---

## EmployeeNotFoundException — defined separately

```java
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message); // passes message up to RuntimeException
    }
}
```

Thrown in the service:
```java
throw new EmployeeNotFoundException("Employee with id " + id + " not found");
```

When handler calls ex.getMessage() — it gets whatever message was passed when thrown.
Not hardcoded in the handler — comes from where the exception was thrown.

---

## ResponseEntity

Gives you full control over the HTTP response:
- Status code (404, 400, 500 etc.)
- Headers
- Body (the actual content)

```java
ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found")
// → HTTP 404 with body "Employee not found"

ResponseEntity.ok(employee)
// → HTTP 200 with employee as JSON body
```

ResponseEntity<String>   → body is a String message
ResponseEntity<Employee> → body is an Employee object converted to JSON

---

## @RestControllerAdvice vs @ControllerAdvice

@ControllerAdvice    → for traditional MVC apps returning views (HTML pages)
@RestControllerAdvice → for REST APIs — automatically adds @ResponseBody,
                        so return values are serialized to JSON automatically
