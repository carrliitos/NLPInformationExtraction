import os

def fileConvert(file):
	os.system("python convert.py {0} > {1}".format(file, file.replace(".pdf", ".txt")))

directory = f"CaseReports/TestFiles/"

def main():
	for file in os.listdir(directory):
		# print(file)
		# os.system("python convert.py " + directory + file)
		fileConvert(directory + file)
	return

main()