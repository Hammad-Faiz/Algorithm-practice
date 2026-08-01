# My Stories (fill this in — private, don't need to push details you're not comfortable with)

Purpose: turn your real JPMC experience into 5-6 tight STAR stories you can pull from for almost
any behavioral question, and reuse as the concrete example when a system-design round asks
"have you actually done this." Write these in your own words — the prompts below are just to
jog specifics, not a script.

> Tip: keep company-confidential details (internal system names, exact numbers you're not sure
> are ok to share externally) out of the version you commit if you're ever unsure — the shape of
> the story matters more than the proper nouns.

## Story 1: Multi-region setup
- Situation/Task: what system, why multi-region (DR? latency? regulatory?)
- Action: what topology did you build (active-passive/active-active)? What was the hardest part —
  replication lag, failover correctness, split-brain prevention, cost?
- Result: what's the measured outcome (RTO/RPO achieved, an incident it prevented or handled)?
- Which question categories does this answer? (production failure / technical decision / risk you caught)

## Story 2: A game day that found something real
- Situation/Task: what were you validating?
- Action: what failure did you inject, what broke that you didn't expect?
- Result: what changed afterward (fixed alert, corrected runbook, added circuit breaker)?
- Which question categories does this answer? (production failure / identifying a risk others missed)

## Story 3: AWS migration under a tight deadline
- Situation/Task: what was migrating, why the deadline was tight, what was incomplete/unknown.
- Action: what did you cut vs keep, how did you validate correctness (dual-write? shadow traffic?),
  how did you coordinate across teams if this touched systems you didn't own.
- Result: did it ship on time, what happened after, any follow-up tech debt you tracked.
- Which question categories does this answer? (tight deadline / cross-team influence / technical decision)

## Story 4: Kafka / event pipeline issue
- Situation/Task: what was the pipeline for, what broke (hot partition, consumer lag, poison
  message, ordering violation)?
- Action: how did you diagnose it, what was the fix?
- Result: what's different now (added DLQ, changed partitioning, alerting on lag)?
- Which question categories does this answer? (production failure / technical decision)

## Story 5: A Glue/data pipeline correctness or scale problem
- Situation/Task: what job, what went wrong (schema drift, duplicate processing, late data)?
- Action: what did you build to prevent recurrence?
- Result: measurable outcome.
- Which question categories does this answer? (production failure / raising the bar for the team)

## Story 6: Disagreement or pushback story
- Situation/Task: a technical decision you disagreed with, or scope you pushed back on.
- Action: how did you make your case, what was the outcome either way?
- Result: what happened, what you'd do the same/differently now.
- Which question categories does this answer? (disagreement / saying no / influence without authority)

## Story 7 (optional): Mentoring / raising the bar
- Someone you helped grow, a standard/process you introduced that stuck.

## The promotion / insourcing project story
Once the insourcing project lands on your resume, write its story here too — deadline pressure,
what you owned, what the measurable business/technical outcome was. This is likely to be your
strongest "walk me through a recent project" answer since it's freshest and most senior-scoped.

---

## Quick-reference: story → question category matrix
Fill in once the stories above are written, so in the room you can instantly match a question to
a story instead of searching your memory live.

| Question asked | Story to use |
|---|---|
| Tight deadline, incomplete info | |
| Production incident / something failed | |
| Disagreed with a decision | |
| Cross-team influence | |
| Risk nobody else noticed | |
| Mentored someone / raised the bar | |
| Walk me through a project you're proud of | |
