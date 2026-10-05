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
    dollars = cents // 100
    cents = cents % 100
    if dollars > 1:
        print(dollars, "Dollars")
    elif dollars > 0:
        print(dollars, "Dollar") 

    quarters = cents // 25
    cents = cents % 25
    if quarters > 1:
        print(quarters, "Quarters")
    elif quarters > 0:
        print(quarters, "Quarter")
    
    dimes = cents // 10
    cents = cents % 10
    if dimes > 1:
        print(dimes, "Dimes")
    elif dimes > 0:
        print(dimes, "Dime")
    
    nickles = cents // 5
    cents = cents % 5
    if nickles > 1:
        print(nickles, "Nickels")
    elif nickles > 0:
        print(nickles, "Nickel")

    if cents > 1:
        print(cents, "Pennies")
    elif cents > 0:
        print(cents, "Penny")