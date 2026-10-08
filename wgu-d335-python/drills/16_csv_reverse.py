# Task:
# Write a Python program that performs the following steps:
#
# 1. Prompt the user to input the name of a CSV file ("input1.csv").
# 2. Use Python's built-in `csv` module to open and read the specified file.
# 3. For each row in the file, reverse the order of elements (values separated by commas).
# 4. Print the reversed elements for each row to the console.
#
# Requirements:
#
# * Use the `open()` function to open the file.
# * Use the `csv.reader()` method to read the file contents.
# * Use a loop to iterate through each row and reverse the elements in the row.
# * Print the reversed elements as a list for each row.
#
# Sample Input and Output:
# If the input is
#
# Enter the name of the file along with its extension:
# input1.csv
#
# Contents of input1.csv:
#
# fruits,sports,countries
# banana,football,United States
# apple,soccer,Brazil
# orange,volleyball,Canada
#
# Then the expected output is
#
# ['countries', 'sports', 'fruits']
# ['United States', 'football', 'banana']
# ['Brazil', 'soccer', 'apple']
# ['Canada', 'volleyball', 'orange']
#
# Hints: Use Python's `[::-1]` slicing technique to reverse a list.
#
# (For local practice, the sample file in this folder is sample.csv.)

#import csv module and call open(), reader()
#solution accepts input identifying name of CSV file ("input1.csv")
#solution outputs each row of CSV file contents as a dictionary of elements
import csv

#accept string input identifying filename
print("Enter the name of the file along with its extension:")
file_name = input()

#open, read, and output the new file contents in the reverse order
with open(file_name, 'r') as csvfile:       #open csv file
    file_content = csv.reader(csvfile)
    for row in file_content:
        # print(row)
        print(row[::-1])        

