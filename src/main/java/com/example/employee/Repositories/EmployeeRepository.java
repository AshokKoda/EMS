package com.example.employee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
