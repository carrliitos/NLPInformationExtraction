# Attempt at some manual tokenizations with python

def main():
	# Load text
	filename = "./camelBite.txt"
	file = open(filename, "rt")
	text = file.read()
	file.close()
	
	# Split by whitespace
	words = text.split();
	# print(words)

	# Remove punctuation from each word
	import string
	table = str.maketrans("", "", string.punctuation)
	stripped = [w.translate(table) for w in words]
	# Contractions like what's will become whats and armor-like will become armorlike
	# print(stripped[:100])

	# Normalizing cases -- convert to lower case
	words = [word.lower() for word in words]
	print(words)

main()