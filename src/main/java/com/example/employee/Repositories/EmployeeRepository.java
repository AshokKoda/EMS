package com.example.employee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}