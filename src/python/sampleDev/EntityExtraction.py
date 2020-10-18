import sys
import os
import spacy

nlp = spacy.load("UWW_NER_TRAUMA")

def main(argv):
	file = argv
	with open(file, "r") as inputText:
		print("Attributes,Values")
		for line in inputText:
			doc = nlp(line)
			for ent in doc.ents:
				print(ent.label_, ",", ent.text)

if __name__ == '__main__': sys.exit(main(sys.argv[1]))