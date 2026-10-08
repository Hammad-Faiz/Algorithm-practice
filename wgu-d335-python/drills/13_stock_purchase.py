# Task:
# Create a solution that accepts an integer input identifying how many different shares of
# stock are purchased from the Old Town Stock Exchange, followed by an equivalent number of
# string inputs representing the stock selections.
#
# The following dictionary, stock, lists available stock selections as the key and the cost
# per selection as the value.
# stocks = {'TSLA': 912.86 , 'BBBY': 24.84, 'AAPL': 174.26, 'SOFI': 6.92, 'KIRK': 8.72, 'AURA': 22.12, 'AMZN': 141.28, 'EMBK': 12.29, 'LVLU': 2.33}
#
# Output the total cost of the purchased shares of stock to two decimal places.
#
# The solution output should be in the format:
#
# Total price: $cost_of_stocks
#
# Sample Input and Output:
# If the input is
#
# Enter a quantity of stocks followed by stock symbol(s):
# 3
# SOFI
# AMZN
# LVLU
#
# then the expected output is
#
# Total price: $150.53
#
# Alternatively, if the input is
#
# Enter a quantity of stocks followed by stock symbol(s):
# 2
# KIRK
# TSLA
#
# then the expected output is
#
# Total price: $921.58

stocks = {'TSLA': 912.86, 'BBBY': 24.84, 'AAPL': 174.26, 'SOFI': 6.92, 'KIRK': 8.72, 'AURA': 22.12, 'AMZN': 141.28, 'EMBK': 12.29, 'LVLU': 2.33}

#solution accepts an integer input representing the number of stock selections
#solution accepts string inputs equivalent to the integer input identifying the stock selections
#solution outputs the total cost of stock as "Total price: $" followed by the total cost to 2 decimal places

# input 
print("Enter a quantity of stocks followed by stock symbol(s):")
num_items = int(input())

total_price = 0

# loop and calculations

for i in range(num_items):
    stock = input()
    total_price = total_price + stocks[stock]


print(f"Total price: ${total_price:.2f}")