# Task:
# Create a solution that accepts an integer input representing a 9-digit unformatted
# student identification number. Output the identification number as a string with no spaces.
#
# The solution output should be in the format:
#
# xxx-xx-xxxx
#
# Sample Input and Output:
# If the input is
#
# Enter Student Identification Number:
# 123456789
#
# then the expected output is
#
# 123-45-6789

#solution accepts a 9-digit integer representing an unformatted student identification number (e.g.,"5417543010")
#solution outputs formatted student identification number as a string (e.g.,"541-75-3010")
#accept integer input
print("Enter Student Identification Number:")
identification_number = input()

identification_number_string = str(identification_number)

first_3_numbers = identification_number_string[0:3]
second_2_numbers = identification_number_string[3:5]
last_numbers = identification_number_string[5:]

print(first_3_numbers + "-" + second_2_numbers + "-" + last_numbers)



