package com.jpmc.practice.service;
import com.jpmc.practice.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jpmc.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.jpmc.practice.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public void deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    public String updateEmployee(int id, Employee employee) {
        Employee findEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        findEmployee.setName(employee.getName());
        findEmployee.setDepartment(employee.getDepartment());
        findEmployee.setSalary(employee.getSalary());
        employeeRepository.save(findEmployee);
        String returnMessage  = "The employee with " + id + " was updated";
        return returnMessage;
    }


}