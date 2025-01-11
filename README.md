# Attendance Management System (AMS)

## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Requirements](#requirements)
5. [Setup Instructions](#setup-instructions)
6. [Usage Instructions](#usage-instructions)
7. [Database Setup](#database-setup)
8. [Jasper Reports Integration](#jasper-reports-integration)
9. [Known Issues](#known-issues)
10. [Contributors](#contributors)

---

## Project Overview
This project is an **Attendance Management System (AMS)** designed to help manage and track student attendance efficiently. Users can add, edit, delete, and search for student information, mark attendance, and generate reports using JasperReports.

---

## Features
- Add, delete, and search student records.
- Mark students as "Present" or "Absent".
- Generate attendance reports in PDF format using JasperReports.
- Filter students by course and batch.
- Encrypted password storage for secure login.
- Validation for email, phone number, and other fields.

---

## Technologies Used
- **Programming Language:** Java (Swing for GUI)
- **Database:** MySQL
- **Libraries:**
  - JasperReports for report generation
  - Jasypt for password encryption
- **Build Tool:** Maven (for dependencies and project management)

---

## Requirements
- Java JDK 8 or higher
- MySQL Server (or any compatible database)
- JasperReports Library (if generating reports)
- IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans)
- Maven (if you're managing dependencies)

---

## Setup Instructions
1. Clone this repository:
   ```bash
   git clone [<repository-link>](https://github.com/starlightaris/StudentAttendanceMS.git)
   ```
2. Open the project in your preferred IDE.
3. Import dependencies using Maven (`pom.xml`).
4. Configure the database connection in the `DBConnection` class:
   ```java
   connection = DriverManager.getConnection(
       "jdbc:mysql://<host>:<port>/<database>", "<username>", "<password>");
   ```
5. Compile the project and run it.

---

## Usage Instructions
1. Launch the application by running the `Main.java` file.
2. Use the following features:
   - **Add Students:** Fill out the form and click "Save".
   - **Search Students:** Select a course and batch, then click "Search".
   - **Mark Attendance:** Select a student, update their status, and click "Save".
   - **Generate Reports:** Use the "Generate Report" button to create a report for the selected course and batch.

---

## Database Setup
1. Create the MySQL database and tables using the following schema:
   ```sql
   CREATE DATABASE attendance_management;

   USE attendance_management;

   CREATE TABLE admin (
       adminId INT AUTO_INCREMENT PRIMARY KEY,
       adminName VARCHAR(255),
       email VARCHAR(255),
       password VARCHAR(255),
       phoneNo VARCHAR(10),
       gender ENUM('Male', 'Female', 'Other')
   );

   CREATE TABLE student (
       studentId INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255),
       email VARCHAR(255),
       phoneNo VARCHAR(10),
       gender ENUM('Male', 'Female', 'Other'),
       courseId INT,
       batchId INT
   );

   CREATE TABLE attendance (
       attendanceId INT AUTO_INCREMENT PRIMARY KEY,
       studentId INT,
       status ENUM('Present', 'Absent'),
       date DATE,
       FOREIGN KEY (studentId) REFERENCES student(studentId)
   );
   ```
2. Insert sample data into the tables:
   ```sql
   INSERT INTO student (name, email, phoneNo, gender, courseId, batchId) VALUES
   ('John Doe', 'john.doe@example.com', '1234567890', 'Male', 1, 1),
   ('Jane Smith', 'jane.smith@example.com', '0987654321', 'Female', 1, 1);
   ```

---

## Jasper Reports Integration
1. Place the `AMS.jrxml` file in your project's root directory.
2. Compile the JRXML file to a `.jasper` file when generating reports dynamically.
3. Configure the `generateReport` method in `ReportGenerator.java` to use your database connection.

---

## Known Issues
- The `Save` button sometimes does not work due to missing validations. (To be fixed in the next version.)
- UI may look inconsistent on different screen resolutions.

---

## Contributors
- [Senulya P H P](https://github.com/starlightaris)

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

