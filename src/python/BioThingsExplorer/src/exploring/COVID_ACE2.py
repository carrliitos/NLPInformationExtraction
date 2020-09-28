# The angiotensin-converting enzyme 2, or ACE2 “receptor,” is the protein 
# provides the entry point for the coronavirus to hook into and 
# infect a wide range of human cells.

from biothings_explorer.user_query_dispatcher import FindConnection
from biothings_explorer.hint import Hint
ht = Hint()

ace2 = ht.query("ACE2")['Gene'][0]

fc = FindConnection(input_obj=ace2, output_obj='ChemicalSubstance', intermediate_nodes=['BiologicalEntity'])
fc.connect(verbose=True) # There was a KeyError: "equivalent_ids" on this line, will not move on from this example