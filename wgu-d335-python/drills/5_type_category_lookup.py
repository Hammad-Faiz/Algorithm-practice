# DRILL 5 — different pattern: type-dispatch using type(x).__name__.
#
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

# TODO: look up the element, get its type name with type(x).__name__,
# then branch into the three category messages above.
