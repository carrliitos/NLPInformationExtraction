#!/bin/bash

# output_directory="~/Documents/programs/NLPInformationExtraction/python/CaseReports/copies/output"

for file in $1*.pdf; do
	echo "Extracting texts from: "
	echo "$file"
	pdf2txt.py "$file" > "${file::-4}.txt"
	echo "New file is saved to: "
	echo "${file::-4}.txt"
	echo ""
done
