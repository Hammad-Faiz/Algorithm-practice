# Task:
# Create a solution that accepts five integer inputs. Output the sum of the five
# inputs three times, converting the inputs to the requested data type before
# finding the sum.
#
# * First output: the sum of the five inputs as an integer value
# * Second output: the sum of the five inputs after converting each input to a float value
# * Third output: the concatenation of the five inputs after converting each input to a string
#
# The solution output should be in the format:
#
# Integer: integer_sum_value
# Float: float_sum_value
# String: string_sum_value
#
# Sample Input and Output:
# If the input is
#
# Enter 1st number:
# 1
# Enter 2nd number:
# 3
# Enter 3rd number:
# 6
# Enter 4th number:
# 2
# Enter 5th number:
# 7
#
# then the expected output is
#
# Integer: 19
# Float: 19.0
# String: 13627

num1 = int(input())
num2 = int(input())
num3 = int(input())
num4 = int(input())
num5 = int(input())

sum_as_integer = int(num1 + num2 + num3 + num4 + num5)

sum_as_float = float(num1 + num2 + num3 + num4 + num5)

sum_as_string = str(num1) + str(num2) + str(num3) + str(num4) + str(num5)


print("Integer:", sum_as_integer)
print("Float:", sum_as_float)
print("String:", sum_as_string)




