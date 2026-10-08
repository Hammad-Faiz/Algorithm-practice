# Task:
# Create a program that takes an integer input and determines whether it equals one of
# the values in this predefined list:
#
# predef_list = [4, -27, 15, 33, -10]
#
# Define a function named `is_in_list()` that outputs a Boolean value (`True` or `False`)
# based on whether the input value is present in `predef_list`.
# The solution should produce the output in the following format:
#
# `True` if the input is in the list, otherwise `False`.
#
# Is the input present in the list? Boolean_value
#
# Sample Input and Output:
# If the input is
#
# 20
#
# then the expected output is
#
# Is the input present in the list? False
#
# Alternatively, if the input is
#
# 33
#
# then the expected output is
#
# Is the input present in the list? True

predef_list = [4, -27, 15, 33, -10]

#solution accepts an integer input
#solution outputs Boolean value indicating whether integer input is in predef_list

#accept integer input
print("Enter the number to check for in the list:")
user_input = int(input())

#define function to compare input with list values
def is_in_list(user_input):
    if user_input in predef_list:
        return True
    else:
        return False
    



#output desired statement based on is_in_list() function
if __name__ == '__main__':
    print("Is the input present in the list?", is_in_list(user_input))