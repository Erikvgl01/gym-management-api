# Gym Management API

This project is a RESTful API built with Spring Boot for managing a gym network. It allows the creation, retrieval, and deletion of students, along with the management of related entities such as memberships, employees, and gym units.

## 🚀 Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Docker
* Lombok

## 📦 Features

* Create, list, search, and delete students
* Database integration with PostgreSQL
* Object-relational mapping using JPA/Hibernate
* Layered architecture (Controller, Service, Repository)
* Input validation and business rules in the service layer
* REST API tested with Postman

## 🏗️ Project Structure

* **Controller** → Handles HTTP requests
* **Service** → Contains business logic
* **Repository** → Handles database access
* **Model** → Defines application entities

## 🧪 API Testing

The API can be tested using Postman with endpoints such as:

* `POST /alunos`
* `GET /alunos`
* `GET /alunos/{id}`
* `DELETE /alunos/{id}`

## 🐳 Database

The application uses PostgreSQL running in a Docker container.

## 📌 Status

Project under development — new features and improvements will be added.

