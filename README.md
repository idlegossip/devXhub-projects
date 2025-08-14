# devXhub-projects
This is simple devxhub recruiting intern spring boot project.
DevXHub Intern – Role-Based Access Control API
Overview : 
Spring Boot REST API with role-based access control (RBAC).
Contains public, user, and admin endpoints.
Admins can create new users with validation and password rules.
Default users (admin, intern) are created at startup.

Features
Public endpoint (no authentication required).
User endpoint (USER or ADMIN roles).
Admin endpoint (ADMIN role only).
Create users with username, email, password, and role.
Password must have at least 1 uppercase, 1 number, and 1 special character.
Users stored in the database via JPA/Hibernate.
Passwords encrypted using BCrypt.
Global exception handler for clean error messages.

Tech Stack:
Backend Framework: Spring Boot
Security: Spring Security (role-based authentication & authorization)
Database: PostgreSQL (can switch to H2 for testing)
ORM: JPA/Hibernate
Validation: Jakarta Bean Validation
Password Hashing: BCrypt
Boilerplate Reduction: Lombok

Project Structure:
config/ – Security configuration and default user setup.
controller/ – API endpoints for public, user, and admin routes.
dto/ – Data Transfer Object for user input validation.
error/ – Custom error message model.
exceptionHandler/ – Global exception handling.
model/ – JPA entity for User.
repository/ – Database access layer.
service/ – Business logic for user creation.

How It’s Made:
Backend Framework: Built with Spring Boot.
Security: Implemented Spring Security with role-based authorization (USER / ADMIN).
Validation: Used Jakarta Bean Validation (@NotBlank, @Size, @Pattern, @Email) for input checks.
Data Layer: JPA Entity (User) mapped to a database table.
Service Layer: Handles user creation and applies business rules.
Controller Layer: Defines API endpoints (/public, /user, /admin, /users).
Password Policy: Requires at least one uppercase letter, one number, and one special character.
Lombok: Used annotations for getters, setters, and constructors to reduce boilerplate.
Error Handling: Global exception handler for validation and runtime errors.
Initial Data: Default admin and intern users created on startup.

Dependencies (pom.xml)
Spring Boot Starter Data JPA – Database interaction
Spring Boot Starter Security – Authentication & authorization
Spring Boot Starter Web – REST API development
PostgreSQL Driver – Database connection
Spring Boot Starter Validation – Input validation
Lombok – Reduce boilerplate code

Java Version: 21
Spring Boot Version: 3.5.4