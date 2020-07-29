# import modules from biothings_explorer
from biothings_explorer.hint import Hint
from biothings_explorer.user_query_dispatcher import FindConnection

ht = Hint()
# Find all potential representations of TBI
tbi_hint = ht.query("traumatic brain injury")
print(tbi_hint)
print()
# Select the correct representation of TBI
tbi = tbi_hint["Disease"][0]
print(tbi)
print()

# Find all potential representations of unipolar depression
depression_hint = ht.query("unipolar depression")
print(depression_hint)
print()
# Select the correct representation of depression
depression = depression_hint["Disease"][0]
print(depression)
print()

# help(FindConnection.__init__)
fc = FindConnection(input_obj=depression, output_obj=tbi, intermediate_nodes="BiologicalEntity")
# BTE finding connection
fc.connect(verbose=True)

print("Displaying and filter results")
# Displaying and filter results
df = fc.display_table_view()
# because UMLS is not currently well-integrated in our ID-to-object translation system, removing UMLS-only entries here
patternDel = "^UMLS:C\d+"
filter = df.node1_id.str.contains(patternDel)
df = df[~filter]

print(df.shape)
df.sample(10)

# Which diseases are mentioned the most
mentioned = df.node1_name.value_counts().head(10)
print(mentioned)