**ZOMATO MICROSERVICES SYSTEM**

**Spring Boot | Microservices Architecture | API Gateway | OpenFeign
PROJECT OVERVIEW**

This project is a real-time Food Delivery System developed using Spring Boot Microservices Architecture.
The system is designed to simulate how platforms like **Zomato / Swiggy** work internally using multiple independent services.
Each service is developed as a separate Spring Boot application and communicates through REST APIs.

**The project demonstrates practical implementation of:**
**Microservices Architecture**
API Gateway (Centralized Routing)
OpenFeign Client (Service-to-Service Communication)
RESTful APIs
Layered Architecture (Controller → Service → Repository)
Distributed System Design

**ARCHITECTURE DESIGN**
The system contains the following services:
API Gateway – Central entry point for all client requests
User Service – Manages user registration and details
Restaurant Service – Manages restaurant data and food items
Order Service – Handles order placement and processing
Payment Service – Simulates payment transactions
Delivery Service – Handles delivery status tracking
Notification Service – Sends order confirmation notifications
All services run independently on different ports and communicate via Feign Clients.

**HOW REQUEST FLOW WORKS**
Client → API Gateway → Target Microservice → Response
Example Flow (Place Order):
Client hits:
http://localhost:8081/orders/place
API Gateway routes request to Order Service
Order Service internally calls:
User Service (to validate user)
Restaurant Service (to check food availability)
Payment Service (to process payment)
Delivery Service (to assign delivery)
Notification Service (to send confirmation)
Final response returned via API Gateway
This demonstrates real-world Inter-Service Communication.

**TECHNOLOGIES USED**
Java 17
Spring Boot
Spring Cloud Gateway
OpenFeign
Maven
REST APIs
Postman (API Testing)

KEY FEATURES IMPLEMENTED
✔ Centralized API Routing using API Gateway
✔ Service-to-Service Communication using Feign
✔ Independent Service Deployment
✔ Clean Code Structure
✔ Layered Architecture
✔ Microservices Best Practices
✔ Real-world Use Case Simulation

**PROJECT STRUCTURE**
Zomato-Microservices-System
│
├── api-gateway
├── user-service
├── restaurant-service
├── order-service
├── payment-service
├── delivery-service
└── notification-service

**Each service contains:**
Controller Layer
Service Layer
Repository Layer (if applicable)
Model Classes

Configuration File
PORT DETAILS
API Gateway – 8081
User Service – 8082
Restaurant Service – 8083
Order Service – 8084
Payment Service – 8085
Delivery Service – 8086
Notification Service – 8087

**WHY THIS PROJECT IS IMPORTANT**
This project shows understanding of:
Enterprise Application Development
Distributed Systems
Microservices Communication
Scalable Architecture
API Gateway Implementation
Production-Level Design Thinking
It demonstrates hands-on experience in building a scalable backend system similar to real industry projects.

**AUTHOR**
Rajesh Patil
Full Stack Developer
Java | Spring Boot | Microservices
