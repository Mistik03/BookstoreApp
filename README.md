# Bookstore Management Application

## Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Setup](#project-setup)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [License](#license)
- [Contributors](#contributors)

---

## Project Description
The **Bookstore Management Application** is a backend system designed to manage a bookstore's operations. It provides a RESTful API for:
- Managing books, authors, categories, customers, and orders.
- Searching and filtering books by title, category, or author.
- Managing customer orders and calculating total revenue.

This project eliminates the need for a frontend by allowing testing and interaction through Postman.

---

## Features
- **Books**: CRUD operations, search by title, and filtering by category or author.
- **Authors**: Manage authors and their biographies.
- **Categories**: Organize books by categories.
- **Customers**: Manage customer data, including emails and phone numbers.
- **Orders**: Place and manage customer orders, calculate total revenue.
- **Postman Testing**: Test all API endpoints interactively.

---

## Technologies Used
- **Programming Language**: Java 17
- **Framework**: Spring Boot
- **Database**: MySQL
- **Build Tool**: Maven
- **API Testing**: Postman
- **Version Control**: Git and GitHub

---

## Project Setup

### Prerequisites
- **Java**: Version 17 or higher.
- **MySQL**: Installed and running locally or remotely.
- **Maven**: Installed for building the project.
- **Postman**: Installed for API testing.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Mistik03/BookstoreApp.git
   cd BookstoreApp

2. Configure the database in src/main/recources/application.properties :
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update

3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run

## API Endpoints

   ### Book
   | HTTP Method | Endpoint | Description |
   | --- | --- | --- |
   | GET | /api/books | Retrieve all books |
   | GET | /api/books/{id} | Retrieve a book by ID |
   | POST | /api/books/{id} | Add a new book |
   | PUT | /api/books/{id} | Update a book |
   | DELETE | /api/books/{id} | Delete a book |
   | GET | /api/books/search | Search books by title |
   | GET | /apai/books/filter | Filter books by price range |

   ### Customer
   | HTTP Method | Endpoint | Description |
   | --- | --- | --- |
   | GET | /api/customers | Retrieve all customers |
   | GET | /api/customers/{id} | Retrieve a customer by ID |
   | POST | /api/customer | Add a new customer |
   | PUT | /api/customer/{id} | Update a customer |
   | DELETE | /api/customer/{id} | Delete a customer |
   | GET | /api/customer/exists | Check if a customer exists by email |

   ### Order
   | HTTP Method | Endpoint | Description |
   | --- | --- | --- |
   | GET | /api/orders | Retrieve all orders |
   | GET | /api/orders/{id} | Retrieve an order by ID |
   | POST | /api/orders | Place a new order |
   | DELETE | /api/orders/{id} | Delete an order |
   | GET | /api/orders/revenue | Calculate total revenue |
   | GET | /api/orders/customer/{customerID} | Orders by Customer ID |

   ### Author
   | HTTP Method | Endpoint | Description |
   | --- | --- | --- |
   | GET | /api/authors | Retrieve all authors |
   | GET | /api/authors/{id} | Retrieve a author by ID |
   | POST | /api/authors | Add a new author |
   | PUT | /api/author/{id} | Update an existing author |
   | DELETE | /api/author/{id} | Delete an author |
   | GET | /api/author/search | Search authors by name |

   ### Category
   | HTTP Method | Endpoint | Description |
   | --- | --- | --- |
   | GET | /api/categories | Retrieve all categories |
   | GET | /api/categories/{id} | Retrieve a specific category by ID |
   | POST | /api/categories | Add a new category |
   | PUT | /api/categories/{id} | Update an existing category |
   | DELETE | /api/categories/{id} | Delete a category |
   | GET | /api/categories/search | Search categories by name |

## License

   This project is licensed under the MIT License. See the [LICENSE](https://github.com/Mistik03/BookstoreApp/LISENCE.md/) file for details.

## Contributors

   Arb Xhelili (xheliliarb@gmail.com)
