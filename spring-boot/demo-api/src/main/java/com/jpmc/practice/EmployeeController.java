package com.jpmc.practice;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

// @RestController tells Spring: "this class handles HTTP requests and returns data"
// @RequestMapping sets the base URL for all endpoints in this class
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // In-memory list — acting as our "database" for now
    // We'll replace this with a real database next session
    private List<Employee> employees = new ArrayList<>(List.of(
        new Employee(1, "Alice Johnson", "Engineering", 95000),
        new Employee(2, "Bob Smith", "Product", 88000),
        new Employee(3, "Sara Lee", "Engineering", 102000)
    ));

    // GET /employees — return all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // GET /employees/{id} — return one employee by id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST /employees — add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    // DELETE /employees/{id} — remove an employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employees.removeIf(e -> e.getId() == id);
        return "Employee " + id + " deleted";
    }
}
