# DRILL 16 — csv module + list slicing to reverse each row.
#
# Read a filename, use csv.reader() to read it, print each row reversed
# using [::-1]. Run from inside drills/ (or type sample.csv).
#
# Expected first line of output for sample.csv:
#   ['countries', 'sports', 'fruits']

import csv

filename = input()

# TODO: open the file, csv.reader() it, loop + print(row[::-1])
