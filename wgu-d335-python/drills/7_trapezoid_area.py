# Three integers: base1, base2, height. Area = ((b1+b2) * h) / 2.
#
# Format:
#   Trapezoid area: area square meters
#
# Example: 3, 4, 5 -> 17.5   |   3, 5, 7 -> 28.0 (not "28")

base_1 = int(input())
base_2 = int(input())
height = int(input())


area = ((base_1 + base_2) * height) / 2

print(f"Trapezoid area: {area} square meters")
