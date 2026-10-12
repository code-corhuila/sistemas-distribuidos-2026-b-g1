<!-- HU-STATUS TEMPLATE - do NOT remove the <!-- ... --> markers or the table headers.
     Your weekly grade is read AUTOMATICALLY from this file:
       10-week/hu-status/README.md  (inside YOUR fork). English. -->

# Weekly Status - Week 10

<!-- CONFIG-START - must match your profile repo (username/username) CONFIG -->
- FULL_NAME: Wilkyn Julian Vargas Bahamon
- GITHUB_USER: julianvargasb
- TEAM: The illusionists
- SPRINT_GOAL: Document individual HU-24 reporting and navigation contributions and verify readiness against MVP 2 distributed-system release criteria.
<!-- CONFIG-END -->

## 1. User stories worked this week
| HU ID | Title | Status (todo/doing/done) | Evidence (PR or commit URL) |
|---|---|---|---|
| HU-24 | Expose ADMIN-only sales timeseries and orders-by-status reports | done | https://github.com/code-corhuila/opti-sales-api/commit/73393a36913f0bdcd697cfea243757b99b39a03d |
| HU-24 | Add ADMIN-only Reportes navigation route | done | https://github.com/code-corhuila/opti-front/commit/bb7f49877907d44fb2084331505c2149a530d159 |

## 2. My individual contribution
- Named as **co-author** in two HU-24 commits dated 2026-10-06; the primary GitHub author is BackSua. Git history does not identify which exact lines were written by each co-author.
- The Sales API change adds two ADMIN-only read endpoints, reporting use-case and JDBC logic, and new unit-test files.
- The frontend change adds an ADMIN-only `Reportes` link targeting `/sales/reports`.
- Prepared a retrospective technical explanation and two diagrams on 2026-10-11; these new documentation files are not yet committed or part of the original Week 10 contributions.
- The changes document code implementation. They do **not** establish that I deployed MVP 2, ran CI successfully or demonstrated saga/outbox failure recovery.

## 3. Blockers and risks
- Static backend read models for HU-24 must not be described as proof of full asynchronous CQRS projections.
- Evidence of green tests, environment promotions, release tag and injected-failure demonstration is still missing.
- Cross-service saga/outbox functionality is separate from the two HU-24 commits.

## 4. Plan for next week
- Collect the actual HU-24 PRs and CI execution results; verify report endpoint response and non-ADMIN access rejection.
- Review with the team whether release `v2.0.0`, QA promotion, saga compensation and outbox/idempotency tests are complete.
- Register any missing work in the backlog and attach verified links when available.

## 5. Compliance self-check
- [ ] Conventional Commits - `type(scope): summary` (no new status/documentation commit published yet)
- [ ] Per-environment HU branch + PR to that environment (not verified)
- [ ] Testable acceptance criteria (implementation acceptance not verified)
- [ ] Tests added/updated (unit / integration) (see week-specific evidence note)
- [ ] DDD / hexagonal boundaries respected (full verification pending)
- [ ] No secrets; config via environment variables (full verification pending)

## 6. Evidence links
- API co-authorship: https://github.com/code-corhuila/opti-sales-api/commit/73393a36913f0bdcd697cfea243757b99b39a03d
- Frontend co-authorship: https://github.com/code-corhuila/opti-front/commit/bb7f49877907d44fb2084331505c2149a530d159
- Architecture ADR-005/006 context (different author): https://github.com/code-corhuila/opti-docs/commit/f1c04ffe0552032f087c0de43df1c49777c381a0
- Session 01: `10-week/01-session/README.md` and `10-week/01-session/diagramas/10-week-01-hu24-cqrs.svg` (local draft, commit pending).
- Session 02: `10-week/02-session/README.md` and `10-week/02-session/diagramas/10-week-02-release-evidence.svg` (local draft, commit pending).
