# textacy, a library to extract verb phrases based on grammar rules
import textacy

aboutTalkText = ("The talk will introduct about Use cases of Natural Language"\
				"Processing in Fintech.")
pattern = r'(<VERB>?<ADV>*<VERB>+)'
aboutTalkDoc = textacy.make_spacy_doc(aboutTalkText, lang='en_core_web_sm')
# we get error here -- en_core_web_sm is not downloaded

verbPhrases = textacy.extract.pos_regex_matches(aboutTalkDoc, pattern)

print("Print all verb phrases:")
for chunk in verbPhrases:
	print(chunk.text)

print("Extract Noun Phrase to explain what nouns are involved")
for chunk in aboutTalkDoc.noun_chunk:
	print(chunk)