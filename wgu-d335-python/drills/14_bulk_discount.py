# DRILL 14 — dict lookup + tiered discount branching (like water_temperature
# but the ranges apply a multiplier instead of picking a label).
#
# Read an item name (key in `purchase`) and a quantity. Compute cost:
#   < 10 items:    full price
#   10-20 (incl.): 5% off
#   21+:           10% off
#
# Format:
#   quantity item total cost: $total
#
# Example: bananas, 12 -> 12 bananas total cost: $21.09
# Example: cookies, 144 -> 144 cookies total cost: $585.79

purchase = {"bananas": 1.85, "steak": 19.99, "cookies": 4.52, "celery": 2.81, "milk": 4.34}

item = input()
quantity = int(input())

# TODO: tiered discount on quantity, then formatted total
