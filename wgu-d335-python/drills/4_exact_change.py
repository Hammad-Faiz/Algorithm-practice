# DRILL 4 — same pattern with two extra twists: 5 levels, and you skip
# printing a level entirely if its count is 0. This is a warm-up for
# zyBooks 29.8 "Exact change", which you paused on.
#
# Accept an integer number of cents (total change owed). Output the
# fewest coins that make that amount, largest to smallest: Dollars (100),
# Quarters (25), Dimes (10), Nickels (5), Pennies (1). Only print a line
# for a coin type if its count is greater than 0.
#
# If the input is 0 or negative, just print "No change" and stop.
#
# Example: input 45 -> 1 Quarter / 2 Dimes   (no Dollars/Nickels/Pennies lines)

cents = int(input())

if cents <= 0:
    print("No change")
else:
    pass  # TODO: cascade // and % through 100, 25, 10, 5, 1 — only print counts > 0
