# Task:
# Create a solution that accepts one integer input representing the index value for any
# of the string elements in the following list:
# frameworks = ["Django", "Flask", "CherryPy", "Bottle", "Web2Py", "TurboGears"]
# Output the string element of the index value entered. Place the solution in a try block
# and implement an exception of "Error" if an incompatible integer input is provided.
#
# The solution output should be in the format:
#
# frameworks_element
#
# Sample Input and Output:
# If the integer input is
#
# 2
#
# then the expected output is
#
# CherryPy
#
# Alternatively, if the integer input is
#
# 7
#
# then the expected output is
#
# Error

frameworks = ["Django", "Flask", "CherryPy", "Bottle", "Web2Py", "TurboGears"]

#use try block with exception "Error" when index value is not found in list
#solution accepts an integer input
#solution outputs the corresponding string value for the integer input

#try-block to determine value
try:
  print("Enter the index of the element that you want to extract from the list:")  
  index = int(input())             #accept integer input

  element_in_index = frameworks[index]

  print(element_in_index)

except:
  print("Error")
  
