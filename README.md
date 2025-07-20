# School ERP CRM Microservices System

This project is a modular, scalable, and fault-tolerant School ERP/CRM system based on a microservices architecture. Each core function is implemented as an independent Spring Boot (Java 17) microservice, with PostgreSQL as the database (schema-per-tenant for multi-tenancy). All services are containerized and orchestrated using Docker Compose.

## Microservices
- **user-access-management**: User & Access Management
- **tenant-management**: Tenant Management
- **authorization-service**: Authorization Service
- **admission-onboarding**: Admission & Onboarding
- **scheduling-attendance**: Scheduling & Attendance
- **fees-finance**: Fees & Finance
- **academic-management**: Academic Management
- **notification-event**: Notification/Event Service

Each service has its own database instance for logical isolation and can be scaled independently.

## Running the System

1. **Build all services**
   ```sh
   mvn clean install
   ```
   (Run from the root directory to build all modules)

2. **Start all services with Docker Compose**
   ```sh
   docker-compose up --build
   ```
   (This will build and start all microservices and their PostgreSQL databases)

3. **Access Services**
   - User Access Management: http://localhost:8081
   - Tenant Management: http://localhost:8087
   - Authorization Service: http://localhost:8088
   - Admission & Onboarding: http://localhost:8082
   - Scheduling & Attendance: http://localhost:8083
   - Fees & Finance: http://localhost:8084
   - Academic Management: http://localhost:8085
   - Notification/Event: http://localhost:8086

## Multi-Tenancy
Each service uses schema-per-tenant in PostgreSQL for logical isolation. You can extend the services to dynamically create and manage schemas per tenant.

## Requirements
- Java 17+
- Maven 3.8+
- Docker & Docker Compose

## Development
Each service is a standard Spring Boot Maven project. You can develop and test them independently or as a full stack.

---
For more details, see the source code in each service's directory.
# school_erp_crm