from biothings_explorer.hint import Hint

ht = Hint()
# produce a python dictionary containing covid related information
covid_hint = ht.query('covid-19')
# they keys to access the dictionary - most are empty except for the Disease tab
print(covid_hint.keys())
# covid disease information
print(covid_hint['Disease'])
# iterate the items under the disease tab
for h_t in covid_hint['Disease']:
	print(h_t)
	
# Each h_t is in of itself a dictionary object that can be indexed with its own set of keys.
# What might be confusing is what 'MONDO' is. This is what is called a curie identifier. 
# Curie identifiers are unique names within some dataase or ontology. In this case MONDO is 
# an ontology. For example the unique curie identifier that map to the ontology names are:

for h_t in covid_hint['Disease']:
	print("Printing Mondo:")
	print(h_t['MONDO'] + "\n")
	print("Printing name")
	print(h_t['name'])