# Tournament-management
## Description
This application is a tournament management system written in Java. It uses vanilla JDBC for database interaction and Maven for dependency management. The application can perform CRUD operations on tournaments, participants and matches.
## Prerequisite
- Java Development Kit (JDK)
- Maven
- PostgreSQL
## Installation
Clone the repository
```
git clone https://github.com/MiiJack/Tournament-management.git
```
Navigate to the project directory
```
cd Tournament-management
```
Install the dependencies using Maven
```
mvn install
```
## Database Setup
Make sure PostgreSQL is installed and running on your system.
Set the ``DB_USER`` and ``DB_PASSWORD`` environment variables to your PostgreSQL username and password respectively. 

Navigate to the ``src/main/resources`` directory, you will find a ``database.sql`` file. Run this file in your PostgreSQL client to create the required tables.
You will also find a ``mock.sql`` file in the same directory. Run this file to populate the database with mock data.

## Running the Application
To run the application, navigate to the project directory and execute the following command:
```
mvn spring-boot:run
```
This command will start the Spring Boot application by invoking the main method in the TournamentManagementApplication class.

## API Documentation
[Here'](https://petstore.swagger.io/?url=https://raw.githubusercontent.com/MiiJack/Tournament-management/main/openapi.yaml)s a preview of the API on SwaggerUI
