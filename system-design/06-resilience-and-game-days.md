# Resilience Engineering & Game Days

This maps directly to real work you've done — the goal here is vocabulary + framing, not new
concepts.

## Why game days exist
- A runbook or failover mechanism that's never been exercised is a hypothesis, not a fact.
  Game days convert "we think failover works" into "we know failover works, and it takes N
  minutes, and here's what breaks."
- They surface **latent failure modes**: alerts that don't fire, dashboards that don't show the
  right signal, on-call runbooks that reference a decommissioned system, permissions that were
  never granted to the failover role.

## Standard resilience testing vocabulary (use these terms — interviewers pattern-match on them)
- **Chaos engineering**: deliberately injecting failure (kill an instance, add latency, drop a
  dependency) in a controlled way to validate the system tolerates it. Netflix's Chaos Monkey is
  the canonical reference point.
- **Blast radius**: how much of the system/traffic is affected by a given failure injection —
  always start small (single instance, small % of traffic) and expand.
- **Steady-state hypothesis**: define what "normal" looks like on your metrics *before* injecting
  failure, so you can objectively tell if the system degraded.
- **GameDay** (AWS's term) / **DiRT** (Google's Disaster Recovery Testing) — same idea, different
  vendor branding; know both names.

## Failure types worth naming when describing a game day you ran
- Instance/AZ failure (does auto-scaling/failover actually replace capacity in time?)
- Region failure (does the DR region actually take over, and how long does it take — RTO/RPO in
  practice vs on paper?)
- Dependency failure (does a downstream service being slow/down cause cascading failure via
  synchronous calls with no timeout/circuit breaker?)
- Data corruption/poison message (does a bad message crash the consumer, or does it get
  isolated — DLQ, circuit breaker?)
- Config/secret rotation failure (does the system handle a credential rotating mid-flight?)

## Resilience patterns to reference
- **Circuit breaker**: stop calling a failing dependency after a threshold, fail fast instead of
  piling up latency/threads; half-open state to test recovery.
- **Bulkhead**: isolate resource pools (thread pools, connection pools) per dependency so one
  slow dependency can't exhaust resources needed by others.
- **Timeouts + retries with backoff + jitter**: naive retries amplify load on an already-struggling
  dependency (retry storms) — jitter spreads retries out to avoid synchronized thundering herds.
- **Graceful degradation**: serve a reduced/cached experience instead of a hard failure when a
  non-critical dependency is down.

## Turning a game day into a strong interview story
The structure that lands well:
1. What we set out to validate (a specific failover or capacity assumption).
2. What we actually found (the surprising gap — this is the interesting part, not "everything
   worked perfectly").
3. What changed afterward (a fixed alert, a corrected runbook, a newly added circuit breaker,
   an increased timeout that was actually too aggressive).
4. The measurable outcome (reduced RTO, caught a real gap before it became an incident).

Interviewers specifically want #2 and #3 — a game day where "everything just worked" reads as
either a low-value exercise or a story you haven't fully unpacked. Fill in the real specifics in
`../behavioral/my-stories.md`.
