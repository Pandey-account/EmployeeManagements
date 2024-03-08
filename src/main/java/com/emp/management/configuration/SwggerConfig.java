package com.emp.management.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title="Employee Management Backend API",
                description = "An Employee Management System typically involves "
                        + "CRUD operations (Create, Read, Update, Delete) to manage "
                        + "employee data effectively. Here's a brief overview of each operation:  ",
                summary ="To implement the functionality where adding a "
                        + "new employee reports to an existing employee,"
                        + " you'll need to establish relationships between employees in your system. "
                        + "and incorporate pagination and sorting features ",
                termsOfService = "Term and Condition",
                contact = @Contact(
                name = "Nitesh Pandey",
                email = "nkpandey7759@gmail.com"
                ),
                license = @License(
                name ="your License No"
                ),
                version ="3.2.0"
                ),
        servers = {
            @Server(
            description ="Dev",
                    url="http://localhost:8080"
            ),
            @Server(
            description ="test",
                    url="http://localhost:8080"
            ),
                @Server(
            description ="Deployement",
                    url="http://51.20.42.176:8080/Employee/all"
            ),
                  @Server(
            description ="github",
                    url="https://github.com/Pandey-account/EmployeeManagements.git"
            ),
        },
      security =   @SecurityRequirement(name = "authBearer")
)
@SecurityScheme(
        name ="authBearer",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        description = "Security desc",
        scheme = "bearer"
)
public class SwggerConfig {
    
}
