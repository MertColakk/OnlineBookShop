# Book Shopping Application(Start date: 28 April 2024)

This is a simple book shopping application built with Java Spring Boot, featuring RESTful APIs for managing books and a shopping cart.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Endpoints](#endpoints)
- [Database](#database)
- [Features I Want to Add](#feautures-i-want-to-add)
- [Little Note](#little-note)

## Introduction

The Book Shopping Application provides endpoints for managing books and a shopping cart. It allows users to add books, view all books, get details of a specific book, delete books, add books to the shopping cart, view items in the cart, and calculate the total cost of items in the cart.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL
- Maven

## Endpoints

### Users
#### Login
  - URL: /user/login
  - Method: POST
  - Request Paramater: Needs email and password to be in string format
  - Response: Returns the login statues(boolean)

#### Register
  - URL:/user/register
  - Method: POST
  - Request Body: JSON representation of the user
  - Response: Returns the added book with HTTP status OK

#### Get with ID
  - URL: /user/{id}
  - Method: GET
  - Path Variables: User's id(id)
  - Response: Returns user's informations with HTTP status OK
    
### Books
#### Add Book
  - URL: book/add
  - Method: POST
  - Request Body: JSON representation of the book
  - Response: Returns the added book with HTTP status OK

#### Get All Books
  - URL: book/show
  - Method: GET
  - Response: Returns a list of all books with HTTP status OK

### Cart
#### Add to Cart
  - URL: /cart/{userID}/add/{bookID}
  - Method: POST
  - Path Variables: bookID , userID
  - Response: Returns user's cart with HTTP status OK

#### Show Cart
  - URL: /cart/{userID}/items
  - Method: GET
  - Path Variables: userID
  - Response: Returns user's cart with HTTP status OK

#### Show Total Cost
  - URL: /cart/{userID}/total
  - Method: GET
  - Path Variables:  userID
  - Response: Returns the total cost of items in the cart with HTTP status OK

## Database
This application uses "PostgreSQL" for data storage. Make sure to configure the database connection in application.properties.

## Features I Want to Add
  - UI
  - User Access Level

## Little Note
This is my first backend project and I learned a lot while doing this project and I continue to learn!

