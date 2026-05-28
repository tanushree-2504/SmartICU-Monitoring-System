# SmartICU Monitoring System

A full-stack **Smart ICU Monitoring System** built using **Spring Boot Microservices Architecture**, integrating **AI-based patient prediction**, **JWT Authentication**, **API Gateway**, **Eureka Service Discovery**, **PostgreSQL**, and **PDF Report Generation**.

---

# 🚀 Features

## ✅ Core Features

* Add ICU patients
* Monitor patient vitals
* AI-based critical condition prediction
* Download patient reports as PDF
* Dashboard using Thymeleaf
* REST APIs for patient management

---

# 🧠 AI Features

The AI Service predicts patient condition based on:

* Heart Rate
* Oxygen Level
* Blood Pressure
* Disease
* Age

Prediction Categories:

* Stable
* Monitoring
* Critical

---

# 🔐 Security Features

* JWT Authentication
* Protected APIs
* Token-based authorization
* API Gateway security integration

---

# 🏗️ Microservices Architecture

The project is divided into multiple services:

## 1️⃣ Eureka Server

Service discovery server.

Runs on:

```text
http://localhost:8761
```

---

## 2️⃣ SmartICU Backend Service

Main ICU management backend.

Runs on:

```text
http://localhost:8080
```

Responsibilities:

* Patient CRUD
* Dashboard rendering
* PDF generation
* AI communication

---

## 3️⃣ AI Service

Handles AI prediction logic.

Runs on:

```text
http://localhost:8081
```

Responsibilities:

* ICU prediction logic
* Risk analysis

---

## 4️⃣ API Gateway

Single entry point for all services.

Runs on:

```text
http://localhost:9095
```

Responsibilities:

* Routing
* JWT validation
* Secure communication

---

# 🛠️ Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Cloud
* Spring Data JPA
* Thymeleaf

---

## Database

* PostgreSQL

---

## Microservices

* Eureka Server
* API Gateway
* RestTemplate
* Load Balancing

---

## Security

* JWT Authentication
* Spring Security

---

## AI Integration

* AI Prediction Microservice
* REST API communication

---

## Reporting

* iText PDF Generator

---

# 📂 Project Structure

```text
smarticu/
│
├── eureka-server/
│
├── api-gateway/
│
├── ai-service/
│
└── smarticu/
```

---

# ⚙️ Installation & Setup

# 1️⃣ Clone Repository

```bash
git clone <your-github-repo-url>
```

---

# 2️⃣ Setup PostgreSQL

Create database:

```sql
CREATE DATABASE smarticu;
```

---

# 3️⃣ Configure application.properties

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/smarticu
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```

---

# 4️⃣ Run Services in Order

## Start Eureka Server

Run:

```text
EurekaServerApplication.java
```

---

## Start SmartICU Backend

Run:

```text
SmarticuApplication.java
```

---

## Start AI Service

Run:

```text
AiServiceApplication.java
```

---

## Start API Gateway

Run:

```text
ApiGatewayApplication.java
```

---

# 🌐 Verify Services

Open:

```text
http://localhost:8761
```

You should see:

* SMARTICU-SERVICE
* AI-SERVICE
* API-GATEWAY

---

# 📡 API Endpoints

## Patient APIs

### Get All Patients

```http
GET /patient/all
```

---

### Add Patient

```http
POST /patient/add
```

---

### Test API

```http
GET /patient/test
```

---

# 📄 PDF Report

Download patient report:

```http
GET /download/{id}
```

---

# 🔐 JWT Authentication

Authentication Flow:

1. Register User
2. Login
3. Receive JWT Token
4. Use token in Authorization header

Example:

```text
Authorization: Bearer <token>
```

---

# 🧪 Testing

## Test Critical Prediction

Use:

* Oxygen Level = 80
* Heart Rate = 150

Expected Result:

```text
Critical
```

---

# 📌 Future Enhancements

* React Frontend
* WebSockets for live monitoring
* Dockerization
* Cloud Deployment
* Role-based access
* Prometheus & Grafana Monitoring
* ML-based prediction models
* Email/SMS alerts

---

# 👩‍💻 Developed By

TANUSHREE BORKAR

---

# 📜 License

This project is developed for educational and research purposes.
