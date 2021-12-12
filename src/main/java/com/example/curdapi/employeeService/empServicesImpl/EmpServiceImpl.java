package com.example.curdapi.employeeService.empServicesImpl;

import com.example.curdapi.employeeService.EmpServices;
import com.example.curdapi.entity.Employee;
import com.example.curdapi.repository.EmpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpServices {

    @Autowired
    EmpRepository empRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean saveEmployee(Employee employee) {
        empRepository.save(employee);
        return false;
    }

    @Override
    public List<Employee> showEmployee() {
        return empRepository.findAll();

    }

//    @Override
//    public ResponseEntity<Employee> updateEmployee(Employee employee, Employee employeeDetails) {
//        employee.setName(employeeDetails.getName());
//        employee.setAge(employeeDetails.getAge());
//        employee.setEmail(employeeDetails.getEmail());
//        employee.setJob(employeeDetails.getJob());
//        Employee updatedEmployee = empRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }
}
