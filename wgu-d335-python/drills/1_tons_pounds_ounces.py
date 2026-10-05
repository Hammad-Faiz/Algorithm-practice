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

pounds = ounces // 16
ounces %= 16
tons = pounds // 2000
pounds %= 2000


tons_to_ounces = 2000 * 16

print(f"1 tone is {tons_to_ounces} ounces")



tons = ounces * 











