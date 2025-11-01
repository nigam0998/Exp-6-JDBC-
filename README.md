Java Applications Using JDBC for Database Connectivity, CRUD Operations, and MVC Architecture
Part a: Connecting to MySQL and Fetching Data from a Table
Objective:
To develop a Java program that connects to a MySQL database and retrieves data from a single table using JDBC.

Explanation:
This task introduces basic JDBC connectivity to perform a read operation:

Use DriverManager to load the JDBC driver and connect to the database.
Use Connection, Statement, and ResultSet to execute SQL commands.
Target a table named Employee with columns: EmpID, Name, and Salary.
Write and execute a SELECT query to fetch all records from the table.
Display each record using a loop to demonstrate the output clearly.
This exercise helps build foundational skills for working with JDBC and SQL databases in Java.

Part b: CRUD Operations on Product Table Using JDBC
Objective:
To create a menu-driven Java program that performs CRUD operations (Create, Read, Update, Delete) on a Product table in a MySQL database with proper transaction handling.

Explanation:
This program requires the use of JDBC to:

Connect to a database and manage a table named Product with columns:

ProductID
ProductName
Price
Quantity
Provide a menu to perform the following:

Create: Insert a new product record.
Read: Display all existing product records.
Update: Modify product details using the ProductID.
Delete: Remove a product by its ID.
Include transaction handling using setAutoCommit(false) and commit()/rollback() to ensure data integrity and consistency, especially for update and delete operations.

This question tests your understanding of:

Writing and executing SQL statements.
Using PreparedStatement for safe and parameterized queries.
Managing multiple database operations in a secure and consistent way.
Part c: Student Management Application Using JDBC and MVC Architecture
Objective:
To build a Java application that manages student data using JDBC and follows the Model-View-Controller (MVC) design pattern.

Explanation:
This task focuses on building a well-structured Java application that performs database operations while adhering to software design principles:

Model (Student Class):

Fields: StudentID, Name, Department, Marks.
Represents the student data structure.
View (User Interface):

Menu-driven system for:

Adding a new student.
Viewing all students.
Updating student details.
Deleting a student record.
Controller (Database Operations Class):

Contains JDBC logic for performing all CRUD operations.
Uses PreparedStatement for executing SQL commands securely.
This question integrates:

Object-oriented programming with JDBC.
MVC architecture for better separation of concerns.
Robust input handling and database operations.
