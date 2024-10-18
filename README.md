# Online Bookstore

This is the backend service for the Online Bookstore application. It provides RESTful APIs for managing books, shopping cart operations, and basic user authentication.

## Tech Stack

- **Spring Boot**: Framework for building REST APIs.
- **Hibernate/JPA**: For database interactions.
- **MySQL Database**: database for testing.
- **Spring Security**: For user authentication.

## Setup Instructions

### Prerequisites

- **Java 17** (or compatible version for Spring Boot)
- **Maven** (for building the project)
- **MySQL Server**: Make sure you have MySQL installed and running.
- **Postman**: For testing.

### Database Configuration
    CREATE DATABASE online_bookstore;
    USE online_bookstore;

    CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
    );

    CREATE TABLE shopping_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    quantity INT DEFAULT 0,
    FOREIGN KEY (book_id) REFERENCES book(id)
    );

Make sure to update the following in application.properties

- **spring.datasource.url=** jdbc:mysql://localhost:3306/online_bookstore
- **spring.datasource.username=** springsbook
- **spring.datasource.password=** springsbook
### Steps to Run the Project
    
1. **Clone the repository**:
   ```bash
   git clone https://github.com/paradoxboy/online-bookstore-backend.git

2. **Buid and Run**:
    ```bash
   mvn spring-boot:run
3. **Listen on port 8080**:
    ```bash
   http://localhost:80803
4. **Use Postman to test the endpoints**:
    ```bash
   http://localhost:8080/api/books
   http://localhost:8080/api/books/1
   ...
5. **Check in SecurityConfig for Authentication**:
    ```bash
   admin username = oumar
   admin password = admin
