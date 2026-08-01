# DRILL 3 — three-level cascade, like the tons/pounds/ounces one.
#
# Accept an integer number of total minutes. Output the equivalent in
# days, hours, and remaining minutes. 60 minutes = 1 hour.
# 24 hours = 1 day.
#
# Format:
#   Days: value_1
#   Hours: value_2
#   Minutes: value_3
#
# Example: input 4321 -> Days: 3 / Hours: 0 / Minutes: 1

total_minutes = int(input())

# TODO: cascade // and % — minutes -> (hours, leftover minutes) -> (days, leftover hours)
