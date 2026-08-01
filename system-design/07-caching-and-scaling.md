# Caching & Scaling Fundamentals

## Caching layers (know where each sits)
- Client-side / CDN (edge caching, static + semi-static content).
- API-gateway/reverse-proxy cache (e.g. full response caching for read-heavy, low-personalization
  endpoints).
- Application-level cache (Redis/Memcached) — the one you'll design most often in interviews.
- DB-level (query cache, materialized views, read replicas).

## Cache strategies
- **Cache-aside (lazy loading)**: app checks cache, on miss reads DB and populates cache. Most
  common; simple, but first request after eviction is always slow (cache stampede risk under load).
- **Write-through**: write to cache and DB together — reads are always fresh, writes are slower.
- **Write-behind (write-back)**: write to cache immediately, async flush to DB — fast writes,
  risk of data loss if the cache node dies before flush.
- **Read-through**: cache itself owns the DB-fetch-on-miss logic, transparent to the app.

## Cache correctness problems (favorite follow-up questions)
- **Stale data**: TTL-based expiry (simple, bounded staleness) vs explicit invalidation on write
  (fresher, but easy to miss an invalidation path and serve stale data forever).
- **Cache stampede/thundering herd**: many requests miss simultaneously (e.g. on expiry of a hot
  key) and all hit the DB at once. Mitigate with request coalescing (single in-flight fetch,
  others wait on it), jittered TTLs, or a "soft" expiry that serves stale-while-revalidating.
- **Hot key**: one key gets disproportionate traffic (e.g. a viral item) — a single cache node
  bottlenecks. Mitigate with local (in-process) caching in front of the distributed cache, or
  key splitting.

## Horizontal scaling patterns
- Stateless app servers behind a load balancer — scale by adding instances; this only works if
  session state lives elsewhere (cache/DB), not in-process.
- Read replicas for read-heavy workloads — replication lag becomes a correctness question for
  any "read your own write" requirement (common gotcha: user submits a form, gets redirected to
  a page that reads from a lagging replica and doesn't show their own change).
- Sharding for write-heavy workloads — see partitioning notes in
  `01-distributed-systems-fundamentals.md`.
- Connection pooling and its limits — DB connections are expensive; a fleet of app servers each
  holding many connections can exhaust the DB's connection limit before it exhausts CPU/memory,
  a classic "why did adding more app servers make things worse" trap.

## Load balancing
- L4 (transport layer, fast, no content awareness) vs L7 (application layer, can route by path/
  header, terminate TLS, do content-based routing).
- Load balancing algorithms: round robin, least-connections, consistent-hash (useful when you
  want session affinity or cache locality without full sticky sessions).

## Rate limiting & backpressure at the edge
- Token bucket / leaky bucket algorithms — know the difference (token bucket allows bursts up to
  bucket size; leaky bucket smooths output to a constant rate).
- Where to enforce it: gateway/edge (protects the whole system) vs per-service (protects a
  specific dependency) — often both, at different granularities.
