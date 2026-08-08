# DRILL 10 — a function using the `in` operator, plus a naming trap:
# don't name your parameter the same as a global variable you need to
# read inside the function (it shadows it).
#
# Given predef_list below, read an integer and define is_in_list(value)
# that returns True/False depending on whether value is in predef_list.
#
# Format:
#   Is the input present in the list? Boolean_value
#
# Example: 20 -> False   |   33 -> True

predef_list = [4, -27, 15, 33, -10]

user_input = int(input())

# TODO: def is_in_list(value): ... then print the formatted result
