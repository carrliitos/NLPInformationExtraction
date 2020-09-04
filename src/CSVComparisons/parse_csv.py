import csv
from itertools import zip_longest

with open('TEST1.csv', 'r', newline='') as csv_file1, open('TEST2.csv', 'r', newline='') as csv_file2:
	csv_reader1 = csv.reader(csv_file1)
	csv_reader2 = csv.reader(csv_file2)

	csv1_length = 0
	csv2_length = 0

	next(csv_reader1)
	next(csv_reader2)

	word1_array = []
	word2_array = []

	for line in csv_reader1:
		for words in line:
			word1_array.append(words)
			word_length = len(words)
			# print(f"{words}: {word_length}")

	for line in csv_reader2:
		for words in line:
			word2_array.append(words)
			word_length = len(words)
			# print(f"{words}: {word_length}")	

	print(f"{word1_array}\n{word2_array}")

	print(f"CSV 1 length: {str(csv1_length)}")
	print(f"CSV 2 length: {str(csv2_length)}")

	for (array1, array2) in zip_longest(word1_array, word2_array):
		print(array1, array2)

	# Loop over/consume the header
	# next(csv_reader1)
	# next(csv_reader2)

	# write a new csv file
	# with open('new_test.csv', 'w') as new_file:
	# 	csv_writer = csv.writer(new_file, delimiter='\t')

	# 	for line1 in csv_reader1:
	# 		csv_writer.writerow(line1)
	# 		# print(line1[0])

	# 	for line2 in csv_reader2:
	# 		csv_writer.writerow(line2)
	# 		# print(line[0])

################################################

	# for line1 in csv_reader1:
	# 	data1 = line1
	# 	# print(data1)
	# 	# print(line1[0])

	# for line2 in csv_reader2:
	# 	data2 = line2
	# 	# print(line[0])

	# if data1[0] == data2[0]:
	# 	print("Hello!")
	# else:
	# 	print("NOT HELLO!")

################################################

	# for data1 in csv_reader1:
	# 	if data1[1] == "Attribute2":
	# 		for row in csv_reader2:
	# 			if row[0] == data1[0]:
	# 				print(row[1])

################################################