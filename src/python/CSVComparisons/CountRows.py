import os

csv1fileSize = os.stat("TEST1.csv").st_size
csv2fileSize = os.stat("TEST2.csv").st_size

# Not including the header
numRowsCSV1, numRowsCSV2 = -1, -1

for row in open("TEST1.csv"):
	numRowsCSV1 += 1

for row in open("TEST2.csv"):
	numRowsCSV2 += 1

print(f"CSV 1:\nLength: {str(numRowsCSV1)}\nSize: {csv1fileSize}\n")
print(f"CSV 2:\nLength: {str(numRowsCSV2)}\nSize: {csv2fileSize}\n")