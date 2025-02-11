Department Management:
  Create Department: Endpoint to add a new department.
  Fetch All Departments: Endpoint to retrieve a list of all departments.
  Fetch Department by ID: Endpoint to get details of a specific department using its ID.
  Delete Department by ID: Endpoint to remove a department using its ID.
  Update Department: Endpoint to modify details of an existing department.
  Fetch Department by Name: Endpoint to get details of a department using its name.
  
Feature Management:
  Custom Actuator Endpoint: Provides endpoints to manage feature toggles, allowing you to enable or disable specific features.
  
Exception Handling:
  Custom Exception: DepartmentNotFoundException to handle cases where a department is not found.
  Global Exception Handler: Handles DepartmentNotFoundException and returns a structured error message.
  
Entities:
  Department: Represents the department entity with fields like ID, name, address, and code.
  Feature: Represents a feature toggle with an enabled/disabled status.
  ErrorMessage: Represents error messages with HTTP status and message.
  
Repository:
  DepartmentRepository: JPA repository for performing CRUD operations on the Department entity.
  
Services:
  DepartmentService: Interface defining methods for department-related operations.
  DepartmentServiceImplementation: Implementation of the DepartmentService interface.
  
Logging:
  SLF4J Logging: Used for logging important information in the DepartmentController.
  
Configuration:
  FeatureEndPoint: Custom actuator endpoint for managing feature toggles.
  
Welcome Message:
  HelloController: Simple endpoint to return a welcome message.
