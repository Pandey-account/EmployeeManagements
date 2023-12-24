
package com.emp.management.models;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
   
    @Id
    private UUID employeeId;
    private String employeeName;
    private String phoneNumber;
    private String email;
    private UUID reportsTo;
    private String profileImage;  
}
