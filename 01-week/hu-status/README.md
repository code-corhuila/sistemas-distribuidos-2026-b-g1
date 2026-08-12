# Weekly Status - Week 01

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Ximena Del Pilar Zambrano Chala
- GITHUB_USER: XimenaChala
- TEAM: G1
- SPRINT_GOAL: Establish the foundations for the distributed systems project and apply professional engineering practices to MVP 1.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-XXX-001 | Distributed Systems Foundations | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |
| HU-XXX-002 | Select real problem for MVP 1 (EduTrack) | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |

## 2. My individual contribution

- Reviewed the foundations of distributed systems and the changes introduced by communication over an unreliable network.
- Studied the eight fallacies of distributed computing.
- Reviewed synchronous and asynchronous system models.
- Reviewed failure models: crash-stop, crash-recovery, omission and Byzantine.
- Studied logical time, causality and the happens-before relationship.
- Reviewed Lamport clocks and vector clocks.
- Studied the consistency spectrum: strong/linearizable, sequential, causal and eventual consistency.
- Reviewed CAP and PACELC and their consistency/availability/latency trade-offs.
- Studied replication, partitioning/sharding and quorum reads/writes.
- Reviewed consensus, FLP impossibility and the Raft model.
- Reviewed synchronous and asynchronous communication.
- Studied delivery semantics: at-most-once, at-least-once and exactly-once processing.
- Reviewed idempotency, deduplication and the use of idempotency keys.
- Analyzed the distributed checkout scenario involving Orders, Inventory and Payments during a network partition.
- Reviewed the use of Saga and compensation for distributed consistency.
- Studied Domain-Driven Design and bounded contexts.
- Reviewed entities, value objects, aggregates and domain events.
- Studied hexagonal architecture and the relationship between domain, application, ports and adapters.
- Reviewed SOLID and Clean Code principles.
- Studied resilience patterns including Circuit Breaker, Retry, Timeout, Bulkhead, Saga, Outbox and CQRS.
- Reviewed the testing strategy: unit, integration, contract and E2E tests.
- Reviewed Testcontainers and coverage requirements.
- Reviewed Scrum, user stories, acceptance criteria, Definition of Ready and Definition of Done.
- Reviewed the Git workflow: `develop → qa → main`.
- Reviewed the per-environment HU branch and Pull Request strategy.
- Reviewed ADRs as a mechanism for documenting architecture decisions.
- Selected the real problem for MVP 1: **EduTrack**, a distributed platform for real-time school tracking (grades, attendance, notifications) for parents/guardians.
- Defined the initial bounded contexts: Academic Records, Attendance, Notifications, Communication and Identity/Accounts.
- Defined consistency levels and delivery semantics for the core operations of MVP 1 (grade registration, attendance marking, push notifications, parent-child account sync).
- Designed an initial Saga/Outbox flow for the "grade published → notification sent" scenario to handle partial failures without losing or duplicating events.
- Drafted initial user stories with testable acceptance criteria for the selected problem.
- Prepared the individual weekly HU-STATUS deliverable in the fork.

## 3. Blockers and risks

- No major blockers identified during the initial foundation review.
- Distributed systems introduce risks related to network partitions, message duplication, latency and independent failures.
- Future implementations must preserve the DDD and hexagonal architecture boundaries.
- Consistency and delivery semantics must be selected according to the requirements of each core operation.
- Consumers must be designed to handle message redelivery through idempotency and deduplication.
- Tests and runtime validation are required before considering a user story complete.
- The required Git branch and Pull Request flow must be maintained for each environment.
- Evidence links must be maintained for the automated weekly evaluation.
- Risk: notification delivery (at-most-once) may occasionally lose a push notification; this is an accepted trade-off and must be documented in an ADR.
- Risk: parent-child account sync across schools requires strong/linearizable consistency; incorrect implementation could duplicate or lose critical identity data.

## 4. Plan for next week

- Form and coordinate the project team.
- Finalize and prioritize the product backlog for EduTrack.
- Write full user stories with Gherkin-style acceptance criteria for MVP 1 core operations.
- Design the hexagonal architecture (domain, application, ports, adapters) for the Academic Records bounded context.
- Document architecture decisions through ADRs (consistency choices, delivery semantics, Saga/Outbox pattern).
- Set up the base project structure following DDD and hexagonal architecture.
- Prepare the required HU branches according to the environment workflow (hu-xxx-dev -> develop, ...).
- Add unit and integration tests for the first implemented functionality.
- Set up Testcontainers for integration testing.

## 5. Compliance self-check

- [x] Conventional Commits - `type(scope): summary`
- [x] Per-environment HU branch + PR to that environment (hu-xxx-dev -> develop, ...)
- [x] Testable acceptance criteria
- [ ] Tests added/updated (unit / integration)
- [x] DDD / hexagonal boundaries respected (domain has no I/O)
- [x] No secrets; config via environment variables

## 6. Evidence links

- Repository: https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1
- Week 01: https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1/tree/main/01-week
- HU-STATUS: https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1/tree/main/01-week/hu-status

## 7. Unit 1 - Foundations Diagram

```mermaid
flowchart TD
    A["UNIT 1 · FOUNDATIONS<br/>DISTRIBUTED SYSTEMS"] --> B["1. DISTRIBUTED SYSTEMS"]

    B --> C["State · Time · Failure"]
    C --> C1["No shared state"]
    C --> C2["No global clock"]
    C --> C3["Independent failures"]
    C --> C4["8 fallacies"]

    C4 --> D["2. SYSTEM & FAILURE MODELS"]
    D --> D1["Synchronous / Asynchronous"]
    D --> D2["Crash-stop"]
    D --> D3["Crash-recovery"]
    D --> D4["Omission"]
    D --> D5["Byzantine"]

    D5 --> E["3. LOGICAL TIME"]
    E --> E1["Causality"]
    E --> E2["Happens-before"]
    E --> E3["Lamport clocks"]
    E --> E4["Vector clocks"]

    E4 --> F["4. CONSISTENCY"]
    F --> F1["Strong / Linearizable"]
    F --> F2["Sequential"]
    F --> F3["Causal"]
    F --> F4["Eventual"]
    F --> F5["CAP / PACELC"]

    F5 --> G["5. REPLICATION & CONSENSUS"]
    G --> G1["Replication"]
    G --> G2["Sharding"]
    G --> G3["Quorum: R + W > N"]
    G --> G4["Consensus / Raft"]
    G --> G5["FLP"]

    G5 --> H["6. COMMUNICATION"]
    H --> H1["Synchronous"]
    H --> H2["Asynchronous"]
    H --> H3["At-most-once"]
    H --> H4["At-least-once"]
    H --> H5["Idempotency + Dedup"]
    H --> H6["Exactly-once processing"]

    H6 --> I["7. DISTRIBUTED FAILURE"]
    I --> I1["Orders"]
    I1 --> I2["Reserve Inventory"]
    I2 --> I3["Charge Payments"]
    I3 --> I4["Confirm Order"]
    I3 --> I5["Failure → Compensate → Release Stock"]
    I4 --> J["SAGA + IDEMPOTENCY"]

    J --> K["8. PROFESSIONAL ENGINEERING"]

    K --> L["DDD"]
    L --> L1["Bounded Contexts"]
    L --> L2["Entities"]
    L --> L3["Value Objects"]
    L --> L4["Aggregates"]
    L --> L5["Domain Events"]

    L5 --> M["HEXAGONAL ARCHITECTURE"]
    M --> M1["Domain"]
    M --> M2["Application"]
    M --> M3["Ports"]
    M --> M4["Adapters"]
    M4 --> M5["Adapters → Application → Domain"]

    M5 --> N["SOLID + CLEAN CODE"]
    N --> N1["SRP"]
    N --> N2["DIP"]
    N --> N3["OCP / ISP"]
    N --> N4["Clean Code"]

    N4 --> O["RESILIENCE"]
    O --> O1["Circuit Breaker"]
    O --> O2["Retry + Backoff"]
    O --> O3["Timeout / Bulkhead"]
    O --> O4["Saga"]
    O --> O5["Outbox"]
    O --> O6["CQRS"]

    O6 --> P["TESTING"]
    P --> P1["Unit"]
    P --> P2["Integration"]
    P --> P3["Contract"]
    P --> P4["E2E"]
    P --> P5["Testcontainers"]

    P5 --> Q["SCRUM + GIT + ADR"]
    Q --> Q1["Weekly Sprints"]
    Q --> Q2["User Stories"]
    Q --> Q3["Acceptance Criteria"]
    Q --> Q4["DoD"]
    Q --> Q5["develop → qa → main"]
    Q --> Q6["ADR"]

    Q6 --> R["WEEKLY HU-STATUS"]
    R --> R1["Fork personal"]
    R --> R2["01-week/hu-status/README.md"]
    R --> R3["HU + Contribution"]
    R --> R4["Evidence + Compliance"]

    R4 --> S["FINAL GOAL"]
    S --> S1["Consistency"]
    S --> S2["Resilience"]
    S --> S3["Idempotency"]
    S --> S4["Testing"]
    S --> S5["Professional Distributed System"]
```