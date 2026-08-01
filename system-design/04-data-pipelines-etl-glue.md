# Data Pipelines, ETL & AWS Glue

## Batch vs streaming
- Batch (Glue jobs, scheduled Spark): simpler reasoning, higher latency (minutes-hours), cheaper
  for large historical processing.
- Streaming (Kafka + Kinesis/Flink/Spark Structured Streaming): low latency, but more
  operational complexity (state management, watermarks, backpressure).
- Lambda architecture (batch for correctness + streaming for freshness, reconciled later) vs
  Kappa architecture (everything as a replayable stream, no separate batch layer) — know the
  names, know that most real systems land somewhere pragmatic between them rather than purely one.

## Glue-specific concepts worth being crisp on
- **Glue Data Catalog**: central metadata store (Hive-metastore-compatible) — what makes data
  in S3 queryable by Athena/Redshift Spectrum/EMR without copying it.
- **Crawlers**: infer schema from data in S3, populate the catalog. Gotcha: schema drift (a new
  column appears) can silently change downstream query behavior if not monitored.
- **Glue Jobs (Spark/Python Shell)**: serverless ETL compute; job bookmarks track what's already
  been processed so incremental jobs don't reprocess the same data — a common interview
  "how do you avoid duplicate processing" answer.
- **DPU-based scaling**: cost/performance knob — worth mentioning cost-awareness, it's a real
  axis interviewers at a bank care about.

## ETL failure modes (these make good interview stories)
- Partial failure mid-job: does the job re-run from scratch, or resume? Idempotent writes
  (upsert by key, write to a staging table then atomic swap) protect against duplicate/partial
  data on retry.
- Schema evolution breaking downstream consumers — solved with schema registry equivalents,
  additive-only column changes, or versioned datasets.
- Late-arriving data — a batch job that ran before all source data landed produces silently
  incomplete output. Watermarking/reprocessing windows handle this in streaming; for batch,
  usually a "run at T+buffer" or an explicit backfill step.
- Small-file problem in S3 (many tiny files from streaming writes) tanking downstream query
  performance — compaction jobs are the fix, worth naming if this comes up.

## Data quality & lineage
- Validate at ingestion (schema, null checks, row count sanity) rather than discovering bad
  data three hops downstream — cheap to say, valuable to have actually done.
- Lineage matters more in regulated environments (fintech): being able to answer "where did this
  number come from" is often a compliance requirement, not just a nice-to-have.

## Talking points tied to your background
- Glue jobs + Kafka together usually means: streaming ingestion into a landing zone, batch
  Glue jobs to curate/transform into query-ready datasets. If that matches what you've built,
  say so and describe the specific failure you hit (schema drift, late data, duplicate
  processing) and the fix — concrete beats generic every time.
