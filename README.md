<<<<<<< HEAD
Employee Management API
Introduction
This project implements an Employee Management API using Spring Boot. It provides endpoints to add, retrieve, update, and delete employee records in a database. Additionally, it offers functionalities such as retrieving nth level managers, pagination and sorting of employees, sending email notifications, and hosting the application on a free platform.

Technologies Used

Spring Boot 3.2.1
Mongodb 7
JavaMail API
AWS (for hosting)

API Endpoints

Entry Level

Add Employee: POST /Employee/
Body: EmployeeName, PhoneNumber, Email, ReportsTo, ProfileImage
Returns: Employee ID

Get  Employee by Id: GET /Employee/{id}
Returns:  Employee

Update Employee by ID: PUT /Employee/{id}
Path Parameter: id (Employee ID)
Body: Updated employee details

Delete Employee by ID: DELETE /Employee/{id}
Path Parameter: id (Employee ID)


Intermediate Level
Get nth Level Manager: GET /Employee/{employeeId}/manager/{level}
Path Parameters: employeeId, level

Get Employees with Pagination and Sorting: GET /Employee/all or GET /Employee/all?pageNumber=1&pageSize=2&sortBy=employeeName
Returns: List of all employees for the Pagination and Sorting

Get Swagger: Get http://51.20.42.176:8080/swagger-ui/index.html
List of all API

Advanced Level
Send Email to Level 1 Manager on New Employee Addition: Triggered automatically on adding a new employee.

Validation and Error Handling
Input validation is implemented for all API endpoints.
Error handling mechanisms are in place to handle exceptions gracefully and provide meaningful error messages to clients.

Deployment
The application is hosted on aws and accessible at http://51.20.42.176:8080/Employee/

Running Locally
To run the application locally:

Clone this repository.
Configure your MongoDB database details in application.properties.
Run the application using Maven: mvn spring-boot:run.
Contributing
Contributions are welcome! If you'd like to contribute to this project, feel free to fork the repository and submit a pull request with your changes.

License
This project is licensed under the MIT License.
=======
**Readme.txt File Template:**

hosting link:- https://employeemanagements-production.up.railway.app/Employee/all

### Project Overview:

This Spring Boot project, named EmployWise, is designed to manage employee data using a NoSQL database (CouchDB preferred). The application provides various API endpoints for CRUD operations on employee records.

### Instructions:

#### 1. Running the Project:

- Clone the project repository.

```bash
git clone <repository_url>
```

- Navigate to the project directory.

```bash
cd EmployWise
```

- Run the project using Maven.

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

#### 2. Database Setup:

- Ensure MongoDB is installed and running.

- Configure the database connection in `application.properties`:

```properties
spring.data.mongodb.host=<MongoDB_host_String>
spring.data.mongodb.port=<MogoDB_port_integer>
spring.data.mongodb.database=<MongoDB_database_String>
spring.data.mongodb.username=<MongoDB_Username>
spring.data.couchbase.password=<MongoDB_Password>
```

#### 3. API Documentation:

##### Entry Level:

a. **Add Employee:**
- **Endpoint:** POST `/Employee/`
- **Input JSON Structure:**
  ```json
  {
    "employeeName": "John Doe",
    "phoneNumber": "+1234567890",
    "email": "john.doe@example.com",
    "reportsTo": "manager_employee_id",
    "profileImage": "https://google.com/image_url"
  }
  ```
- **Output JSON Structure:**
  ```json
  {
    "id": "generated_unique_uuid"
  }
  ```

b. **Get All Employees:**
- **Endpoint:** GET `/Employee/all`
- **Input:** None
- **Output JSON Structure:**
  ```json
  [
    {
      "id": "employee_id",
      "employeeName": "John Doe",
      "phoneNumber": "+1234567890",
      "email": "john.doe@example.com",
      "reportsTo": "manager_employee_id",
      "profileImage": "https://google.com/image_url"
    },
    // ... other employees
  ]
  ```

c. **Delete Employee by ID:**
- **Endpoint:** DELETE `/Employee/{employeeId}`
- **Input:** None
- **Output JSON Structure:**
  ```json
  {
    "message": "Employee deleted successfully"
  }
  ```

d. **Update Employee by ID:**
- **Endpoint:** PUT `/Employee/{employeeId}`
- **Input JSON Structure:**
  ```json
  {
    "employeeName": "Updated Name",
    "phoneNumber": "+9876543210",
    "email": "updated.email@example.com",
    "reportsTo": "new_manager_employee_id",
    "profileImage": "https://google.com/updated_image_url"
  }
  ```
- **Output JSON Structure:**
  ```json
  {
    "message": "Employee updated successfully"
  }
  ```

##### Intermediate Level:

a. **Get nth Level Manager:**
- **Endpoint:** GET `/Employee/{employeeId}/managers/{level}`
- **Input:** None
- **Output JSON Structure:**
  ```json
  {
    "managerId": "manager_employee_id",
    "managerName": "Manager Name",
    "managerEmail": "manager.email@example.com",
    // ... other manager details
  }
  ```

b. **Get Employees with Pagination and Sorting:**
- **Endpoint:** GET `/Employee?page={pageNumber}&size={pageSize}&sort={sortField}`
- **Input:** None
- **Output JSON Structure:**
  ```json
  {
    "content": [
      {
        "id": "employee_id",
        // ... other employee details
      },
      // ... other employees on the specified page
    ],
    "totalPages": 5,
    "totalElements": 50,
    // ... other pagination details
  }
  ```

##### Advanced Level:

a. **Send Email to Level 1 Manager on New Employee Addition:**
- **Email Triggered Automatically on Employee Addition.**
- **Email Content:**
  ```
  <EmployeeName> will now work under you. Mobile number is <PhoneNumber> and email is <EmailId>.
  ```
- **Email Link:** Opens default email client.

b. **Host the Application:**
- Deploy the application on a free hosting platform (e.g., Heroku, AWS Free Tier).
- Access the deployed application using the provided URL.

#### 4. Validations and Error Handling:

- The application includes robust validations for input data.
- Appropriate error messages and status codes are returned in case of errors.

**Note:** Ensure that you follow the instructions carefully to avoid any issues during setup and execution.

---




>>>>>>> origin/master
