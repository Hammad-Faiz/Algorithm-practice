# DRILL 2 — same pattern, different units, one more cascade level.
#
# Accept an integer number of total seconds. Output the equivalent in
# hours, minutes, and remaining seconds. 60 seconds = 1 minute.
# 60 minutes = 1 hour.
#
# Format:
#   Hours: value_1
#   Minutes: value_2
#   Seconds: value_3
#
# Example: input 3725 -> Hours: 1 / Minutes: 2 / Seconds: 5

total_seconds = int(input())

# TODO: cascade // and % — seconds -> (minutes, leftover seconds) -> (hours, leftover minutes)
