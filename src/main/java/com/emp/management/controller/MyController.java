
package com.emp.management.controller;

import com.emp.management.exception.EmployeeNotFoundException;
import com.emp.management.models.Employee;
import com.emp.management.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Employee")
public class MyController {
    
    @Autowired
    private EmployeeService EmployeeService;
    
    
    @PostMapping("/")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
       return EmployeeService.addEmployee(emp);
    }
    
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
       return EmployeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable UUID id){
        return EmployeeService.getEmployeeById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable UUID id,@RequestBody Employee upEmployee){
          EmployeeService.updateEmployeeById(id, upEmployee);
        return ResponseEntity.ok("Employee with id "+ id + " updated successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable UUID id){
        EmployeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with id " + id + "deleted successfully");
    }
    @GetMapping("/{id}/manager/{level}")
    public ResponseEntity<Employee>getNthLevelManager(@PathVariable UUID id,@PathVariable int level){
        Employee manager = EmployeeService.getNthLevelManager(id, level);
        
        if(manager != null){
            return ResponseEntity.ok(manager);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
