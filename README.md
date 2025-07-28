---

# 🔗 Enrollment-Service – Enrollment Management Microservice

---

## 🚧 Status: In Development

> ⚠️ **This microservice is currently under active development.**
> Some features may be incomplete, unstable, or subject to change.
> It's a simple microservice project.
> Purpose is to understand the fundamentals or basics of microservices.

---

## 🎯 Objective

The **Enrollment-Service** handles the logic and data related to **student enrollments in courses**. It connects students to courses, maintains enrollment statuses, and provides APIs to drop or complete a course. It communicates with `student-service` and `course-service` for validation and data consistency.

---

## ✨ Features

* **Student-Course Enrollment:** Enroll students into available courses.
* **Status Management:** Drop or mark enrollment as completed.
* **Inter-Service Communication:** Validates student and course IDs using other services.
* **DTO Validation:** Ensures clean input and consistent data across endpoints.

---

## 🛠️ Technologies Used

* **Spring Boot** – Java microservice framework
* **Spring Security** – Role-based and JWT-secured authentication
* **Spring Data JPA** – Simplified data persistence
* **MySQL** – Relational database
* **Java 17+** – Modern Java features and performance
* **Lombok** – Reduces boilerplate code
* **Feign/WebClient** – REST-based inter-service communication
* **MapStruct** – DTO ↔ Entity mappers

---

## 📦 Project Structure

```
enrollment-service/
├── controller/EnrollmentController.java     # API endpoints
├── dto/                                     # Request & response DTOs
├── entity/Enrollment.java                   # JPA entity
├── repository/EnrollmentRepository.java     # Data access layer
├── service/EnrollmentService.java           # Core business logic
├── client/                                  # Feign clients for other services
│   ├── StudentClient.java
│   └── CourseClient.java
├── application.properties                   # Configuration
└── pom.xml                                  # Maven dependencies
```

---

### 📚 API Endpoints

| Method | Endpoint                     | Description                   |
| ------ | ---------------------------- | ----------------------------- |
| `POST` | `/enrollments`               | Enroll a student in a course  |
| `GET`  | `/enrollments/student/{id}`  | Get enrollments by student ID |
| `GET`  | `/enrollments/course/{id}`   | Get enrollments by course ID  |
| `PUT`  | `/enrollments/{id}/drop`     | Drop an active enrollment     |
| `PUT`  | `/enrollments/{id}/complete` | Mark enrollment as completed  |

---

## 🌐 API Integration

This service communicates with:

* 👤 \[`student-service`]\(almost complete): Validates student IDs before enrollment
* 📘 \[`course-service`]\(coming soon): Validates course IDs before enrollment

Inter-service calls are made using **Feign** or **WebClient** depending on configuration.

---

## 🔗 Related Microservices

| Service                               | Description                  | Repository |
| ------------------------------------- | ---------------------------- | ---------- |
| 🎓 \[`student-service`]\(coming soon) | Manages student profile info |            |
| 📘 \[`course-service`]\(coming soon)  | Course management and CRUD   |            |
| 🔗 `enrollment-service`               | *You are here*               |            |

---

## 🧩 Database

This service uses a dedicated **MySQL** database for storing enrollment records.
Each microservice in the system uses its own schema or database instance to ensure modularity and independence.

---