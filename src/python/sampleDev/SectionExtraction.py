import sys

def main(argv):
	file = argv
	a = []
	out = open("OUTPUT.txt", "w")

	with open(file, "r") as f:
		f = f.readlines()
		start = 0
		end = 0
		for(line_number, text) in enumerate(f):
			if (text.startswith("Case pre")
				or text.startswith("Case Pre") 
				or text.startswith("Case rep")
				or text.startswith("Case ")
				):
				start = line_number + 1
				a.append(start)
			if (text.startswith("Discuss")
				or text.startswith("discuss")
				):
				end = line_number + 1
				a.append(end)

		for first, second in zip(a[0::2], a[1::2]):
			print(first, second)
			for i in f[first:second]:
				print(i)
				out.write(i)

if __name__ == '__main__': sys.exit(main(sys.argv[1]))