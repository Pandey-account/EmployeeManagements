
package com.emp.management.repository;

import com.emp.management.models.Employee;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepo extends MongoRepository<Employee, UUID>{
    
    Page<Employee> findAll(Pageable pageable);
}
