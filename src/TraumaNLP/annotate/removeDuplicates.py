import csv

data_in = 'SurgicalProcedure2.csv'
data_out = 'SurgicalProcedure.csv'

with open(data_in, 'r', newline='') as in_file, open(data_out, 'w', newline='') as out_file:
	reader = csv.reader(in_file)
	writer = csv.writer(out_file)
	seen = set() # set for fast O(1) amortized lookup
	for row in reader:
		row = tuple(row)
		if row in seen: continue # skip duplicate
		seen.add(row)
		writer.writerow(row)