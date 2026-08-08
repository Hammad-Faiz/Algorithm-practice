# DRILL 13 — read N, then loop N times reading strings, dict lookup + sum.
#
# Read an integer quantity, then that many stock symbols (one per line).
# Look each up in `stocks` and sum their prices.
#
# Format:
#   Total price: $cost
#
# Example: 3 / SOFI / AMZN / LVLU -> Total price: $150.53

stocks = {'TSLA': 912.86, 'BBBY': 24.84, 'AAPL': 174.26, 'SOFI': 6.92,
          'KIRK': 8.72, 'AURA': 22.12, 'AMZN': 141.28, 'EMBK': 12.29, 'LVLU': 2.33}

num_items = int(input())

# TODO: loop num_items times, read a symbol each time, accumulate total
