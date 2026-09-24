# Airline_Management_System
Java and JDBC-based Airline Management System for managing flights, passenger details, flight search, seat selection, bookings, and payment operations.

# ✈️ Airline Management System

## 📌 Project Overview

The **Airline Management System** is a Java-based application developed to manage basic airline operations such as user registration, login, flight management, flight search, flight selection, seat selection, and payment.

The project uses **Java, JDBC, and MySQL** for application development and database connectivity.

## 🎯 Objectives

- Provide a simple system for managing airline-related operations.
- Allow users to register and log in to the application.
- Display and search available flight details.
- Allow users to select flights and seats.
- Manage the booking process.
- Provide a payment interface.
- Connect the Java application with a MySQL database using JDBC.

## 🚀 Features

- 👤 User Registration
- 🔐 User Login
- ✈️ Flight Details
- 🔎 Search Flights
- 🛫 Flight Selection
- 💺 Seat Selection
- 💳 Payment
- 🗄️ MySQL Database Connectivity
- 🔌 JDBC-based Database Connection

## 🛠️ Technologies Used

- **Java**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **Eclipse IDE**
- **Java Swing** for the graphical user interface

## 🏗️ Project Flow

```text
User
  ↓
Login / Registration
  ↓
Main Menu
  ↓
Search Flight
  ↓
Select Flight
  ↓
Seat Selection
  ↓
Payment
  ↓
Database

🗄️ Database Connectivity

The application uses JDBC to connect the Java application with a MySQL database.

The database connection is handled through:

DBConnection.java

The application uses the MySQL JDBC connection URL:

jdbc:mysql://localhost:3306/java

Users need to configure their own MySQL username and password before running the application.

⚙️ How to Run the Project
 Prerequisites
Install the following:
Java JDK
Eclipse IDE
MySQL Server
MySQL JDBC Driver

Configure MySQL
Create a MySQL database named:java
Update the database username and password in:DBConnection.java

Example:
private static final String URL = "jdbc:mysql://localhost:3306/java";
private static final String USER = "your_username";
private static final String PASS = "your_password";
Add MySQL JDBC Driver
Make sure the MySQL Connector/J driver is added to the project's build path.
Run the Application
Run:
MainApp.java
The application will start and provide access to the airline management features.

🔐 Database Security
Database credentials should not be committed to a public repository.
For demonstration purposes, the repository contains placeholder values:

your username
your password

Replace them with your own local MySQL credentials when running the application.


🔮 Future Enhancements
Online ticket generation
Email confirmation for bookings
Real-time flight availability
Online payment gateway integration
Admin dashboard
Cancellation and refund management
Improved database security
Cloud database integration
