import sys
import os
import spacy

nlp = spacy.load("UWW_NER_TRAUMA")

def main(argv):
	file = argv
	with open(file, "r") as inputText:
		for line in inputText:
			doc = nlp(line)
			for ent in doc.ents:
				print("Attributes = ", ent.label_, "\n Values = ", ent.text, "\n")

if __name__ == '__main__': sys.exit(main(sys.argv[1]))