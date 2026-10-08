# Task:
# Write a Python program that performs the following steps:
#
# 1. Accept an integer input representing the age of a pig (in years).
# 2. Import the pre-existing module pigAge.
# 3. Use the built-in function `pigAge_converter()` from the module to calculate the
#    human-equivalent age of the pig.
# Note: One year of a pig's life is equivalent to five human years.
# 4. Output the result in the given format where:
#    * `input_pig_age` is the pig's age in years.
#    * `converted_pig_age` is the human-equivalent age of the pig.
#
# The solution output should be in the format:
#
# input_pig_age pig years is equivalent to converted_pig_age in human years
#
# Sample Input and Output:
# If the input is
#
# 8
#
# then the expected output is
#
# 8 pig years is equivalent to 40 in human years
#
# (For local practice, a pigAge.py module sits next to this file.)

#import pigAge module and call pigAge_converter()
#one pig year is equivalent to five human years
#solution accepts integer input representing a pig's age
#solution outputs the human-equivalent age for a pig

#import pigAge module and call pigAge_converter()
import pigAge

#accept integer input
print("Enter the age of the pig in years:")
input_pigAge = int(input())

#call module function pigAge_converter with user input parameter to calculate human equivalent age
converted_age = pigAge.pigAge_converter(input_pigAge)

print(f"{input_pigAge} pig years is equivalent to {converted_age} in human years")
