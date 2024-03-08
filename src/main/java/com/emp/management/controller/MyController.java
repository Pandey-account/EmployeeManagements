
package com.emp.management.controller;

import com.emp.management.exception.EmployeeNotFoundException;
import com.emp.management.models.Employee;
import com.emp.management.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Employee")
public class MyController {
    
    @Autowired
    private EmployeeService EmployeeService;
     @Operation(
    tags = "Add Employee",
            description = "Add functionality to the Employee Management API to create and manage employee records.",
            responses = {
                @ApiResponse(
                description = "Created",
                        responseCode = "201"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    
    @PostMapping("/")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
       return EmployeeService.addEmployee(emp);
    }
    
//    @GetMapping("/all")
//    public List<Employee> getAllEmployee(){
//       return EmployeeService.getAllEmployee();
//    }
    
     @Operation(
    tags = "Get Employee by Id",
            description = "Employee Management API includes a \"Get by ID\" operation to retrieve a specific employee's details.",
            responses = {
                @ApiResponse(
                description = "ok",
                        responseCode = "200"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable UUID id){
        return EmployeeService.getEmployeeById(id);
    }
    
    
     @Operation(
    tags = "Update Employee by Id",
            description = "Update an employee's information by their unique identifier (ID) in the Employee Management API.",
            responses = {
                @ApiResponse(
                description = "ok",
                        responseCode = "200"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable UUID id,@RequestBody Employee upEmployee){
          EmployeeService.updateEmployeeById(id, upEmployee);
        return ResponseEntity.ok("Employee with id "+ id + " updated successfully");
    }
    
      @Operation(
    tags = "Delete Employee by Id",
            description = "Implementing the deletion operation for an Employee Management API involves deleting an employee "
                    + "record by their unique identifier (ID) in the database.",
            responses = {
                @ApiResponse(
                description = "ok",
                        responseCode = "200"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable UUID id){
        EmployeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with id " + id + "deleted successfully");
    }
    @Operation(
    tags = "Get Nth Level Manager",
            description = "Retrieve the nth level manager hierarchy for a given employee in the Employee Management API.",
            responses = {
                @ApiResponse(
                description = "ok",
                        responseCode = "200"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @GetMapping("/{id}/manager/{level}")
    public ResponseEntity<Employee>getNthLevelManager(@PathVariable UUID id,@PathVariable int level){
        Employee manager = EmployeeService.getNthLevelManager(id, level);
        
        if(manager != null){
            return ResponseEntity.ok(manager);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @Operation(
    tags = "Get all Employee",
            description = "Retrieve all employee records in the Employee Management API.",
            responses = {
                @ApiResponse(
                description = "ok",
                        responseCode = "200"),
                @ApiResponse(
                description = "Bad Request",
                        responseCode = "400")
            })
    @GetMapping("/all")
    public Page<Employee>getAllEmployee(@RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "employeeName") String sortBy){
        
        return this.EmployeeService.getAllEmployees(pageNumber, pageSize, sortBy);
    }
}
