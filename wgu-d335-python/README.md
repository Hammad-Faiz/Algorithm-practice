# WGU D335 — Introduction to Programming in Python

Practice space for WGU's D335 course (zyBooks: `WGUD335Pythonv2`), separate from
the zyBooks labs themselves — this is for extra reps outside the graded/practice
environment, especially on patterns that need more drilling before the
proctored exam.

## drills/

Small standalone problems, one pattern at a time. Each file has the problem
statement as a header comment and a `TODO` where the solution goes.

- `1_tons_pounds_ounces.py`, `2_seconds_hms.py`, `3_minutes_dhm.py`,
  `4_exact_change.py` — the cascading `//` / `%` "peel off one unit, keep
  working with what's left" pattern (phone number breakdowns, exact change,
  unit conversions). Identified as a personal weak spot on 2026-07-26.
- `5_type_category_lookup.py` — type-dispatch via `type(x).__name__`.
- `6_employee_distance.py` — weighted sum across several inputs.
- `7_trapezoid_area.py` — plain formula; float-division-doesn't-need-rounding trap.
- `8_five_number_conversions.py` — same values, three different type conversions.
- `9_student_id_format.py` — string slicing as an alternative to the cascade pattern.
- `10_is_in_list.py` — function + `in` operator, plus a parameter-shadows-global naming trap.
- `11_framework_index_tryexcept.py` — try/except around a real `IndexError`.
- `12_water_temperature.py` — chained if/elif ranges + a second independent conditional.
- `13_stock_purchase.py` — read N, then loop N times, dict lookup + accumulate.
- `14_bulk_discount.py` — dict lookup + tiered-discount branching.
- `15_file_append_read.py` — file I/O across three separate `open()` modes
  (uses `sample_words.txt` alongside it).
- `16_csv_reverse.py` — `csv` module + `[::-1]` row reversal (uses `sample.csv`).
- `17_factorial_compare.py` — `math` module + comparison.
- `18_pig_age_module.py` — importing/calling a function from a local module
  (`pigAge.py`, sitting right next to it).

Run any of them directly, e.g.: `python3 drills/1_tons_pounds_ounces.py`
(run from inside `wgu-d335-python/drills/` for #15/#16 so they find their sample files)
