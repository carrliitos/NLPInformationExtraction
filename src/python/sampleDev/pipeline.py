# Edited Pipeline Script with Proper CSV Output
import os
import csv
import time

def fileConvert(file, saveFile): # Converts PDFs to TXT
	os.system("(python convert.py {0}) > {1}".format(file, saveFile))

def entityExtraction(file, saveFile): # Runs TXT through NER model and outputs to CSV
	os.system("python EntityExtraction.py {0} {1}".format(file, saveFile))

def main():
	inputDir = r'input'  # Directories depend on user
	outputDir = r'output'
	nerOutputDir = r'NER-OUTPUT'
	
	# PDF to text conversion
	print ("Starting pdf to text conversions now.")
	print("")
	print ("Output folder is the following: ")
	print(outputDir)
	time.sleep(1)
	if not os.path.exists("./output"):
		os.makedirs("./output")
	for file in os.listdir(inputDir):
		print("Extracting texts from: ")
		print(file)
		fileConvert((inputDir + '/' + file), (outputDir + '/' + (file[:-4] + ".txt")))
		print("New file is saved to: ")
		print(file[:-4] + ".txt")
		print("")
	print("")
	print("****************************************")
	print("PDF to Text conversion complete.")
	print ("****************************************")
	print("")
	time.sleep(1)
	
	# Named entity extraction
	print("Extracting entities")
	print("")
	print ("Output folder is the following: ")
	print(nerOutputDir)
	time.sleep(1)
	if not os.path.exists("./NER-OUTPUT"):
		os.makedirs("./NER-OUTPUT")
	for file in os.listdir(outputDir): 
		print("Extracting from the following text: ")
		print(file)
		entityExtraction((outputDir + '/' + file), (nerOutputDir + '/' + (file[:-4] + "_NER.csv")))
		print("NER output is saved to: ")
		print(file[:-4] + "_NER.csv")
		print("")
	print("")
	print("****************************************")
	print("Entity extraction complete.")
	print("****************************************")
	print("")
	time.sleep(1)
	
	return
		
main()