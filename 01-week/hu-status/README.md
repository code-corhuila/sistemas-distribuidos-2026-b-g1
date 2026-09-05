# Weekly Status - Week 01

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Ximena Del Pilar Zambrano Chala
- GITHUB_USER: XimenaChala
- TEAM: G1
- SPRINT_GOAL: Define and organize the initial architecture, responsibilities, and development plan for the EduTrack distributed system.
<!-- CONFIG-END -->

## 1. User stories worked this week

| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-XXX-001 | Distributed Systems Foundations | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |
| HU-XXX-002 | Select real problem for MVP 1 (EduTrack) | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |
| HU-XXX-003 | Define PRD and functional/non-functional requirements | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |
| HU-XXX-004 | Define PDR: module division and team responsibilities | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |

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
- Studied delivery semantics: at-most-once, at-least-once and exactly-once processing.
- Reviewed idempotency, deduplication and the use of idempotency keys.
- Reviewed the use of Saga and compensation for distributed consistency.
- Studied Domain-Driven Design and bounded contexts.
- Studied hexagonal architecture and the relationship between domain, application, ports and adapters.
- Reviewed SOLID and Clean Code principles.
- Studied resilience patterns including Circuit Breaker, Retry, Timeout, Bulkhead, Saga, Outbox and CQRS.
- Reviewed the testing strategy: unit, integration, contract and E2E tests.
- Selected the real problem for MVP 1: **EduTrack**, a distributed platform for real-time school tracking for parents/guardians.
- Wrote the EduTrack PRD, including functional and non-functional requirements, bounded contexts, and core operations with their consistency and delivery-semantics requirements.
- Wrote the EduTrack PDR, dividing the system into five modules (Identity & Accounts, Academic Records, Attendance, Notifications, Communication) and defining the minimum deliverable, related user story, and functions for each module.
- Defined the synchronous (REST) and asynchronous (events) communication strategy between modules.
- Designed the main distributed flows: grade registration (`GradeCreated`) and absence registration (`StudentAbsent`), including idempotency handling.
- Proposed the Git branching strategy per user story (`feature/HU-XXX → develop → main`).
- Defined shared team responsibilities: contract definition, PR review, module integration, E2E testing.
- Prepared the individual weekly HU-STATUS deliverable in the fork.

## 3. Blockers and risks

- No major blockers identified during the initial foundation and design review.
- Module contracts (event/endpoint names, payloads, error handling) still need to be formally agreed upon and documented before implementation starts.
- The specific messaging technology for asynchronous events has not yet been selected.
- Integration between independently developed modules may generate conflicts if contracts change mid-sprint.
- Distributed patterns such as Outbox and idempotency still require implementation and testing.
- Risk: notification delivery (at-most-once) may occasionally lose a push notification; this is an accepted trade-off and must be documented in an ADR.
- Risk: parent-child account sync across schools requires strong/linearizable consistency; incorrect implementation could duplicate or lose critical identity data.

## 4. Plan for next week

- Confirm the module/responsibility assigned to each team member based on the PDR.
- Finalize and formally document API and event contracts between modules (payload, event ID, error handling).
- Set up the base project structure following DDD and hexagonal architecture for the assigned module.
- Start implementing the first assigned user story.
- Add unit tests for the first domain rules.
- Create the corresponding HU branch and Pull Request.
- Set up Testcontainers for integration testing.
- Validate communication between the first integrated modules.