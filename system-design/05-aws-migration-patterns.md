# AWS / Cloud Migration Patterns

## The 6 R's (standard vocabulary — use these terms explicitly, interviewers listen for them)
1. **Rehost** ("lift and shift") — move as-is (e.g. EC2 instead of on-prem VM). Fastest, least
   benefit, often a stepping stone.
2. **Replatform** ("lift, tinker, and shift") — small optimizations without changing architecture
   (e.g. move to RDS instead of self-managed DB, keep the app the same).
3. **Repurchase** — swap for a SaaS/managed equivalent.
4. **Refactor/re-architect** — redesign for cloud-native (microservices, managed queues,
   serverless). Highest effort, highest long-term payoff.
5. **Retire** — decommission what's no longer needed (often the highest-ROI, least-glamorous step).
6. **Retain** — leave it on-prem (regulatory, cost, or dependency reasons).

Naming which R applied to which part of a migration you ran is an instant credibility signal.

## Migration strategy for stateful systems (the hard part)
- **Strangler fig pattern**: route an increasing slice of traffic to the new system while the
  old one still runs, rather than a big-bang cutover. Reduces blast radius; you can roll back
  a slice instead of the whole migration.
- **Dual-write / shadow traffic**: write to both old and new systems, compare outputs, before
  cutting reads over. Catches correctness bugs before they're customer-facing — worth
  mentioning as your validation strategy if asked "how do you know the migration is correct."
- **Data migration**: bulk backfill (snapshot) + CDC (change data capture, e.g. DMS or
  Debezium-style binlog tailing) to catch up on writes that happened during backfill, then a
  brief cutover window. This is the standard "near-zero-downtime" migration shape.
- **Rollback plan is not optional** — a good migration story always includes "and if step X had
  failed, here's exactly how we'd have rolled back," even if you never needed it.

## Common phased approach
1. Assess & inventory (dependencies, data volume, compliance constraints).
2. Pilot with a low-risk, low-traffic service to validate tooling and process.
3. Migrate in waves ordered by dependency graph (migrate what nothing else depends on first).
4. Run old and new in parallel (shadow/dual-write) to build confidence.
5. Cutover, then decommission the old system after a safety window — don't decommission
   immediately, keep a fast rollback path available.

## Tight-deadline migration realities (this is where your actual stories live)
- Deadlines force scope cuts — the interesting story is *what* you cut and how you managed the
  risk of cutting it (e.g. deferred a nice-to-have optimization, kept a manual runbook step
  instead of automating it, and called that out explicitly as tech debt with a follow-up ticket).
- Cross-team coordination is usually the actual bottleneck, not the technical migration itself —
  a good STAR story often centers on how you drove alignment/unblocked other teams under time
  pressure, not just the AWS mechanics.

## Common pitfalls to name proactively
- Underestimating data transfer time/cost for large datasets.
- IAM/security model differences between on-prem and cloud causing last-minute access issues.
- Network latency assumptions baked into old code (chatty calls that were fine on a LAN, not
  fine cross-AZ/region).
- Cost surprises post-migration (egress charges, over-provisioned managed services) — mention
  that you'd set up cost monitoring/budgets as part of the migration, not as an afterthought.

## Talking points tied to your background
- You've done AWS migrations under tight deadlines — the strongest interview answer names the
  specific R (rehost vs refactor), the cutover mechanism (dual-write? CDC? big-bang with a
  rollback plan?), and one thing that nearly went wrong. Fill in specifics in
  `../behavioral/my-stories.md`.
