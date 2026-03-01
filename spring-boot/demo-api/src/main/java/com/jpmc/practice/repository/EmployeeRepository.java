package com.jpmc.practice.repository;
import com.jpmc.practice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // that's literally it — Spring generates all the methods for you
}

