#!/bin/bash

# To run:
# $ ./cvrt2txt.sh /input/folder/with/all/pdfs

for file in $1*.pdf; do
	echo "Extracting texts from: "
	echo "$file"
	python "convert.py" "$file" > "${file::-4}.txt"
	echo "New file is saved to: "
	echo "${file::-4}.txt"
	echo ""
done
