# 🚀 Task Manager API 

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

A highly scalable and secure RESTful backend service designed for robust task and user management. Built entirely on the Spring Boot framework, this API provides a seamless foundation for frontend applications to build comprehensive productivity tools.

---

## ✨ Key Features

### 🔐 Security & Identity
* **JWT Authentication:** Stateless, token-based authentication mechanism handled by a custom `JwtAuthenticationFilter`.
* **Role-Based Access Control:** Differentiates permissions using a dedicated `Role` entity, ensuring users only access what they are authorized to see.
* **Secure Registration & Login:** Dedicated endpoints and custom DTOs (`RegisterRequest`, `LoginRequest`, `LoginResponse`) for secure onboarding.

### 📋 Task Management
* **Full CRUD Operations:** Create, Read, Update, and Delete tasks via the `TaskController`.
* **Categorization:** Classify tasks effectively utilizing `Priority` and `Status` enumerations.
* **Data Encapsulation:** Uses the Builder pattern via `TaskRequest` and `TaskResponse` DTOs to securely pass data between the client and server[cite: 1].

### 🛠 Technical Highlights
* **Centralized Error Handling:** Employs a `GlobalExceptionHandler` to catch exceptions like `EmailAlreadyExistsException` and `InvalidCredentialsException`, returning clean, standardized HTTP responses[cite: 1].
* **Request Auditing:** Features a custom `LoggingFilter` to track and log incoming HTTP requests for easy debugging and monitoring[cite: 1].
* **Clean Architecture:** Strict separation of concerns across Controllers, Services, Repositories, and Entities[cite: 1].

---

## 🏗 Architecture Overview

The application follows a standard **N-Tier (Multi-layer) Architecture** designed for maintainability and scalability[cite: 1]:

1. **Presentation Layer (Controllers):** `TaskController` and `UserController` intercept incoming HTTP requests and validate payloads[cite: 1].
2. **Security Layer (Filters):** `LoggingFilter` logs the request, while `JwtAuthenticationFilter` validates the presence and integrity of the JWT token before allowing access to protected routes[cite: 1].
3. **Business Logic Layer (Services):** `TaskServiceImpl` and `UserServiceImpl` contain the core business rules. `JwtServiceImpl` handles token generation and validation[cite: 1].
4. **Data Access Layer (Repositories):** `TaskRepository` and `UserRepository` interface directly with the database using Spring Data JPA[cite: 1].
5. **Domain Model (Entities):** Classes like `User`, `Task`, `Status`, and `Role` represent the database tables[cite: 1].

---

## 📖 API Documentation

Below is the expected standard endpoint structure based on the application's configuration. *(Note: Base URL is typically `http://localhost:8080/api`)*

### User & Authentication (`UserController`)[cite: 1]
| Method | Endpoint | Description | Request Body (DTO) |
| :--- | :--- | :--- | :--- |
| `POST` | `/users/register` | Register a new user | `RegisterRequest` |
| `POST` | `/users/login` | Authenticate and receive JWT | `LoginRequest` |
| `GET`  | `/users/me` | Get current user details | *Requires JWT Header* |

### Tasks (`TaskController`)[cite: 1]
*All task endpoints require a valid JWT token in the `Authorization: Bearer <token>` header.*

| Method | Endpoint | Description | Request/Response |
| :--- | :--- | :--- | :--- |
| `GET` | `/tasks` | Retrieve all tasks for the logged-in user | Returns `List<TaskResponse>` |
| `GET` | `/tasks/{id}` | Retrieve a specific task by ID | Returns `TaskResponse` |
| `POST` | `/tasks` | Create a new task | Accepts `TaskRequest` |
| `PUT` | `/tasks/{id}` | Update an existing task | Accepts `TaskRequest` |
| `DELETE`| `/tasks/{id}` | Delete a specific task | Returns `204 No Content` |

---

## ⚙️ Setup and Installation

### Prerequisites
* **Java 11+** installed and configured on your machine.
* A relational database (e.g., MySQL, PostgreSQL, or H2 for in-memory testing).
* An API platform like **Postman** or **cURL** for endpoint testing.
