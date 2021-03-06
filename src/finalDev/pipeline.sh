#!/bin/bash

# Ask user for folders
ls -la;sleep 0.5
echo "Enter your input folder name: "
read INPUT
echo "Enter text output folder name: "
read OUTPUT
echo "Enter NER output folder name: "
read NEROUTPUT
sleep 0.5
echo ""
echo "$INPUT"
echo "$OUTPUT"
echo "$NEROUTPUT"

# PDF to text conversion
sleep 0.5;echo "Starting pdf to text conversions now.";echo ""
mkdir "$OUTPUT";echo "$OUTPUT folder created.";echo "";sleep 1
for inputFile in $INPUT/*.pdf; do
	echo "Converting the following PDF: $inputFile"
	python "convert.py" "$inputFile" > "${inputFile::-4}.txt"
	mv "${inputFile::-4}.txt" "$OUTPUT"
done
echo ""
echo "****************************************"
echo "PDF to Text conversion complete."
echo "Text outputs are located in the $OUTPUT folder."
echo "$OUTPUT directory list";sleep 1; ls -l "$OUTPUT"
echo "****************************************"
echo ""

# Named entity extraction
echo "Extracting entities";echo ""
sleep 1;mkdir "$NEROUTPUT";echo "$NEROUTPUT folder created.";echo ""
for outputFile in $OUTPUT/*.txt; do
	echo "Extracting from the following text: $outputFile"
	for file in $outputFile; do
		python "EntityExtraction.py" "$file" "${file::-4}.NER.csv"
		mv "${file::-4}.NER.csv" "$NEROUTPUT"
	done
done
echo ""
echo "****************************************"
echo "Entity extraction complete."
echo "NER outputs are located in the $NEROUTPUT folder."
echo "$NEROUTPUT directory list";sleep 1; ls -l "$NEROUTPUT"
echo "****************************************"