# Estado Semanal - Semana 01

<!-- CONFIG-START - debe coincidir con tu repo de perfil (usuario/usuario) CONFIG -->
- NOMBRE_COMPLETO: Ximena Del Pilar Zambrano Chala
- USUARIO_GITHUB: XimenaChala
- EQUIPO: G1
- OBJETIVO_SPRINT: Establecer las bases del proyecto de sistemas distribuidos y aplicar prácticas profesionales de ingeniería al MVP 1.
<!-- CONFIG-END -->

## 1. Historias de usuario trabajadas esta semana

| ID HU | Título | Estado (todo/doing/done) | Evidencia (URL de PR o commit) |
|---|---|---|---|
| HU-XXX-001 | Fundamentos de Sistemas Distribuidos | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |
| HU-XXX-002 | Selección del problema real para MVP 1 (EduTrack) | done | https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1 |

## 2. Mi contribución individual

- Revisé los fundamentos de los sistemas distribuidos y los cambios que introduce la comunicación sobre una red no confiable.
- Estudié las ocho falacias de la computación distribuida.
- Revisé los modelos de sistema síncronos y asíncronos.
- Revisé los modelos de falla: crash-stop, crash-recovery, omisión y bizantino.
- Estudié el tiempo lógico, la causalidad y la relación happens-before.
- Revisé los relojes de Lamport y los relojes vectoriales.
- Estudié el espectro de consistencia: fuerte/linealizable, secuencial, causal y eventual.
- Revisé CAP y PACELC, y sus trade-offs entre consistencia, disponibilidad y latencia.
- Estudié replicación, particionamiento/sharding y lecturas/escrituras por quorum.
- Revisé consenso, la imposibilidad de FLP y el modelo Raft.
- Revisé la comunicación síncrona y asíncrona.
- Estudié las semánticas de entrega: at-most-once, at-least-once y exactly-once.
- Revisé idempotencia, deduplicación y el uso de claves de idempotencia.
- Analicé el escenario de checkout distribuido entre Orders, Inventory y Payments durante una partición de red.
- Revisé el uso de Saga y compensación para consistencia distribuida.
- Estudié Domain-Driven Design y bounded contexts.
- Revisé entidades, value objects, aggregates y domain events.
- Estudié la arquitectura hexagonal y la relación entre dominio, aplicación, puertos y adaptadores.
- Revisé los principios SOLID y Clean Code.
- Estudié patrones de resiliencia incluyendo Circuit Breaker, Retry, Timeout, Bulkhead, Saga, Outbox y CQRS.
- Revisé la estrategia de testing: pruebas unitarias, de integración, de contrato y E2E.
- Revisé Testcontainers y los requisitos de cobertura.
- Revisé Scrum, historias de usuario, criterios de aceptación, Definition of Ready y Definition of Done.
- Revisé el flujo de Git: `develop → qa → main`.
- Revisé la estrategia de branches por ambiente y Pull Requests por HU.
- Revisé los ADRs como mecanismo para documentar decisiones de arquitectura.
- Seleccioné el problema real para el MVP 1: **EduTrack**, una plataforma distribuida de seguimiento escolar en tiempo real (calificaciones, asistencia, notificaciones) para padres/tutores.
- Definí los bounded contexts iniciales: Academic Records, Attendance, Notifications, Communication e Identity/Accounts.
- Definí los niveles de consistencia y semánticas de entrega para las operaciones core del MVP 1 (registro de calificaciones, marcado de asistencia, notificaciones push, sincronización de cuentas padre-hijo).
- Diseñé un flujo inicial de Saga/Outbox para el escenario "calificación publicada → notificación enviada", para manejar fallas parciales sin perder ni duplicar eventos.
- Redacté los requerimientos funcionales y no funcionales, y las historias de usuario iniciales con criterios de aceptación verificables para el problema seleccionado.
- Preparé el entregable semanal individual HU-STATUS en el fork.

## 3. Bloqueos y riesgos

- No se identificaron bloqueos mayores durante la revisión inicial de fundamentos.
- Los sistemas distribuidos introducen riesgos relacionados con particiones de red, duplicación de mensajes, latencia y fallas independientes.
- Las implementaciones futuras deben preservar los límites de DDD y arquitectura hexagonal.
- La consistencia y las semánticas de entrega deben seleccionarse según los requerimientos de cada operación core.
- Los consumidores deben diseñarse para manejar reentrega de mensajes mediante idempotencia y deduplicación.
- Se requieren pruebas y validación en tiempo de ejecución antes de considerar completa una historia de usuario.
- Debe mantenerse el flujo requerido de branches de Git y Pull Requests por ambiente.
- Deben mantenerse los enlaces de evidencia para la evaluación semanal automatizada.
- Riesgo: la entrega de notificaciones (at-most-once) puede ocasionalmente perder una notificación push; este es un trade-off aceptado y debe documentarse en un ADR.
- Riesgo: la sincronización de cuentas padre-hijo entre colegios requiere consistencia fuerte/linealizable; una implementación incorrecta podría duplicar o perder datos críticos de identidad.

## 4. Plan para la próxima semana

- Formar y coordinar el equipo del proyecto.
- Finalizar y priorizar el product backlog de EduTrack.
- Escribir historias de usuario completas con criterios de aceptación estilo Gherkin para las operaciones core del MVP 1.
- Diseñar la arquitectura hexagonal (dominio, aplicación, puertos, adaptadores) para el bounded context de Academic Records.
- Documentar decisiones de arquitectura mediante ADRs (elección de consistencia, semánticas de entrega, patrón Saga/Outbox).
- Configurar la estructura base del proyecto siguiendo DDD y arquitectura hexagonal.
- Preparar los branches de HU requeridos según el flujo de trabajo por ambiente (hu-xxx-dev -> develop, ...).
- Agregar pruebas unitarias e de integración para la primera funcionalidad implementada.
- Configurar Testcontainers para pruebas de integración.

## 5. Autoevaluación de cumplimiento

- [x] Conventional Commits - `tipo(alcance): resumen`
- [x] Branch de HU por ambiente + PR a ese ambiente (hu-xxx-dev -> develop, ...)
- [x] Criterios de aceptación verificables
- [ ] Pruebas agregadas/actualizadas (unitarias / integración)
- [x] Límites de DDD / arquitectura hexagonal respetados (el dominio no tiene I/O)
- [x] Sin secretos; configuración vía variables de entorno

## 6. Enlaces de evidencia

- Repositorio: https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1
- Semana 01: https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1/tree/main/01-week
- HU-STATUS: https://github.com/XimenaChala/sistemas-distribuidos-2026-b-g1/tree/main/01-week/hu-status

## 7. Planteamiento del problema y requerimientos del software (EduTrack)

### 7.1 Planteamiento del problema

Hoy en día los padres de familia dependen de canales dispersos (WhatsApp, correo, plataformas propias de cada colegio) para dar seguimiento al progreso académico de sus hijos. No existe visibilidad en tiempo real sobre calificaciones, asistencia o comunicación con profesores, y las plataformas existentes (Google Classroom, Moodle) están diseñadas para profesores, no para padres. Las familias con más de un hijo, o hijos en distintos colegios, enfrentan aún mayor fragmentación.

**EduTrack** es un sistema distribuido que centraliza el seguimiento escolar (tareas, calificaciones, asistencia y comunicación) para padres/tutores, aplicando DDD, arquitectura hexagonal y patrones de resiliencia para garantizar consistencia ante fallas de red.

### 7.2 Requerimientos funcionales

| ID | Requerimiento |
|---|---|
| RF-01 | El sistema deberá permitir a los padres ver las calificaciones de sus hijos en tiempo casi real. |
| RF-02 | El sistema deberá registrar y mostrar la asistencia del estudiante, incluyendo faltas y tardanzas. |
| RF-03 | El sistema deberá enviar notificaciones push/email a los padres ante eventos académicos relevantes, sin duplicar alertas. |
| RF-04 | El sistema deberá permitir que una cuenta de padre esté vinculada a múltiples hijos, incluso en distintos colegios. |
| RF-05 | El sistema deberá permitir mensajería directa entre padres y profesores, organizada por materia. |
| RF-06 | El sistema deberá preservar el orden causal de los eventos de asistencia para un mismo estudiante. |
| RF-07 | El sistema deberá garantizar que una calificación no se pierda aunque el servicio de notificaciones no esté disponible. |
| RF-08 | El sistema deberá garantizar que el vínculo padre-hijo no se duplique ni se pierda durante la sincronización de cuentas. |

### 7.3 Requerimientos no funcionales

| ID | Requerimiento |
|---|---|
| RNF-01 | Consistencia: eventual para calificaciones y notificaciones; causal para asistencia; fuerte/linealizable para sincronización de identidad/cuentas. |
| RNF-02 | Confiabilidad: entrega at-least-once con claves de idempotencia para calificaciones y asistencia; exactly-once para sincronización de cuentas vía idempotencia + outbox. |
| RNF-03 | Resiliencia: el sistema debe aplicar Circuit Breaker, Retry con backoff, Timeout y Bulkhead para aislar fallas entre servicios. |
| RNF-04 | Disponibilidad: una falla en el servicio de Notifications no debe bloquear el registro de calificaciones o asistencia (degradación controlada). |
| RNF-05 | Mantenibilidad: cada bounded context debe seguir arquitectura hexagonal (dominio sin I/O) y principios SOLID. |
| RNF-06 | Testabilidad: se requieren pruebas unitarias, de integración (Testcontainers), de contrato y E2E antes de considerar completa una historia de usuario. |
| RNF-07 | Seguridad: sin secretos en el código; configuración vía variables de entorno. |
| RNF-08 | Observabilidad: los eventos de dominio relevantes (calificación publicada, asistencia registrada, notificación enviada/fallida) deben ser trazables de extremo a extremo. |

### 7.4 Bounded contexts (DDD)

| Bounded Context | Responsabilidad |
|---|---|
| Academic Records | Gestión de tareas y calificaciones |
| Attendance | Registro y seguimiento de asistencia |
| Notifications | Envío de alertas a padres (push, email) |
| Communication | Chat directo padre-profesor |
| Identity/Accounts | Gestión de cuentas de padres, hijos y colegios |

### 7.5 Operaciones core — consistencia y semánticas de entrega

| Operación | Consistencia | Semántica de entrega | Justificación |
|---|---|---|---|
| Registrar calificación nueva | Eventual | At-least-once + clave de idempotencia | No es crítico al milisegundo, pero no debe perderse |
| Marcar asistencia (falta) | Causal | At-least-once + deduplicación | El orden importa: no puede llegar "presente" después de "ausente" el mismo día |
| Enviar notificación push | Eventual | At-most-once | Mejor perder alguna ocasionalmente que duplicar spam |
| Sincronizar cuenta padre-hijo entre colegios | Fuerte/Linealizable | Exactly-once (idempotencia + outbox) | Dato crítico de identidad; no debe duplicarse ni perderse |

### 7.6 Alcance del MVP 1

**Dentro del alcance:** visualización de calificaciones, seguimiento de asistencia, notificaciones push/email, mensajería padre-profesor, cuentas multi-hijo/multi-colegio.

**Fuera del alcance (v2+):** predicción de riesgo académico con IA, calendario académico compartido, reportes mensuales automáticos en PDF.

![EduTrack system map](mapa.png)