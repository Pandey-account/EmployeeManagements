 HEAD
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



