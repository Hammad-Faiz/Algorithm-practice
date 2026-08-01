# System Design Interview Framework

A repeatable structure for a 45-60 min system design round. At Senior/Staff level, interviewers
care less about "did you draw the right boxes" and more about **how you reason about tradeoffs,
scale, and failure** — which maps directly to real work like game days and AWS migrations.

## 1. Clarify scope (5 min)
- Functional requirements: what must the system do? Explicitly list what's out of scope.
- Non-functional requirements: read-heavy vs write-heavy, latency SLA, consistency needs,
  availability target (99.9% vs 99.99%), expected scale (QPS, data volume, growth rate).
- Ask about existing constraints: must it integrate with legacy systems? Multi-region day one,
  or bolted on later? (This is your home turf — lean into it.)

## 2. Back-of-envelope estimation (5 min)
- QPS = daily active users × actions/user / 86400, then multiply by peak factor (often 2-3x).
- Storage = records/day × record size × retention period.
- Bandwidth = QPS × payload size.
- State assumptions out loud — the number matters less than showing you think in orders of magnitude.

## 3. High-level design (10-15 min)
- Draw the request path: client → LB → API/service layer → cache → DB/queue → downstream.
- Identify synchronous vs asynchronous boundaries early — this is where Kafka/event-driven
  design usually enters the conversation.
- Call out data stores by access pattern, not by brand loyalty (e.g. "high write throughput,
  no complex joins → wide-column or KV store" rather than "I'll use DynamoDB because I know it").

## 4. Deep dive (15-20 min)
Interviewer usually steers here. Common deep dives for someone with your background:
- How do you keep data consistent across regions? (see `02-multi-region-architecture.md`)
- How does the system survive a full AZ or region outage? (see `06-resilience-and-game-days.md`)
- How do you migrate this from on-prem/legacy without downtime? (see `05-aws-migration-patterns.md`)
- How does the async/event pipeline handle backpressure, ordering, replay? (see `03-kafka-and-event-streaming.md`)

## 5. Failure modes & tradeoffs (5-10 min)
- Single points of failure — name them, then say how you'd remove them.
- What happens under partial failure (network partition, one dependency slow)?
- Explicitly state the tradeoff you're making (CAP, latency vs consistency, cost vs redundancy)
  rather than presenting one option as strictly better.

## 6. Wrap up (2-3 min)
- Summarize the design in 2-3 sentences.
- Proactively mention what you'd monitor/alert on and how you'd validate resilience (game day,
  chaos testing) — this is a strong differentiator at your level, use it.

## Talking about YOUR real experience
When a question maps to something you've actually done (multi-region setup, an AWS migration,
a Kafka-based pipeline, a Glue job, a game day), say so explicitly and go concrete:
*"In practice, I've done this — here's the constraint that actually bit us and how we handled it."*
Interviewers weight lived experience much higher than textbook answers. Fill in the specifics
in `../behavioral/my-stories.md`.

## Common pitfalls at senior level
- Jumping to a specific AWS service before framing the problem generically.
- Not stating assumptions — silence reads as not having considered scale.
- Presenting a design with no failure discussion — interviewers will dock this heavily for
  someone with your infra background, since resilience IS the bar you're being measured against.
- Over-indexing on one deep dive and running out of time for breadth.
