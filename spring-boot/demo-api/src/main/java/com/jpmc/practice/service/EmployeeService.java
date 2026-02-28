package com.jpmc.practice.service;
import com.jpmc.practice.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<Employee>(List.of(
            new Employee(1, "Alice Johnson", "Engineering", 95000),
            new Employee(2, "Bob Smith", "Product", 88000),
            new Employee(3, "Sara Lee", "Engineering", 102000)
    ));


    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeByID(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employees.stream()
                .filter(e -> e.getId() == employee.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Save operation not successfull"));
    }


    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }
}