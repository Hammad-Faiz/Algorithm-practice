# DRILL 1 — same problem you're stuck on in the Pre-Assessment.
#
# Accept an integer number of ounces. Output tons, pounds, and remaining
# ounces. 16 ounces = 1 pound. 2,000 pounds = 1 ton.
#
# Format:
#   Tons: value_1
#   Pounds: value_2
#   Ounces: value_3
#
# Example: input 32500 -> Tons: 1 / Pounds: 31 / Ounces: 4

ounces = int(input())

# TODO: cascade // and % — ounces -> (pounds, leftover ounces) -> (tons, leftover pounds)
