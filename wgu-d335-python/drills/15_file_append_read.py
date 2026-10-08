# Task:
# Write a Python program that performs the following steps:
#
# 1. Prompt the user to input the name of a text file (e.g., "WordTextFile.txt").
# 2. The input file contains exactly three rows, each containing a single word.
# 3. Using the `open()` function and the `read()` and `write()` methods, perform the following actions:
#    * Read the three words from the file.
#    * Construct a new sentence by combining these words in the same order, separating the words by spaces.
#    * Append this sentence to the end of the file on a new line.
# 4. Display the updated contents of the file.
#
# Requirements:
#
# * Use the `open()` function in the appropriate mode to read and write to the file.
# * Ensure the words in the sentence are separated by a single space.
# * Output the complete updated contents of the file, showing the original words followed by the newly appended sentence.
#
# Output Format:
# The program should print the updated file contents, with the original words on separate lines
# and the new sentence on a new line.
#
# Sample Input and Output:
# If the input is
#
# Enter the name of the input file:
# WordTextFile.txt
#
# Contents of `WordTextFile.txt` before the program runs:
#
# cat
# chases
# dog
#
# then the expected output is
#
# cat
# chases
# dog
# cat chases dog
#
# (For local practice, the sample file in this folder is sample_words.txt.)

#solution accepts file input to insert sentence composed of file content into text file on a new line
#solution outputs the text file contents including the new sentence
#accept input identifying filename
print("Enter the name of the input file:")
filename = input()

#open, read, and write text file (e.g., "WordTextFile.txt") using open(), read(), write()
with open(filename) as f:
    file_text = f.read()
    words = file_text.split()
    sentence = " ".join(words)

#open and write sentence to end of file
with open(filename, "a") as f:
    if not file_text.endswith("\n") : 
        f.write("\n")
    f.write(sentence)

 
#open, read, and output the updated file contents 
with open(filename, "r") as f:
    print(f.read())
