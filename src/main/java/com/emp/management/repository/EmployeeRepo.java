
package com.emp.management.repository;

import com.emp.management.models.Employee;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepo extends MongoRepository<Employee, UUID>{
    
}
