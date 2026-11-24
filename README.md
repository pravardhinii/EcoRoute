# EcoRoute — Dynamic Carbon-Optimized Supply Chain Routing Engine

EcoRoute is a multi-module Java 17 and Spring Boot backend capstone project focused on calculating and optimizing multi-modal supply chain transit emissions rather than only logging static emissions after transit.

## Key Architecture & Concepts Covered
- **Multi-Module Maven Build:** Separates framework-agnostic business and calculation logic (`ecoroute-core`) from the Spring Boot web and persistence module (`ecoroute-api`).
- **Core Java, OOP & Defensive Coding:** Uses the Strategy pattern (`RoutingStrategy`, `GreenestRouteStrategy`, `FastestRouteStrategy`) to support the Open/Closed Principle, `java.util.Optional` for missing values, and custom exceptions (`CarbonThresholdExceededException`).
- **Spring Boot Configuration & Scopes:** Binds externalized settings from `application.yml` via `@ConfigurationProperties` (`CarbonProperties`) and configures beans with `@Configuration` and `@Bean` scopes.
- **Persistence & Transactions:** Maps entities with Spring Data JPA / Hibernate (`ShipmentEntity`), defines repository query methods (`findByTotalEmissionsLessThan`), and manages transactions with `@Transactional`.
- **REST API, Validation & Global Errors:** Uses `@RestController`, DTOs (`ShipmentRequestDto`), Bean Validation (`@Valid`, `@NotBlank`, `@Positive`), and centralized error handling with `@ControllerAdvice`.
- **Testing:** Covers core calculations, service logic, and web endpoints using JUnit 5, Mockito, and `@WebMvcTest` / `MockMvc`.

## Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot (Spring Web, Spring Data JPA, Validation, Spring Test)
- **Build Tool:** Apache Maven
- **Database:** H2 In-Memory Database
- **Testing:** JUnit 5, Mockito, MockMvc

