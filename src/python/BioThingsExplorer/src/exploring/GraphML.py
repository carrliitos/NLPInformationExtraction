from biothings_explorer.hint import Hint
from biothings_explorer.user_query_dispatcher import FindConnection

ht = Hint()
ace2 = ht.query("ACE2")['Gene'][0]
# print(ace2)

fc = FindConnection(input_obj=ace2,
                    output_obj='DiseaseOrPhenotypicFeature',
                    intermediate_nodes='ChemicalSubstance')

fc.connect(verbose=True)
# save graphml file to test.graphml
output = fc.to_graphml("test.graphml")