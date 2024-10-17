# Point of Sale (POS) System Backend - Jakarta EE

Welcome to the backend development of the POS system. This project is part of Phase 01 of the AAD course, where we implement a Jakarta EE-based backend to complement the existing frontend of the POS system.

## 🚀 Project Overview

This project implements a **Point of Sale (POS)** system backend using **Jakarta EE**, with **MySQL** as the database. The system is designed with a layered architecture, ensuring separation of concerns and ease of maintainability. The frontend is fully developed, and this project handles the backend API for all transactional and data-handling features.

### 📜 Features

- **Layered Architecture**: Clean separation of presentation, business logic, and data layers.
- **Database Integration**: Uses **MySQL** for data persistence, configured via **JNDI**.
- **AJAX & Fetch API**: Interacts with the frontend using **AJAX** or **Fetch API** to handle requests asynchronously.
- **Logging**: Implements proper logging mechanisms to capture critical events and errors.
- **Native SQL**: Utilizes native SQL queries for efficient database access.
- **API Documentation**: Well-documented API endpoints linked to this repository.

## 🛠️ Tech Stack

- **Jakarta EE**: Backend framework.
- **MySQL**: Database for storing POS-related data.
- **AJAX/Fetch API**: Frontend-backend communication.
- **JNDI**: Java Naming and Directory Interface for database configuration.
- **Native SQL**: Direct SQL queries for optimal performance.

## 📂 Project Structure

The project follows a **layered architecture** pattern:

1. **Controller Layer**: Handles incoming HTTP requests and passes them to the service layer.
2. **Service Layer**: Contains the business logic of the application.
3. **DAO Layer**: Interacts with the database using native SQL.
4. **Entity Layer**: Defines the data structures mapped to the database.

## ⚙️ Setup and Configuration

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/pos-system-backend.git

## 📝 API Documentation

Find the full API documentation here, where each endpoint is detailed with its request and response structure.

## 🔍 Logging

The project uses Jakarta Commons Logging to handle different logging levels (INFO, DEBUG, ERROR). Logs are stored in a file for easy troubleshooting and tracking.

## 🧩 Best Practices

Followed coding best practices with clear code separation, meaningful variable names, and comprehensive error handling.
Applied DRY (Don't Repeat Yourself) and SOLID principles to ensure clean, maintainable code.

## 🤝 Contributing
Contributions are welcome! If you'd like to improve this project or report issues, feel free to open a pull request or submit an issue.

## 📄 License
This project is licensed under the MIT License. See the LICENSE file for more details.