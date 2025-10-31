# CK Tech Hub - Spring Boot Learning Project

A simple Spring Boot application to learn basic concepts like Beans, Dependency Injection, and Web Controllers.

## 📚 What You'll Learn

This project teaches you these important Spring Boot concepts:
- **Beans** - Objects that Spring manages for you
- **Dependency Injection** - How Spring gives objects to your classes automatically
- **Components** - Classes that Spring scans and manages
- **Web Controllers** - Classes that handle web requests
- **Auto Configuration** - How Spring sets up everything automatically

## 🚀 How to Run the Application

### Prerequisites
- Java 21 or higher
- Maven (comes with the project)

### Running the App
1. Open terminal in the project folder
2. Run this command:
   ```bash
   ./mvnw spring-boot:run
   ```
   (On Windows: `mvnw.cmd spring-boot:run`)

3. Open your web browser and go to: `http://localhost:8080`
4. You should see: "Welcome to CK Tech Hub! This is our first Spring Boot application."

## 📁 Project Structure

```
src/main/java/com/intro/cktechhub/
├── CktechhubApplication.java    # Main app class (starts everything)
├── RazorPay.java               # Payment service class
└── beans/
    └── Page.java               # Web page controller
```

## 🔍 Code Explanation

### 1. Main Application Class (`CktechhubApplication.java`)
- **Purpose**: Starts the Spring Boot application
- **Key Features**:
  - Shows 3 different ways to inject dependencies
  - Uses `CommandLineRunner` to run code after startup
  - Demonstrates `@Autowired` annotation

### 2. Payment Service (`RazorPay.java`)
- **Purpose**: Handles payment processing
- **Key Features**:
  - Uses `@Component` to let Spring manage it
  - Simple payment method that returns success message

### 3. Web Controller (`Page.java`)
- **Purpose**: Handles web requests from browsers
- **Key Features**:
  - Uses `@RestController` to handle HTTP requests
  - `@GetMapping("/")` handles home page requests

## 🧠 Key Spring Boot Concepts Explained

### What are Beans?
- **Simple Answer**: Objects that Spring creates and manages for you
- **Why Useful**: You don't have to create objects manually
- **Example**: `RazorPay` class is a Bean because it has `@Component`

### What is Dependency Injection?
- **Simple Answer**: Spring automatically gives your class the objects it needs
- **Why Useful**: Your classes don't have to create their own dependencies
- **Example**: Spring automatically gives `RazorPay` object to `CktechhubApplication`

### What Happens When You Run the App?
1. Spring Boot starts up
2. Spring scans for classes with annotations (`@Component`, `@RestController`, etc.)
3. Spring creates Bean objects from these classes
4. Spring injects dependencies where needed (`@Autowired`)
5. Web server starts on port 8080
6. `CommandLineRunner.run()` method executes
7. App is ready to handle web requests

## 🛠 What You Can Try

1. **Add a new web page**: Create a new method in `Page.java` with `@GetMapping("/about")`
2. **Create a new service**: Make a new class with `@Component` and use it in the main class
3. **Change the payment message**: Modify the `pay()` method in `RazorPay.java`

## 📖 Learning Resources

- [Spring Boot Official Guide](https://spring.io/guides/gs/spring-boot/)
- [What is Dependency Injection?](https://www.baeldung.com/spring-dependency-injection)
- [Spring Boot Annotations Explained](https://www.baeldung.com/spring-boot-annotations)

---

**Happy Learning! 🎉**

*This project is designed for beginners to understand Spring Boot basics step by step.*


