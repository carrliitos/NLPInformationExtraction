#!/usr/bin/python

# Edited Pipeline Script with Proper CSV Output
import os
import numpy
import time

def fileConvert(file, saveFile):
	os.system("(python convert.py {0}) > {1}".format(file, saveFile))

def entityExtraction(file, saveFile):
	os.system("(python EntityExtraction.py {0}) > {1}".format(file, saveFile))
	
def switchColsRows(file):
	csvFile = np.genfromtxt(file)
	transposed = csvFile.Text
	np.savetxt(file, transposed, fmt = "%i")

def main():
	inputDir = r"input"
	outputDir = r"output"
	nerOutputDir = r"NER-OUTPUT"
	
	# PDF to text conversion
	if not os.path.exists(outputDir):
		os.makedirs(outputDir)
	print ("Starting pdf to text conversions now.")
	print("")
	print ("Output folder is the following: ")
	print(outputDir)
	time.sleep(1)
	for file in os.listdir(inputDir):
		print("Extracting texts from: ")
		print(file)
		fileConvert((inputDir + "/" + file), (outputDir + "/" + (file[:-4] + ".txt")))
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
	if not os.path.exists(nerOutputDir):
		os.makedirs(nerOutputDir)
	print("Extracting entities")
	print("")
	print ("Output folder is the following: ")
	print(nerOutputDir)
	time.sleep(1)
	for file in os.listdir(outputDir):
		print("Extracting from the following text: ")
		print(file)
		with open(os.path.join(outputDir, file)) as inputText:
			entityExtraction((outputDir + "/" + file), (nerOutputDir + "/" + (file[:-4] + "_NER.csv")))
			# for line in inputText:
				# print(os.path.join(outputDir, line))
				# print(os.path.join(nerOutputDir, (line[:-4] + '_NER.csv')))
	print("")
	print("****************************************")
	print("Entity extraction complete.")
	print("****************************************")
	print("")
	time.sleep(1)
	
	#Transpose CSVs
	print("Transposing CSVs")
	for file in os.listdir(nerOutputDir):
		switchColsRows(file)
	print("****************************************")
	print("CSV transposing complete.")
	print("****************************************")
	print("")
	return
		
main()