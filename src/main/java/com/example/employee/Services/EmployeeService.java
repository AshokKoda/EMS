package com.example.employee.Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.Entities.Employee;
import com.example.employee.Repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    // SAVE EMPLOYEE
    public Employee save(Employee employee) throws ParseException {
        String fName = employee.getFirstName();
        String lName = employee.getLastName();
        String email = employee.getEmail();
        String phoneNo = employee.getPhoneNo();
        Double salary = employee.getSalary();

        if (fName.isEmpty() || lName.isEmpty() || email.isEmpty() || phoneNo.isEmpty() || salary <= 0) {
            log.info("Some mandatory fields are missing!.");
        } else {
            String strDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date doj = df.parse(strDate);
            employee.setDoj(doj);
            employeeRepository.save(employee);
            log.info("Employee successfully added!.");
        }
        return employee;
    }

    // GET EMPLOYEES
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
