Status: Work in Progress / Active Development

# task-organizer-architecture
A full-stack task manager built to show how Java, Python, and C++ work together. Instead of messy if/then code, it uses clean design patterns to handle task states. It connects a secure Java backend to lightweight microservices, all moving toward a scalable cloud setup. Follow my 12-month roadmap below to see it grow!

##Project Roadmap

### Phase 1: Core Domain & State Machine Logic
- [x] Phase 1.1: Project Architecture & Repository Setup
- [x] Phase 1.2: Shift Profile & Task Schema Definition
- [x] Phase 1.3: Task Data Models & State Transition Logic
- [ ] Phase 1.4: State Machine Unit Testing (JUnit 5)

### Phase 2: Core Web Application & API Layer (Months 4–6)
- [ ] Develop the user interface (Frontend) using a clean web ecosystem.
- [ ] Connect the frontend to the Java Spring Boot REST API.
- [ ] Implement secure user authentication and session management.
- [ ] Refactor code using design patterns (Singleton, State) to minimize conditional complexity.

### Phase 3: Multi-Language Microservices (Months 7–9)
- [ ] **Python Integration:** Build a microservice for data analysis (e.g., tracking user productivity metrics or task completion trends).
- [ ] **C++ Integration:** Develop a high-performance, low-latency background utility (e.g., local file backup or system resource monitor).
- [ ] Establish secure Inter-Process Communication (IPC) and network APIs between microservices.

### Phase 4: Cloud Migration, DevOps, & Optimization (Months 10–12)
- [ ] Containerize the application components using Docker.
- [ ] Migrate the application to a cloud environment (AWS/Linux backend).
- [ ] Implement a serverless architecture for event-driven features (like email notifications on task deadlines).
- [ ] Finalize documentation, optimize database queries, and prepare for deployment.


# Project Roadmap & Status

- **Phase 1.1: Architecture & Schema Design** —  **Complete** (July 5, 2026)
  - Designed core database tables and shift logic schemas.
  - Saved technical specifications in `docs/schema.sql`.
- **Phase 1.2: Core Java Spring Boot Backend** —  **Complete** (July 7th, 2026)
  - Initializing repository framework and folder structures.
- **Phase 1.3: Data Models & Shift Logic** —  **Complete** (Target: Aug 31, 2026)
  - **Phase 1.4: Local Database Integration** —  *In progress* (Target: Oct 4, 2026)
