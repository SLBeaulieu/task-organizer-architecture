Status: Work in Progress / Active Development

# task-organizer-architecture
A full-stack task manager built to show how Java, Python, and C++ work together. Instead of messy if/then code, it uses clean design patterns to handle task states. It connects a secure Java backend to lightweight microservices, all moving toward a scalable cloud setup. Follow my 12-month roadmap below to see it grow!

##Project Roadmap

### Phase 1: Core Domain & State Machine Logic
- [x] Phase 1.1: Project Architecture & Repository Setup
- [x] Phase 1.2: Shift Profile & Task Schema Definition
- [x] Phase 1.3: Task Data Models & State Transition Logic
- [x] Phase 1.4: State Machine Unit Testing (JUnit 5)

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

## Phase 2 Roadmap: Core Web Application & API Layer (Months 4–6)

| Milestone | Status |
| :--- | :--- |
| **Phase 2.1: Local Database Integration (PostgreSQL & JPA)** | Due: September 27th, 2026 |
| **Phase 2.2: State Pattern Refactoring & REST API** | Due: Oct 11th, 2026 |
| **Phase 2.3: User Authentication & Spring Security** | Due: Oct 25th, 2026 |
| **Phase 2.4: Frontend Task Board UI** | Due: November 8th, 2026 |
| **Phase 2.5: Full-Stack Integration & End-to-End Testing** | Due: November 22nd, 2026 |

---

### Key Deliverables

- **Phase 2.1:** Hook up PostgreSQL, configure Spring Data JPA, and persist the `Task` entity.
- **Phase 2.2:** Refactor `TaskManager` using the State Pattern and expose REST endpoints (`/api/tasks`).
- **Phase 2.3:** Add Spring Security, user login/registration, and protect routes.
- **Phase 2.4:** Build a clean frontend dashboard with task columns (`TODO`, `IN_PROGRESS`, `COMPLETED`).
- **Phase 2.5:** Connect frontend to backend APIs, handle CORS, and verify end-to-end flows.
