#!/bin/bash

# To run:
# $ ./cvrt2txt.sh /input/folder/with/all/pdfs

for file in $1*.pdf; do
	echo "Extracting texts from: "
	echo "$file"
	python "convert.py" "$file" > "${file::-4}.txt"
	mkdir "./output/"
	mv "${file::-4}.txt" "output/"
done

echo ""
echo "Outputs are located in the output/ folder"
