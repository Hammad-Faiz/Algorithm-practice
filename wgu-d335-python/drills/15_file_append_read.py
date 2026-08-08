# DRILL 15 — three separate `with open()` blocks, since you need three
# different modes (read words, append a new line, read the whole thing back).
#
# Read a filename. The file has 3 words, one per line. Build a sentence
# from them (space-separated), append it as a new line, then print the
# whole updated file.
#
# Run this one from inside the drills/ folder so it finds sample_words.txt
# (or type that filename when prompted).
#
# Expected sample_words.txt before running:
#   cat
#   chases
#   dog
# After running once, it'll have a 4th line: "cat chases dog"
# NOTE: running it a second time appends AGAIN — reset the file from git
# if you want to retry from scratch (git checkout -- sample_words.txt).

filename = input()

# TODO: 'r' to read+split words, 'a' to append the joined sentence,
#       'r' again to read+print the full updated contents
