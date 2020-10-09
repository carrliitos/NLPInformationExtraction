#!/usr/bin/env python
# coding: utf8

# To execute:
# $ python customNERspaCy.py -m=en -nm=UWW_NER_TRAUMA_MODEL -o=path/to/output/directory -n=1000

# Training additional entity types using spaCy
from __future__ import unicode_literals, print_function
import pickle
import plac
import random
from pathlib import Path
import spacy
from spacy.util import minibatch, compounding


# New entity labels
# Specify the new entity labels which you want to add here
LABEL = ['O', 'B-PI', 'B-GOAL', 'B-IM', 'B-SurgicalProcedure', 'B-SurgicalPreparation']

# Loading training data 
with open ('UWW_NER', 'rb') as fp:
	TRAIN_DATA = pickle.load(fp)

@plac.annotations(
	model=("Model name. Defaults to blank 'en' model.", "option", "m", str),
	new_model_name=("New model name for model meta.", "option", "nm", str),
	output_dir=("Optional output directory", "option", "o", Path),
	n_iter=("Number of training iterations", "option", "n", int))

def main(model=None, new_model_name='new_model', output_dir=None, n_iter=10):
	"""Setting up the pipeline and entity recognizer, and training the new entity."""
	if model is not None:
		nlp = spacy.load(model)  # load existing spacy model
		print("Loaded model '%s'" % model)
	else:
		nlp = spacy.blank('en')  # create blank Language class
		print("Created blank 'en' model")
	if 'ner' not in nlp.pipe_names:
		ner = nlp.create_pipe('ner')
		nlp.add_pipe(ner)
	else:
		ner = nlp.get_pipe('ner')

	for i in LABEL:
		ner.add_label(i)   # Add new entity labels to entity recognizer

	if model is None:
		optimizer = nlp.begin_training()
	else:
		optimizer = nlp.entity.create_optimizer()

	# Get names of other pipes to disable them during training to train only NER
	other_pipes = [pipe for pipe in nlp.pipe_names if pipe != 'ner']
	with nlp.disable_pipes(*other_pipes):  # only train NER
		for itn in range(n_iter):
			random.shuffle(TRAIN_DATA)
			losses = {}
			batches = minibatch(TRAIN_DATA, size=compounding(4., 32., 1.001))
			for batch in batches:
				texts, annotations = zip(*batch)
				nlp.update(texts, annotations, sgd=optimizer, drop=0.35,
						   losses=losses)
			print('Losses', losses)

	# Test the trained model
	test_text = 'Open cholescystectomy with intraoperative cholangiogram was performed' \
			'on a thick, distended and grossly-discolored gallbladder consistent with hemorrhage into the gallbladder' \
			'lumen.'
	doc = nlp(test_text)
	print("Entities in '%s'" % test_text)
	for ent in doc.ents:
		print(ent.label_, ent.text)

	# Save model 
	if output_dir is not None:
		output_dir = Path(output_dir)
		if not output_dir.exists():
			output_dir.mkdir()
		nlp.meta['name'] = new_model_name  # rename model
		nlp.to_disk(output_dir)
		print("Saved model to", output_dir)

		# Test the saved model
		print("Loading from", output_dir)
		nlp2 = spacy.load(output_dir)
		doc2 = nlp2(test_text)
		for ent in doc2.ents:
			print(ent.label_, ent.text)


if __name__ == '__main__':
	plac.call(main)