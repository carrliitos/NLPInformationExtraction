import csv, sys
from itertools import zip_longest

def main():
	if len(sys.argv) < 3:
		raise Exception("Need two CSVs")

	csv1 = sys.argv[1]
	csv2 = sys.argv[2]
	csvComparisons(csv1, csv2)

	print(f"Succesfully calculated.")

def csvComparisons(csv1, csv2):
	with open(csv1, 'r', newline='') as csv_file1, open(csv2, 'r',
				newline='') as csv_file2, open('csvComparisons.csv', 'w') as outfile:
		csv_reader1 = csv.reader(csv_file1)
		csv_reader2 = csv.reader(csv_file2)

		csv1_length = 0
		csv2_length = 0

		word1_array = []
		word2_array = []

		for line in csv_reader1:
			for words in line:
				word1_array.append(words)
				# print(f"{words}: {word_length}")
			csv1_length += 1

		for line in csv_reader2:
			for words in line:
				word2_array.append(words)
				# print(f"{words}: {word_length}")
			csv2_length += 1

		# print(f"CSV 1: {word1_array}\nCSV 2: {word2_array}\n")
		# print(f"CSV 1 length: {csv1_length}\n")
		# print(f"CSV 2 length: {csv2_length}\n")

		# print("*****Levenshtein Distance*****")
		# for (string1, string2) in zip_longest(word1_array, word2_array):
		# 	print(f"edit distance for <{string1}> and <{string2}>: ")
				
		# 	# If first string's length is object of type 'NoneType'
		# 	# set length to zero
		# 	if string1 == None:
		# 		print(editDistanceDP(string1, string2, 0, len(string2)))
		# 	# If second string's length is object of type 'NoneType'
		# 	# set length to zero
		# 	elif string2 == None:
		# 		print(editDistanceDP(string1, string2, len(string1), 0))
		# 	else:
		# 		print(editDistanceDP(string1, string2, len(string1), len(string2)))

		# print("\n*****Jaro and Jaro-Winkler Distances*****")
		# for (string1, string2) in zip_longest(word1_array, word2_array):
		# 	print(f"Finding distance for <{string1}> and <{string2}>: \n"
		# 		f"Jaro Distance: {jaroDistance(string1, string1)}\n"
		# 		f"Jaro-Winkler Distance: {jwDistance(string1, string1)}\n")

		outfile_writer = csv.writer(outfile, delimiter=',')
		outfile_writer.writerow(['string1', 'string2', 'LevenshteinDistance', 
				'Jaro', 'JaroWinklerDistance'])

		for (string1, string2) in zip_longest(word1_array, word2_array):
			# Calculate Levenshtein distance
			# If first string's length is object of type 'NoneType'
			# set length to zero
			if string1 == None:
				levenshtein = editDistanceDP(string1, string2, 0, len(string2))
			# If second string's length is object of type 'NoneType'
			# set length to zero
			elif string2 == None:
				levenshtein = editDistanceDP(string1, string2, len(string1), 0)
			else:
				levenshtein = editDistanceDP(string1, string2, len(string1), len(string2))

			# Calculate Jaro distance
			jaro = jaroDistance(string1, string1)
			# Calculate Jaro-Winkler distance
			jaroWink = jwDistance(string1, string1)

			# output the results
			outfile_writer.writerow([string1, string2, levenshtein, jaro, jaroWink])

def make1shorter(str1, str2):
	if len(str1) > len(str2):
		temp = str1
		str1 = str2
		str2 = temp
	return str1, str2

def jaroDistance(str1, str2):
	if len(str1) == 0 or len(str2) == 0:
		raise Exception("No words provided.")

	str1, str2 = make1shorter(str1, str2)

	word2chars = list(str2)
	m = 0
	for char in str1:
		if char in word2chars:
			m += 1
			word2chars.pop(word2chars.index(char))

	t = 0
	for i in range(len(str1)):
		if str1[i] != str2[i]:
			t += 1

	return 1/3*(m/len(str1) + m/len(str2) + (m - t / 2)/m)

def jwDistance(str1, str2, p = 0.1, lmax = 4):
	str1, str2 = make1shorter(str1, str2)
	jDistance = jaroDistance(str1, str2)

	l = 0
	for i in range(min(len(str1), lmax)):
		if str1[i] == str2[i]:
			l += 1
		else:
			break

	return jDistance + l * p * (1 - jDistance)

def editDistanceDP(str1, str2, m, n): 
	table = [[0 for x in range(n + 1)] for x in range(m + 1)] 

	for i in range(m + 1): 
		for j in range(n + 1): 
			if i == 0: 
				table[i][j] = j # Min. operations = j 
			elif j == 0: 
				table[i][j] = i # Min. operations = i 
			elif str1[i-1] == str2[j-1]: 
				table[i][j] = table[i-1][j-1] 
			else: 
				table[i][j] = 1 + min(table[i][j-1],	# Insert 
								table[i-1][j],		 	# Remove 
								table[i-1][j-1]) 		# Replace 
	return table[m][n]

main()