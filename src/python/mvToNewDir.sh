#!/bin/bash

echo "Moving all text files in $1 to a new directory"

for file in $1*.txt; do
	mv "$file" "$1output"
	echo "[src file] $file"
	echo "[dest file] $1output"
	echo ""
done