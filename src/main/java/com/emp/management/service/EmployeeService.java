
package com.emp.management.service;

import com.emp.management.exception.EmployeeNotFoundException;
import com.emp.management.exception.FailedDataException;
import com.emp.management.models.Employee;
import com.emp.management.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private  JavaMailSender javaMailSender;
   
    public ResponseEntity<String> addEmployee(Employee emp) throws EmployeeNotFoundException {

        emp.setEmployeeId(UUID.randomUUID());

        try {
            employeeRepo.save(emp);
        } catch (Exception e) {
            new FailedDataException("Unable to save Employee Data.");
        }

        Employee reportsTo = getEmployeeById(emp.getReportsTo())
                                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found."));

        sendNewEmployeeEmail(reportsTo.getEmail(), emp.getEmployeeName(),emp.getPhoneNumber(),emp.getEmail());

        return ResponseEntity.ok("Employee added successfully with id:"+emp.getEmployeeId().toString());
    }

     public List<Employee>getAllEmployee(){
         
         return employeeRepo.findAll();
     }
     public Optional<Employee> getEmployeeById(UUID id){
         return employeeRepo.findById(id);
     }
     
     public void updateEmployeeById(UUID id,Employee upEmployee){
         
         Employee exEmployee = employeeRepo.findById(id)
                 .orElseThrow( () ->
                         new EmployeeNotFoundException("Employee Not found with given Id:"+id.toString()));

         exEmployee.setEmployeeName(upEmployee.getEmployeeName());
         exEmployee.setPhoneNumber(upEmployee.getPhoneNumber());
         exEmployee.setEmail(upEmployee.getEmail());
         exEmployee.setReportsTo(upEmployee.getReportsTo());
         exEmployee.setProfileImage(upEmployee.getProfileImage());

         employeeRepo.save(exEmployee);
     }
     
     public void deleteEmployeeById(UUID id){
         employeeRepo.deleteById(id);
     }
     
     public Employee getNthLevelManager(UUID id, int level){
    
    Employee emplyoee = employeeRepo.findById(id).orElse(null);
    
    if(emplyoee != null && level > 0){
        return findNthLevelManager(emplyoee,level);
    }
    return null;
  }
     
     private Employee findNthLevelManager(Employee employee,int level){
         UUID reportsToId = employee.getReportsTo();
         if(reportsToId == null || level == 1){
             return employeeRepo.findById(reportsToId).orElse(null);
         }else{
             return findNthLevelManager(employeeRepo.findById(reportsToId).orElse(null),level-1);
         }
     }
     public void sendNewEmployeeEmail(String managerEmail,String employeeName,String phoneNumber,String email){

        SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom(email);
         message.setTo(managerEmail);
         message.setSubject("New Employee Added");
         message.setText("Hello " +employeeName + " will now work under you. Mobile number is " +phoneNumber +
                 " and email is " + email +". Click[here](mailTo:" + managerEmail +" ) to open your email client.");

         javaMailSender.send(message);
     }
     
     public Page<Employee> getAllEmployees(int pageNumber,int pageSize,String sortBy){
         
         Pageable pageable =  PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
         return this.employeeRepo.findAll(pageable);
     }
}
