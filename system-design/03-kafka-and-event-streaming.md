# Kafka & Event Streaming

## Core model
- Topics split into **partitions**; partition = unit of parallelism and ordering guarantee.
  Ordering is only guaranteed *within* a partition, never across partitions of a topic.
- Producers pick a partition via key hash (default) — same key always lands on the same
  partition, which is how you get per-entity ordering (e.g. all events for one accountId in order).
- Consumers in a **consumer group** each own a subset of partitions; scaling consumers beyond
  partition count leaves some consumers idle — a very common gotcha to mention.
- Brokers replicate partitions (leader + ISR followers) for durability; `acks=all` waits for the
  full in-sync replica set before confirming a write.

## Delivery semantics
- At-most-once, at-least-once, "exactly-once" (really: at-least-once + idempotent producer +
  transactional writes across topic+offset commit). Know that true end-to-end exactly-once
  requires the *consumer's side effect* to also be transactional/idempotent — Kafka can only
  guarantee its own internal exactly-once semantics, not your downstream DB write.
- Idempotent producer (`enable.idempotence=true`) dedupes retried sends at the broker level using
  producer ID + sequence number.

## Ordering & partitioning gotchas
- Repartitioning a topic (changing partition count) breaks the key→partition mapping for
  existing keys — existing consumers relying on strict per-key ordering can see it
  temporarily violated. Plan partition count for peak scale up front; it's a one-way door.
- Skewed keys (one hot entity) create a hot partition — no amount of adding consumers fixes this,
  since ordering ties that key to one partition. Solutions: composite keys, or accept
  eventual/reordered consistency for the hot entity specifically.

## Backpressure & consumer lag
- Consumer lag = (latest offset - committed offset). This is your primary health signal —
  alert on lag growth rate, not just absolute lag.
- Slow consumers: scale out (up to partition count), speed up processing (batch, async I/O),
  or shed load (dead-letter topic for retries instead of blocking the main partition).
- A stuck/poison message blocks the entire partition behind it if you don't have a DLQ pattern —
  a classic "what could go wrong" interview follow-up.

## Replay & retention
- Kafka retains by time/size, not by consumption — this is what makes it useful as an
  event log/source of truth, not just a queue. Replay = reset consumer group offset and reprocess.
- Great for backfills after a bug fix, or standing up a new read model from history.

## Schema management
- Schema registry (Avro/Protobuf) with compatibility rules (backward/forward) prevents a
  producer deploy from breaking every consumer — mention this if asked about evolving a
  pipeline safely, it's a real operational concern, not academic.

## Talking points tied to your background
- If you've worked with Kafka for event pipelines feeding Glue jobs or downstream services,
  the strongest story is usually: ordering guarantee you relied on, what happened when a
  partition got hot or a consumer group fell behind, and how you diagnosed/fixed it (scale
  consumers? DLQ? repartition?). Fill in the specifics in `../behavioral/my-stories.md`.
- If asked to design a pipeline from scratch: default to "Kafka as the durable event backbone,
  consumers materialize into whatever read stores downstream services need" — then adapt
  partitioning key to whatever entity needs ordering.
