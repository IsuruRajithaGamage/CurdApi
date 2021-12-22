package com.example.curdapi.employeeService;

import com.example.curdapi.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpServices {
    boolean  saveEmployee(Employee employee);
    List<Employee> showEmployee();
    List<Employee> showIntern();
    //ResponseEntity<Employee> updateEmployee(Employee employee, Employee employeeDetails);


}
