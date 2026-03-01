package com.jpmc.practice.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.jpmc.practice.model.Employee;
import com.jpmc.practice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

// @RestController tells Spring: "this class handles HTTP requests and returns data"
// @RequestMapping sets the base URL for all endpoints in this class
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /employees — return all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    // GET /employees/{id} — return one employee by id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    // POST /employees — add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // DELETE /employees/{id} — remove an employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee " + id + " deleted";
    }
}
