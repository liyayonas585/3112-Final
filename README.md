# Bookstore Management System

This is a Java project that simulates a basic bookstore management system. It supports operations such as adding, removing, selling, searching, and requesting books. There are two user roles: **Owner** and **Employee**.

## Features

- Add new books to inventory
- Search for books
- Sell books and update revenue
- Request restocks
- Track total revenue (Owner only)
- Role-based access (Owner vs Employee)

## Project Structure

The system includes the following classes:

- `Main.java` – Entry point and interface logic
- `Bookstore.java` – Handles inventory and sales
- `Book.java` – Represents a book object
- `Sales.java` – Represents a sales log entry
- `User.java` – Abstract user class
- `Owner.java` – Extends `User` with owner-specific behavior
- `Employee.java` – Extends `User` for employee actions

## How to Run (VS Code Terminal)

1. **Open VS Code** and navigate to the folder containing your `.java` files.

2. **Open the Terminal** (`Ctrl + ` or View > Terminal).

3. **Compile all Java files**:
   ```bash
   javac *.java

   Or right-click on Main.java and click Run Java. Follow the instructions on the screen to test each method. 
