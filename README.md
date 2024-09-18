# calculator-app
This project is a simple, flexible calculator service built in Java, following key object-oriented principles like the Open-Closed Principle (OCP). It handles basic arithmetic operations and lets you chain multiple calculations together. The service includes a REST API for easy access and comes with unit tests to cover different use cases.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Usage](#usage)
  - [REST API Endpoints](#rest-api-endpoints)

## Features
- Supports basic operations: Addition, Subtraction, Multiplication, and Division.
- Allows chaining of multiple operations on a single value.
- Extensible design using the Open-Closed Principle (OCP) to allow for adding new operations without modifying existing code.
- REST API endpoints to perform calculations and chained operations.
- Integrated error handling for invalid operations and inputs.

## Requirements
- Java 11 or higher
- Spring Boot 2.5+
- Maven for dependency management and build

## Setup
1. Clone the repository:

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## Usage

### REST API Endpoints

1. **Perform a Single Calculation:**
   - **Endpoint:** `POST /calculate`
   - **Description:** Perform a basic calculation between two numbers using the specified operation (ADD, SUBTRACT, MULTIPLY, DIVIDE).
   - **Request Body:**
     ```json
     {
       "operation": "ADD",
       "num1": 5,
       "num2": 3
     }
     ```
   - **Response:**
     ```json
     {
      8.0
     }
     ```

2. **Perform a Chained Calculation:**
   - **Endpoint:** `POST /chain-calculate`
   - **Description:** Perform a series of operations sequentially on an initial value.
   - **Request Body:**
     ```json
     {
       "initialValue": 5,
       "operations": [
         {"operation": "ADD", "num2": 3},
         {"operation": "MULTIPLY", "num2": 2},
         {"operation": "DIVIDE", "num2": 4}
       ]
     }
     ```
   - **Response:**
     ```json
     {
      4.0
     }
     ```
