# Python program to delete empty rows

import csv

inputCSV = "corpora_copy2_ner.csv"
outputCSV = "corpora_copy2_ner_output.csv"

with open(inputCSV) as in_file:
    with open(outputCSV, 'w') as out_file:
        writer = csv.writer(out_file)
        for row in csv.reader(in_file):
            if any(row):
                writer.writerow(row)