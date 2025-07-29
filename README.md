# 🔗 Enrollment-Service – Student-Course Enrollment Microservice

## ✅ Status: Completed

This microservice manages **student enrollments in courses**, linking data from `student-service` and `course-service`.

---

## 🎯 Objective

Handles enrollment creation, course completion, and drop operations.

---

## ✨ Features

- Enroll students into courses
- Drop or complete a course
- Feign client validation with student & course services
- DTO input validation

---

## 🛠️ Tech Stack

- Spring Boot
- Spring Security + JWT
- Spring Data JPA + MySQL
- Java 17+, Lombok, MapStruct
- Feign Clients

---

## 📚 API Endpoints

| Method | Endpoint                     | Description                   |
|--------|------------------------------|-------------------------------|
| POST   | /enrollments                 | Enroll a student              |
| GET    | /enrollments/student/{id}    | Get enrollments by student ID|
| GET    | /enrollments/course/{id}     | Get enrollments by course ID |

---

## 🔗 Related Services

| Service | Description | Repository |
|--------|-------------|------------|
| 🎓 [`student-service`](https://github.com/CODERonak/Student-Course-Student-Service) | Student info | [GitHub](https://github.com/CODERonak/Student-Course-Student-Service) |
| 📘 [`course-service`](https://github.com/CODERonak/Student-Course-Course-Service) | Course info | [GitHub](https://github.com/CODERonak/Student-Course-Course-Service) |
| 🧭 [`eureka-server`](https://github.com/CODERonak/Student-Course-Eureka-Server) | Service discovery | [GitHub](https://github.com/CODERonak/Student-Course-Eureka-Server) |
