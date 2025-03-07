# Quiz Management System

The **Quiz Management System** is a scalable, **microservices-based platform** designed to simplify quiz creation and management. Educators can create and categorize quizzes, generate question papers, and track student performance. Students get a seamless experience to access and attempt quizzes, with each quiz restricted to a single attempt.

#### For Educators:
- Effortlessly create and organize quizzes under various categories.
- Generate and download question papers using pre-built templates.
- Monitor student performance through detailed reports and analytics.
#### For Students:
- Access quizzes through a user-friendly dashboard.
- Attempt quizzes with a smooth and intuitive interface.
- View scores and feedback instantly to track progress.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Build](#build)
- [Contributing](#Contributing)

## Features

### **For Educators:**

- Create and publish quizzes in different categories.
- Generate and download question papers with templates.

### **For Students:**

- Access quizzes through a personalized dashboard.
- Each quiz can only be attempted once.

## Tech Stack

- **Frontend:** Angular 17, Angular Material
- **Backend:** Spring Boot
- **Database:** MySQL
- **Authentication:** JWT Auth

## Installation

### **Prerequisites:**

Make sure you have the following installed:

- Node.js and npm
- Java Development Kit (JDK)
- MySQL

### **Backend Setup:**

1. Clone the repository:
   ```sh
   git clone https://github.com/magnet107/EduQuizPortal.git
   cd EduQuizPortal/Backend

2. Create a MySQL database:
   ```sql
   CREATE DATABASE <databaseName>;

3. Update the database settings in src/main/resources/application.properties.
4. Build and run the backend
    ```sh
    ./mvnw clean install
    ./mvnw spring-boot:run

### **Frontend:**
1. Navigate to the frontend directory:
    ```bash
    cd ../Frontend
    ```
2. Install dependencies:
    ```bash
    npm install
    ```
3. Run the frontend:
    ```bash
    ng serve
    ```


## Usage
1. Open your browser and navigate to `http://localhost:4200/signup` to access the signup page.
2. Educators can log in to create and manage quizzes.
3. Students can log in to access and take available quizzes.

## Build
#### Backend:
Run the following command to build the backend:

    ./mvnw clean install

#### Frontend:
To build the Angular project:

    ng build

## Contributing
We welcome contributions! To get involved:

- Fork the repository.
- Create a new branch for your feature.
- Make your changes and commit them.
- Push to your branch and open a Pull Request.
