#!/bin/bash

INPUT="input"
OUTPUT="output"
EXTRACTEDSECTIONS="sections-output"
NEROUTPUT="NER-OUTPUT"

# PDF to text conversion
echo "Starting pdf to text conversions now.";echo ""
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

# Extract specific Case Report sections
echo "Extracting Case Report sections now"; echo ""
mkdir "$EXTRACTEDSECTIONS"; echo "$EXTRACTEDSECTIONS folder created.";echo "";sleep 1
for sectionFile in $OUTPUT/*.txt; do
	echo "Extracting Case Report section from the following: $sectionFile"
	python "SectionExtraction.py" "$sectionFile" > "${sectionFile::-4}.sec.txt"
	mv "${sectionFile::-4}.sec.txt" "$EXTRACTEDSECTIONS"
done
echo ""
echo "****************************************"
echo "Case Report sections extraction complete."
echo "Text outputs are located in the $EXTRACTEDSECTIONS folder."
echo "$EXTRACTEDSECTIONS directory list";sleep 1; ls -l "$EXTRACTEDSECTIONS"
echo "****************************************"

# Named entity extraction
echo "Extracting entities";echo ""
sleep 1;mkdir "$NEROUTPUT";echo "$NEROUTPUT folder created.";echo ""
for outputFile in $EXTRACTEDSECTIONS/*.txt; do
	echo "Extracting from the following text: $outputFile"
	for file in $outputFile; do
		python "EntityExtraction.py" "$file" > "${file::-8}.NER.csv"
		mv "${file::-8}.NER.csv" "$NEROUTPUT"
	done
done
echo ""
echo "****************************************"
echo "Entity extraction complete."
echo "NER outputs are located in the $NEROUTPUT folder."
echo "$NEROUTPUT directory list";sleep 1; ls -l "$NEROUTPUT"
echo "****************************************"