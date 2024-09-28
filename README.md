# springboot-search-rest-api

## Overview
This project is a simple Spring Boot application designed to manage product data. It allows you to:
- Insert product data into a **MySQL database** via a **POST** request.
- Search for products in the database via a **GET** request with filters.
- Use **Spring Data JPA** for data persistence.

## Features
- **POST**: Insert a new product into the database.
- **GET**: Search and retrieve product data using filter parameters.
- Database: Uses **MySQL**.
- ORM: Implemented using **Spring Data JPA** with Hibernate.

## Technologies
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL**
- **Lombok** (optional, for reducing boilerplate code)

## Prerequisites
Before you begin, ensure you have the following installed:
- Java 17 or later
- MySQL server
- Maven 3.x+

## Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/NavneetMalva/springboot-search-rest-api.git
    cd springboot-search-rest-api
    ```

2. **Configure MySQL Database**:
   Create a MySQL database for the project.
    ```bash
    CREATE DATABASE searchfilterdb;
    ```

3. **Configure application.properties**:
   Set up your MySQL credentials in the `src/main/resources/application.properties` file:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/searchfilterdb
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    spring.jpa.hibernate.ddl-auto=update

4. **Build the project**: 
   Run the following Maven command to build and package the project:
    ```bash
    mvn clean install
    ```

5. **Run the Application**: 
   You can now run the Spring Boot application with:
    ```bash
    mvn spring-boot:run
    ```

## Endpoints
1. **Insert Product**

   - URL: /api/v1/products
   - Method: `POST`
   - Request Body:
       ```bash
       {
       "name": "Product Name",
       "description": "Product Description",
       }
       ```
   - Response: 200

2. Search Product
   - URL: /api/v1/products/search
   - Method: `GET`
   - Query Parameters:
     - query: Search by product name or by product description 
   - Example Request:
     ```
     http://localhost:8080/api/v1/products/search?query=laptop
     ```
    - Response: 200 OK
      ```bash
      [
       {
        "id": 1,
        "name": "Lenovo ideapad",
        "description": "Laptop",
        "dateCreated": "2024-09-28",
        "dateUpdated": "2024-09-28"
       }
      ]
      ```