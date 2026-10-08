# Task:
# Create a solution that accepts a string input representing a grocery store item and an
# integer input identifying the number of items purchased on a recent visit. The following
# dictionary `purchase` lists available items as the key and the cost per item as the value.
# purchase = {"bananas": 1.85, "steak": 19.99, "cookies": 4.52, "celery": 2.81, "milk": 4.34}
# Additionally,
#
# * If fewer than 10 items are purchased, the price is the full cost per item.
# * If between 10 and 20 items (inclusive) are purchased, the purchase gets a 5% discount.
# * If 21 or more items are purchased, the purchase gets a 10% discount.
#
# Output the chosen item and the total purchase cost to two decimal places.
# The solution output should be in the format:
#
# quantity item_purchased total cost: $total_purchase_cost
#
# Sample Input and Output:
# If the input is
#
# bananas
# 12
#
# then the expected output is
#
# 12 bananas total cost: $21.09
#
# Alternatively, if the input is
#
# cookies
# 144
#
# then the expected output is
#
# 144 cookies total cost: $585.79

purchase = {"bananas": 1.85, "steak": 19.99, "cookies": 4.52, "celery": 2.81, "milk": 4.34}

#cost per item: <10 is full price, 10-20 (inclusive) is 5% discount, and 21+ is 10% discount
#solution accepts a string input representing an item (dictionary key)
#solution accepts an integer input representing the number of items to be purchased
#solution outputs the item and total cost of purchase

print("Enter the item to purchase:")
item = input()
print("Enter the quantity of that item:")
quantity = int(input())

price_of_item_in_list = purchase[item]

if quantity < 10:
    total_cost = price_of_item_in_list * quantity
    print(f"{quantity} {item} total cost: ${total_cost:.2f}")
elif quantity <= 20:
    total_cost = price_of_item_in_list * quantity
    total_cost = total_cost * .95
    print(f"{quantity} {item} total cost: ${total_cost:.2f}")
else:
    total_cost = price_of_item_in_list * quantity
    total_cost = total_cost * .90
    print(f"{quantity} {item} total cost: ${total_cost:.2f}")