
# Spring Boot REST API - Simple Guide

## Libraries Used:
- **Lombok** - Automatically writes repetitive code
- **Spring Web** - Creates REST APIs
- **Spring Data JPA** - Handles database operations
- **PostgreSQL Driver** - Connects to PostgreSQL database

## What is REST API?

REST API is a way for applications to communicate:
- Client sends HTTP request
- Server processes the request
- Server sends back HTTP response with data

## MVC Architecture:

1. **Model** - Data structure (Entity classes)
2. **Controller** - Handles HTTP requests and responses
3. **View** - Response format (JSON)

**Dispatcher Servlet** - Routes incoming requests to correct controller

## Three Layer Architecture:

```
┌─────────────┐    HTTP Request     ┌─────────────────┐
│   CLIENT    │ ──────────────────► │   CONTROLLER    │
│ (Browser/   │                     │ (Presentation   │
│  Postman)   │ ◄────────────────── │    Layer)       │
└─────────────┘    HTTP Response    └─────────────────┘
                                            │
                                            │ DTO
                                            ▼
                                    ┌─────────────────┐
                                    │    SERVICE      │
                                    │ (Business Logic)│
                                    └─────────────────┘
                                            │
                                            │ Entity
                                            ▼
                                    ┌─────────────────┐
                                    │   REPOSITORY    │
                                    │ (Data Access)   │
                                    └─────────────────┘
                                            │
                                            ▼
                                    ┌─────────────────┐
                                    │    DATABASE     │
                                    │  (PostgreSQL)   │
                                    └─────────────────┘
```

## Important Annotations:

**Controller Annotations:**
- `@RestController` - Marks class as REST controller, returns JSON
- `@GetMapping` - Handles GET requests (retrieve data)
- `@PostMapping` - Handles POST requests (create new data)
- `@PutMapping` - Handles PUT requests (complete update)
- `@PatchMapping` - Handles PATCH requests (partial update)
- `@DeleteMapping` - Handles DELETE requests (remove data)
- `@PathVariable` - Gets values from URL path
- `@Valid` - Validates request data

**Class Annotations:**
- `@Data` - Auto-generates getters, setters, toString methods
- `@AllArgsConstructor` - Creates constructor with all fields
- `@NoArgsConstructor` - Creates empty constructor
- `@Getter` & `@Setter` - Creates getter and setter methods
- `@RequiredArgsConstructor` - Creates constructor for required fields only

**Database Annotations:**
- `@Entity` - Marks class as database table
- `@Configuration` - Marks class as configuration class

## Repository Layer:

- **Interface** that connects controller to database
- Extends `JpaRepository` for basic CRUD operations
- Write custom database queries here
- Examples: `findAll()`, `findById()`, `save()`, `deleteById()`

## Service Layer:

- Contains **business logic**
- Processes data between controller and repository
- `stream()` - Converts one collection to another
- `ModelMapper` - Maps data between DTOs and Entities
- Handles data validation and transformation

## ResponseEntity:

Controls HTTP response with status codes:

- `200 OK` - Request successful
- `201 CREATED` - New resource created
- `404 NOT FOUND` - Resource not found
- `500 INTERNAL SERVER ERROR` - Server error

## Data Flow Example:

**Get All Students:**
1. Client sends: `GET /students`
2. Controller receives request
3. Controller calls Service
4. Service calls Repository
5. Repository queries Database
6. Data flows back: Database → Repository → Service → Controller → Client 