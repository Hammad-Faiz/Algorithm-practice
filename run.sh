#!/bin/bash
# Usage: ./run.sh java-core/Exercise01_Interfaces.java

FILE=$1

if [ -z "$FILE" ]; then
  echo "Usage: ./run.sh <path-to-file.java>"
  exit 1
fi

echo "Compiling $FILE..."
javac "$FILE"

if [ $? -ne 0 ]; then
  echo "Compilation failed."
  exit 1
fi

# Get the class name from filename (strip path and .java)
CLASSNAME=$(basename "$FILE" .java)
DIR=$(dirname "$FILE")

echo "Running $CLASSNAME..."
echo "---"
java -cp "$DIR" "$CLASSNAME"
