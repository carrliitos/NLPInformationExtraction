a = []

with open("./output/CaseReport1.txt", "r") as f:
	f = f.readlines()
	start = 0
	end = 0
	for(line_number, text) in enumerate(f):
		if text.startswith("Case pre") or text.startswith("Case Pre") or text.startswith("Case disc") or text.startswith("Case Disc"):
			start = line_number + 1
			a.append(start)
		if text.startswith("Discuss"):
			end = line_number + 1
			a.append(end)

out = open("OUTPUT.txt", "w")
with open("./output/CaseReport1.txt", "r") as f:
	f = f.readlines()
	for first, second in zip(a[0::2], a[1::2]):
		print(first, second)
		for i in f[first:second]:
			print(i)
			out.write(i)