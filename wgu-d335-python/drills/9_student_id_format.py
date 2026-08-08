# DRILL 9 — string slicing as an alternative to the //  /  % cascade.
#
# Read a 9-digit integer. Output it formatted as xxx-xx-xxxx.
#
# Example: 123456789 -> 123-45-6789

identification_number = int(input())

# TODO: str() it, then slice [0:3] + "-" + [3:5] + "-" + [5:9]
