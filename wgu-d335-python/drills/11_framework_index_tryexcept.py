# DRILL 11 — try/except for a real runtime error, not just user error.
#
# Given frameworks below, read an integer index. Print frameworks[index].
# If the index doesn't exist in the list, print "Error" instead of
# crashing. Wrap the risky line in a try/except.
#
# Example: 2 -> CherryPy   |   7 -> Error (list only has indices 0-5)

frameworks = ["Django", "Flask", "CherryPy", "Bottle", "Web2Py", "TurboGears"]

# TODO: try: read index, print frameworks[index]  /  except: print("Error")
