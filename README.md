 🚚 Smart Logistics and Supply Chain Management System

An enterprise-level, event-driven microservices project built using Java, Spring Boot, Kafka, and AWS. It simulates a backend logistics system like Flipkart or Amazon, with real-time order, inventory, vendor, delivery, notification, and analytics handling.

---

📌 Features

✅ Event-driven microservices using Apache Kafka  
✅ Vendor restocking and Inventory management  
✅ Order placement and real-time delivery assignment  
✅ Notification via AWS SNS (email/SMS)  
✅ Kafka-based analytics dashboard logs  
✅ RESTful APIs with Swagger Docs  
✅ Docker & AWS-ready project structure

---

 🧰 Tech Stack

| Layer         | Tools / Technologies                          |
|---------------|-----------------------------------------------|
| Backend       | Java 17, Spring Boot, Spring Web, Spring JPA |
| Messaging     | Apache Kafka                                 |
| API Gateway   | (Optional) Spring Cloud Gateway              |
| DB            | MySQL, Redis                                 |
| Monitoring    | AWS SNS, Swagger                             |
| DevOps        | Jenkins , Docker                             |
| Auth          | Spring Security, JWT                         |

---

🧱 Microservices Breakdown

| Service              | Port  | Responsibility                                |
|----------------------|-------|-----------------------------------------------|
| Inventory Service     | 8081  | Manage product stock and availability         |
| Order Service         | 8082  | Place orders and emit Kafka events            |
| Delivery Service      | 8083  | Assign delivery upon order placement          |
| Notification Service  | 8084  | Send SMS/email notifications via AWS SNS      |
| Vendor Service        | 8085  | Register vendors and restock inventory        |
| Analytics Service     | 8086  | Log all system events for reporting           |
| Auth Service          | 8087 | JWT-based login and token generation           |

---



## 🔁 Kafka Event Flow

Order Service
     ↓
[ Kafka Topic: order-events ]
     ↓
Delivery Service → Notification Service → Analytics Service
