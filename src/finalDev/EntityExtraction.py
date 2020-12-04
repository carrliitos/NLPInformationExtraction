import sys
import os
import spacy
import pandas as pd
import operator
from functools import reduce
import csv
import sys

nlp = spacy.load("UWW_NER_TRAUMA")

def main(argv):
	file = argv
	my_dict = []
	with open(file, "r") as inputText:
		for line in inputText:
			doc = nlp(line)
			for ent in doc.ents:
				# print(ent.label_, ",", ent.text)
				my_dict.append(dict([(ent.label_, ent.text)]))
		all_keys = reduce(operator.or_, (d.keys() for d in my_dict))
		# print(all_keys)
		newDict = {key: [d.get(key) for d in my_dict] for key in all_keys}
		# print(newDict)

		df = pd.DataFrame.from_dict(newDict)
		# df.to_csv(sys.argv[2], sep=',', index=False, na_rep="null")
		df.reindex(columns=['B-PI','B-GOAL','B-IM','B-SurgicalPreparation','B-SurgicalProcedure']).to_csv(sys.argv[2], sep=',', index=False, na_rep="null")

if __name__ == '__main__': sys.exit(main(sys.argv[1]))