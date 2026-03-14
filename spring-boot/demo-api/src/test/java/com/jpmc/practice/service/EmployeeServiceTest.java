package com.jpmc.practice.service;

import com.jpmc.practice.exception.EmployeeNotFoundException;
import com.jpmc.practice.model.Employee;
import com.jpmc.practice.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    // ^ this is a FAKE repository — no real DB

    @InjectMocks
    private EmployeeService employeeService;
    // ^ this is the REAL service, but with the fake repo injected

    @Test
    void testGetAllEmployees() {
        // SETUP: tell the mock what to return when findAll() is called
        Employee e1 = new Employee(1, "Alice", "Engineering", 90000);
        Employee e2 = new Employee(2, "Bob", "Finance", 80000);
        when(employeeRepository.findAll()).thenReturn(List.of(e1, e2));

        // TODO: call employeeService.getEmployees() and store the result

        List<Employee> list = employeeService.getEmployees();

        // TODO: assert that the result size is 2

        assertThat(list).hasSize(2);

        // TODO: assert that the first employee's name is "Alice"
        Employee isItAlice = list.getFirst();
        assertThat(isItAlice.getName()).isEqualTo("Alice");
    }

    @Test
    void testGetEmployeeById_Found() {
        // SETUP: mock findById to return an employee wrapped in Optional
        Employee emp = new Employee(1, "Carol", "HR", 70000);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(emp));

        // TODO: call employeeService.getEmployeeByID(1) and store the result
        Employee employee1 = employeeService.getEmployeeByID(1);

        // TODO: assert the name equals "Carol"
        assertThat(employee1.getName()).isEqualTo("Carol");
    }

    @Test
    void testGetEmployeeById_NotFound() {
        // SETUP: mock findById to return empty (simulating "not in DB")
        when(employeeRepository.findById(99)).thenReturn(Optional.empty());

        // TODO: use assertThrows to verify that calling getEmployeeByID(99)
        //       throws an EmployeeNotFoundException
        //
        // hint: assertThrows(ExceptionClass.class, () -> { ...your call here... });

        assertThrows(EmployeeNotFoundException.class, () -> {employeeService.getEmployeeByID(99);});
    }


    @Test
    void testDeleteEmployee_CallsDeleteById() {
        // SETUP: make existsById return true (so the service doesn't throw)
        when(employeeRepository.existsById(1)).thenReturn(true);

        // TODO: call employeeService.deleteEmployee(1)
        employeeService.deleteEmployee(1);

        // TODO: use verify() to confirm that employeeRepository.deleteById(1) was called
        verify(employeeRepository).deleteById(1);
    }


}
