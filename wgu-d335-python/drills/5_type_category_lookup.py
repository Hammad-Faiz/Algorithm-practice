# DRILL 5 — different pattern:

# Given the list below, accept an integer index. Retrieve that element,
# get its type name, then categorize it:
#   - "iterable" types (list, str, dict) -> "This element is iterable."
#   - numeric types (int, float)         -> "This element is numeric."
#   - anything else (e.g. None)          -> "This is a different data type."
#
# Format:
#   Element: [element_value], Type: [data_type], Message: [category_message]
#
# Example: index 3 -> Element: ['apple', 'banana', 'coconut'], Type: list, Message: This element is iterable.
# Example: index 1 -> Element: 2024, Type: int, Message: This element is numeric.

data_mixture = ["Python is fun", 2024, 5.67, ["apple", "banana", "coconut"], None, {"name": "John", "age": 25}]

print("Enter index:")
index = int(input())


element_in_array = data_mixture[index]

type_name = type(element_in_array).__name__

if type_name in ["list", "str", "dict"]:
    print(f"Element: {element_in_array}, Type: {type_name}, Message: This element is iterable.")
elif type_name in ["int", "float"]:
    print(f"Element: {element_in_array}, Type: {type_name}, Message: This element is numeric.")
else:
    print(f"Element: {element_in_array}, Type: {type_name}, Message: This is a different data type.")