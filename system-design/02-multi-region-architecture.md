# Multi-Region Architecture

This is one of your strongest cards — you've actually built this. Use these notes to turn lived
experience into a clean interview narrative, not to learn it from scratch.

## Why multi-region
- **Disaster recovery**: survive a full region outage (AWS regions do go down).
- **Latency**: serve users from the nearest region.
- **Regulatory/data residency**: some data must stay in-region (common in fintech).

Be explicit in interviews about *which* of these was the actual driver — it changes the whole
design (DR-only active-passive vs latency-driven active-active).

## Topology choices
- **Active-passive (warm standby)**: one region serves traffic, the other replicates and stands
  by for failover. Simpler consistency story, higher RTO (minutes), lower cost.
- **Active-active**: both regions serve live traffic. Lower latency for users, but you now own
  conflict resolution and cross-region consistency as a first-class problem.
- **Pilot light / backup-restore**: cheapest DR, but RTO measured in hours — rarely acceptable
  for anything customer-facing at a bank.

## Data layer patterns
- Async cross-region replication (e.g. RDS read replica in region B, DynamoDB Global Tables,
  Kafka MirrorMaker/replication) — accept a replication lag window, define what happens to
  writes during failover (usually: some recent writes are lost or must be reconciled — say this
  out loud, interviewers respect the honesty).
- Region-scoped writes with async fan-out for read models elsewhere ("write local, read global").
- Conflict resolution when both regions can write: last-write-wins with clock skew risk, vector
  clocks, or route by partition key so a given entity only ever writes in one home region
  (avoids conflicts entirely at the cost of cross-region latency for "away" traffic).

## Routing & failover
- DNS-based failover (Route 53 health checks) — simple, but DNS TTL/caching means failover isn't
  instant; know your actual RTO here, not the theoretical one.
- Global load balancer / anycast for faster failover than DNS.
- **Split-brain risk**: if both regions think they're primary during a partition, you get
  divergent writes. Fencing tokens or a single source of truth for "who's primary" (e.g. a
  quorum-based lock service) prevent this — mention this explicitly, it's the #1 follow-up.

## What actually breaks in practice (use for your STAR stories)
- Replication lag spikes under load, causing stale reads right when you need fresh data most.
- Failover runbooks that were never tested end up wrong when you need them — this is the
  argument for game days (see `06-resilience-and-game-days.md`).
- Cost: cross-region data transfer and running duplicate infra is real money — a good interview
  answer acknowledges you'd right-size this (e.g. active-passive for low-traffic services,
  active-active only where latency actually matters).
- Config/feature-flag drift between regions causing inconsistent behavior — often the sneakiest
  bug class in a multi-region system, worth mentioning as a "surprising failure mode."

## Interview framing template
"We ran [active-passive/active-active] across two regions for [reason]. The tricky part wasn't
the happy path replication, it was [failover correctness / split-brain prevention / replication
lag under load] — we handled that with [specific mechanism]. If I were designing this from
scratch today I'd also add [monitoring/game day/circuit breaker]."
