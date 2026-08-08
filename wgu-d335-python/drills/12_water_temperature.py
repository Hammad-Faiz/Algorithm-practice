# DRILL 12 — chained if/elif over 5 ranges, plus a SECOND, independent
# conditional check that only sometimes adds an extra output line.
#
# Read an integer temperature (F). Print the water state:
#   < 33 Frozen | 33-79 Cold | 80-114 Warm | 115-211 Hot | >=212 Boiling
# ALSO print a safety line only when:
#   temp < 33   -> "Watch out for ice!"
#   temp == 212 -> "Caution: Hot!"
# (all other cases: just the one state line, nothing extra)
#
# Example: 118 -> Hot   |   32 -> Frozen / Watch out for ice!

temperature = int(input())

# TODO: 4 chained elifs for state, plus the two special-case safety lines
