package com.example.curdapi.employeeController;

import com.example.curdapi.employeeService.EmpServices;
import com.example.curdapi.entity.Employee;
import com.example.curdapi.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmpRepository empRepository;

    @Autowired
    EmpServices empServices;

    @PostMapping("/save")
    public boolean saveEmployee(@RequestBody Employee employee){
    empServices.saveEmployee(employee);
    return true;
    }

    @GetMapping("/list")
    public List<Employee> showEmployee(){
     return empServices.showEmployee();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Integer id){
        Employee emp = empRepository.findById(id).orElseThrow(()-> new RuntimeException("not employee"+id));
        return ResponseEntity.ok(emp);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails ){
       Employee employee = empRepository.findById(id).orElseThrow(()-> new RuntimeException("No Employee" +id));

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setJob(employeeDetails.getJob());
        employee.setAge(employeeDetails.getAge());

        Employee updatedEmployee = empRepository.save(employee);
     return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Integer id){
    Employee employee = empRepository.findById(id).orElseThrow(()-> new RuntimeException("cant find employee"+id));
    empRepository.delete(employee);
    Map<String, Boolean> response = new HashMap<>();
    response.put("Deleted",Boolean.TRUE);
    return ResponseEntity.ok(response);

    }

}
