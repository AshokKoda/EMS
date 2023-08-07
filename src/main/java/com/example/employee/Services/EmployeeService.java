package com.example.employee.Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.Entities.Employee;
import com.example.employee.Repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    //SAVE EMPLOYEE
    public void save(Employee employee) throws ParseException {
        String strDate = new SimpleDateFormat("yyyy-MM-dd",   Locale.getDefault()).format(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date doj = df.parse(strDate);
        employee.setDoj(doj);
        employeeRepository.save(employee);
    }

}
