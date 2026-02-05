**ZOMATO MICROSERVICES SYSTEM**

Spring Boot | Microservices Architecture
================================================

PROJECT OVERVIEW
-----------------------------------------------------
This project is a real-time Food Delivery System developed 
using Spring Boot and Microservices Architecture.

It simulates how platforms like **Zomato / Swiggy** work internally
by using multiple independent microservices that communicate 
with each other using REST APIs and OpenFeign.

Each service is a standalone Spring Boot application, designed
to demonstrate real-world distributed system behavior.

--------------------------------------------------------
CORE CONCEPTS DEMONSTRATED
--------------------------------------------------------
• Microservices Architecture  
• API Gateway (Centralized Routing)  
• OpenFeign (Service-to-Service Communication)  
• RESTful APIs  
• Layered Architecture (Controller → Service → Repository)  
• Distributed System Design  

--------------------------------------------------------
ARCHITECTURE DESIGN
--------------------------------------------------------
The system consists of the following independent services:

• API Gateway – Central entry point for all client requests  
• User Service – Manages user registration and user details  
• Restaurant Service – Manages restaurants and food items  
• Order Service – Handles order placement and processing  
• Payment Service – Simulates payment transactions  
• Delivery Service – Tracks delivery status  
• Notification Service – Sends order confirmations  

All services run on different ports and communicate using
Feign Clients through REST APIs.

--------------------------------------------------------
REQUEST FLOW (HOW IT WORKS)
--------------------------------------------------------
Client → API Gateway → Target Microservice → Response

Example: Place Order Flow

1. Client sends request:
   http://localhost:8081/orders/place

2. API Gateway routes the request to Order Service

3. Order Service communicates internally with:
   • User Service – Validate user
   • Restaurant Service – Check food availability
   • Payment Service – Process payment
   • Delivery Service – Assign delivery
   • Notification Service – Send confirmation

4. Final response is returned to the client via API Gateway

This demonstrates real-world inter-service communication.

--------------------------------------------------------
TECHNOLOGIES USED
--------------------------------------------------------
• Java 17  
• Spring Boot  
• Spring Cloud Gateway  
• OpenFeign  
• Maven  
• REST APIs  
• Postman (API Testing)  

--------------------------------------------------------
KEY FEATURES IMPLEMENTED
--------------------------------------------------------
✔ Centralized API Routing using API Gateway  
✔ Service-to-Service Communication using Feign  
✔ Independent Service Deployment  
✔ Clean and Maintainable Code Structure  
✔ Layered Architecture  
✔ Microservices Best Practices  
✔ Real-world Food Delivery Use Case Simulation  

--------------------------------------------------------
PROJECT STRUCTURE
--------------------------------------------------------
Zomato-Microservices-System
|
|-- api-gateway
|-- user-service
|-- restaurant-service
|-- order-service
|-- payment-service
|-- delivery-service
|-- notification-service

Each service contains:
• Controller Layer  
• Service Layer  
• Repository Layer (if applicable)  
• Model Classes  
• Configuration Files  

--------------------------------------------------------
PORT DETAILS
--------------------------------------------------------
API Gateway        : 8081  
User Service       : 8082  
Restaurant Service : 8083  
Order Service      : 8084  
Payment Service    : 8085  
Delivery Service   : 8086  
Notification       : 8087  

--------------------------------------------------------
WHY THIS PROJECT IS IMPORTANT
--------------------------------------------------------
This project demonstrates strong understanding of:

• Enterprise Application Development  
• Distributed Systems  
• Microservices Communication  
• Scalable Backend Architecture  
• API Gateway Implementation  
• Production-Level Design Thinking  

It reflects hands-on experience in building a scalable,
industry-style backend system.
