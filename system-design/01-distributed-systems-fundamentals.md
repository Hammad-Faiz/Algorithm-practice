# Distributed Systems Fundamentals

## CAP theorem (and why it's more nuanced in practice)
- Under a network partition (P), you choose between Consistency (C) and Availability (A).
- Most real systems are actually reasoning about **PACELC**: if Partitioned, trade off A vs C;
  Else (normal operation), trade off Latency vs Consistency.
- In interviews, don't just name CAP — say which side you're picking *and why*, tied to the
  use case (e.g. "financial ledger writes need strong consistency; read-heavy product catalog
  can tolerate eventual consistency for lower latency").

## Consistency models (strongest to weakest)
1. **Strict/linearizable** — reads always see the most recent write, as if there's one copy.
   Expensive; usually only for narrow critical paths (e.g. account balance).
2. **Sequential consistency** — all nodes see operations in the same order, not necessarily real-time.
3. **Causal consistency** — causally related operations are seen in order; unrelated ones can reorder.
4. **Eventual consistency** — given no new writes, all replicas converge eventually. Cheapest,
   most available. Default for most multi-region read replicas.

## Consensus & replication
- **Leader-based replication**: single writer, followers replicate. Simple, but leader is a
  bottleneck/SPOF until failover completes.
- **Multi-leader / leaderless (Dynamo-style)**: higher write availability, but needs conflict
  resolution (last-write-wins, vector clocks, CRDTs).
- **Raft/Paxos**: how leader election and log replication achieve consensus despite failures.
  Know the shape even if you'd never implement it yourself — most managed services (etcd,
  Kafka's controller quorum, RDS Multi-AZ) rely on one of these underneath.

## Partitioning (sharding)
- Hash-based: even distribution, but range queries become expensive and resharding is painful.
- Range-based: efficient range scans, but risk of hot shards (e.g. sequential IDs, time-series
  data all landing on the newest shard).
- Consistent hashing: minimizes data movement when nodes are added/removed — worth knowing cold,
  it comes up whenever someone asks "how do you scale this store horizontally."

## Failure detection
- Heartbeats + timeouts, but timeouts alone can't distinguish "slow" from "dead" — this is why
  naive failover logic causes split-brain.
- Gossip protocols for cluster membership at scale (avoids a single coordinator being a bottleneck).
- Quorum reads/writes (W + R > N) as a tunable consistency/availability knob per operation.

## Idempotency & exactly-once illusion
- True exactly-once delivery doesn't exist across a network; what you actually build is
  **at-least-once delivery + idempotent processing** (dedupe keys, idempotency tokens, upserts).
- This is the single most common follow-up question after any Kafka/queue discussion — have a
  concrete answer ready (e.g. idempotency key stored with a TTL, dedupe at the consumer).

## Talking points tied to your background
- Multi-region setups are a live case study in consistency/availability tradeoffs — be ready to
  explain what consistency model you actually ran (probably eventual/read-replica for most data,
  strong for a narrow set of writes) and why.
- Game days are literally testing these failure-detection and failover assumptions under
  controlled conditions — frame them that way rather than just "we ran a drill."
