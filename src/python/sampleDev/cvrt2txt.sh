#!/bin/bash

OUTPUT="output"
INPUT="input"

mkdir "$OUTPUT"
echo "OUTPUT folder created here: $OUTPUT"$'\n'
sleep 2

echo "Starting pdf to text conversions now."$'\n'

for inputFile in $INPUT/*.pdf; do
	echo "Converting the following PDF: "
	echo "$inputFile"
	python "convert.py" "$inputFile" > "${inputFile::-4}.txt"
	mv "${inputFile::-4}.txt" "$OUTPUT"
done

echo ""
echo "Conversion completed."
echo "Outputs are located in $OUTPUT folder."
