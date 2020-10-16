import os

def fileConvert(file):
	os.system("python C:\\convert.py C:\\input.pdf > C:\\output.txt")

directory = f"sopas/"

def main():
	for file in os.listdir(directory):
		# print(file)
		# os.system("python convert.py " + directory + file)
		fileConvert(directory + file)
	return

main()