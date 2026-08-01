# System Design Prep

Ordered to build from framework → fundamentals → the specific areas where you already have real
experience (multi-region, Kafka, Glue/ETL, AWS migrations, resilience/game days), then general
scaling/caching that comes up in almost any design round.

1. [Interview framework](00-interview-framework.md) — how to structure the 45-60 min round
2. [Distributed systems fundamentals](01-distributed-systems-fundamentals.md) — CAP/PACELC,
   consistency models, consensus, partitioning, idempotency
3. [Multi-region architecture](02-multi-region-architecture.md) — topology choices, replication,
   failover, split-brain
4. [Kafka & event streaming](03-kafka-and-event-streaming.md) — partitioning, ordering, delivery
   semantics, backpressure
5. [Data pipelines, ETL & Glue](04-data-pipelines-etl-glue.md) — batch vs streaming, Glue
   internals, ETL failure modes
6. [AWS / cloud migration patterns](05-aws-migration-patterns.md) — the 6 R's, strangler fig,
   dual-write, CDC-based cutover
7. [Resilience & game days](06-resilience-and-game-days.md) — chaos engineering vocabulary,
   resilience patterns, turning a game day into a strong story
8. [Caching & scaling](07-caching-and-scaling.md) — cache strategies, stampede/hot-key problems,
   horizontal scaling, rate limiting

Each doc ends with a "talking points tied to your background" section — that's your cue to go
fill in the actual specifics in [`../behavioral/my-stories.md`](../behavioral/my-stories.md) so
the concrete version is ready before an interview, not improvised in the room.
