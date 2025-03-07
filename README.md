# Quiz Management System

The **Quiz Management System** is a user-friendly platform that makes it easy for educators to create, manage, and share quizzes, while students can access and complete them seamlessly. Teachers can categorize quizzes, generate question papers, and track student performance, ensuring a smooth assessment experience.

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

### **Frontend Setup:**
###### Navigate to the frontend folder:

    cd ../Frontend

###### Install dependencies:
    npm install

###### Start the frontend server:
    ng serve

Note: You need to manually create an admin (Educator) user by inserting the details directly into the database.


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
