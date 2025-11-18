# SpringBoot Employee CRUD

Simple Spring Boot web application demonstrating basic Create, Read, Update, Delete (CRUD) operations for an Employee entity using Thymeleaf templates.

## Features
- Add new employee
- List / view employees
- Edit employee
- Delete employee
- Server-side rendered UI with Thymeleaf (templates in src/main/resources/templates)


## Quick start (Eclipse)
1. Download the ZIP and extract the folder.
2. Open Eclipse.
3. File -> Import -> Existing Maven Projects and select the extracted project folder (`c:\Users\LENOVO\Downloads\employee`).
4. Project -> Update Maven Project.
5. Open `src/main/resources/application.properties` and update your DB username and password. To run on port 2025, add or set:
   server.port=2025
6. Right-click the project -> Run As -> Spring Boot App (or click Run).
7. Open a browser and go to: http://localhost:2025

## Endpoints (mapped in MyController)
- GET /            -> main page
- GET /add         -> form to add a new employee
- POST /add        -> submit new employee
- GET /view        -> view list of employees
- GET /edit?id={id}-> edit form for employee
- POST /update     -> submit employee update
- GET /delete?id={id} -> delete employee

## Project layout
- src/main/java/com/employee/employee
  - EmployeeApplication.java
  - MyController.java
  - entity/Employee.java
  - repo/EmployeeRepository.java
- src/main/resources/templates
  - main.html, add.html, view.html, edit.html
- src/main/resources/application.properties

## Notes
- Ensure your database driver and connection properties are configured correctly in `application.properties`.
- If you prefer CLI: from project root run `mvn spring-boot:run` (or use the Maven wrapper).

