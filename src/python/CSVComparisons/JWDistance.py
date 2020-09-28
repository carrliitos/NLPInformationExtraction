import sys, csv

def main():
	stdoutOrigin=sys.stdout
	sys.stdout = open("log.csv", "w")
	
	if len(sys.argv) < 3:
		raise Exception("Need two words")

	stringA = sys.argv[1]
	stringB = sys.argv[2]

	print(f"word 1: {stringA}\nword 2: {stringB}\n"
			f"Jaro Distance: {jaroDistance(stringA, stringB)}\n"
			f"Jaro-Winkler Distance: {jwDistance(stringA, stringB)}")

	sys.stdout.close()
	sys.stdout = stdoutOrigin

def make1shorter(stringA, stringB):
	if len(stringA) > len(stringB):
		# Make sure one is shorter
		temp = stringA
		stringA = stringB
		stringB = temp
	return stringA, stringB

# Given two strings, Jaro Similarity calculates how similar both strings are.
# @param stringA and stringB - the two strings to be compared
def jaroDistance(stringA, stringB):
	# Check that words exists
	if len(stringA) == 0 or len(stringB) == 0:
		raise Exception("No words provided.")
	# make sure one is shorter for good comparison
	stringA, stringB = make1shorter(stringA, stringB)

	# we do our comparison of string B against string A
	# we just want to walk along the string of longest of the two which is 
	# string B and compare each character to string A and keep track of each
	# matching characters
	word2chars = list(stringB)
	m = 0
	for char in stringA:
		if char in word2chars:
			m += 1
			word2chars.pop(word2chars.index(char))

	# counting the transpositions
	t = 0
	for i in range(len(stringA)):
		if stringA[i] != stringB[i]:
			t += 1

	# Jaro similarity = (1/3) * (m/|sA| + m/|sB| + (m-t)/m)
	return 1 / 3 * (m / len(stringA) + m / len(stringB) + (m - t) / m)

# @param p - constant scaling factor for how much the score is adjusted upwards
# 	for having common prefixes.
# @param lmax - length of common prefix at the start of the string up to a max 
# 	of 4 characters
def jwDistance(stringA, stringB, p = 0.1, lmax = 4):
	# normalize strings
	stringA, stringB = make1shorter(stringA, stringB)
	# find Jaro distance
	jDistance = jaroDistance(stringA, stringB)

	# find the amount of common prefixes
	l = 0
	for i in range(min(len(stringA), lmax)):
		if stringA[i] == stringB[i]:
			l += 1
		else:
			break

	# similarity = jaroDistance + l*p(1 - jaroDistance)
	return jDistance + l * p * (1 - jDistance)

main()