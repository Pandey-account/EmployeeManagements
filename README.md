**Readme.txt File Template:**

---

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

- Ensure CouchDB is installed and running.

- Configure the database connection in `application.properties`:

```properties
spring.data.couchbase.connection-string=<CouchDB_Connection_String>
spring.data.couchbase.username=<CouchDB_Username>
spring.data.couchbase.password=<CouchDB_Password>
```

#### 3. API Documentation:

##### Entry Level:

a. **Add Employee:**
- **Endpoint:** POST `/api/employees`
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
- **Endpoint:** GET `/api/employees`
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
- **Endpoint:** DELETE `/api/employees/{employeeId}`
- **Input:** None
- **Output JSON Structure:**
  ```json
  {
    "message": "Employee deleted successfully"
  }
  ```

d. **Update Employee by ID:**
- **Endpoint:** PUT `/api/employees/{employeeId}`
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
- **Endpoint:** GET `/api/employees/{employeeId}/managers/{level}`
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
- **Endpoint:** GET `/api/employees?page={pageNumber}&size={pageSize}&sort={sortField}`
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



hosting link:- https://employeemanagements-production.up.railway.app/Employee/all
