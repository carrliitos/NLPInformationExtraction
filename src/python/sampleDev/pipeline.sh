#!/bin/bash

OUTPUT="output"
INPUT="input"
NEROUTPUT="NER-OUTPUT"

# PDF to text conversion
mkdir "$OUTPUT"
echo "$OUTPUT folder created."
echo ""
sleep 1
echo "Starting pdf to text conversions now."
echo ""
for inputFile in $INPUT/*.pdf; do
	echo "Converting the following PDF: $inputFile"
	python "convert.py" "$inputFile" > "${inputFile::-4}.txt"
	mv "${inputFile::-4}.txt" "$OUTPUT"
done
echo ""
echo "****************************************"
echo "PDF to Text conversion completed."
echo "Text outputs are located in the $OUTPUT folder."
echo "****************************************"
echo ""
# Named entity extraction
echo "Extracting entities"
echo ""
sleep 1
mkdir "$NEROUTPUT"
echo "$NEROUTPUT folder created."
echo ""
for outputFile in $OUTPUT/*.txt; do
	echo "Extracting from the following text: $outputFile"
	for file in $outputFile; do
		python "EntityExtraction.py" "$file" > "${file::-4}NER.txt"
		mv "${file::-4}NER.txt" "$NEROUTPUT"
	done
done
echo ""
echo "****************************************"
echo "Entity extraction completed."
echo "NER outputs are located in the $NEROUTPUT folder."
echo "****************************************"