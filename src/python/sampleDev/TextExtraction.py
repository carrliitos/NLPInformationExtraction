from io import StringIO
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfdocument import PDFDocument
from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.pdfparser import PDFParser

def convertPDFtoString(filePath):
	outputString = StringIO()

	with open(filePath, 'rb') as inFile:
		parser = PDFParser(inFile)
		doc = PDFDocument(parser)
		resourceManager = PDFResourceManager()
		device = TextConverter(resourceManager, outputString, laparams=LAParams())
		interpreter = PDFPageInterpreter(resourceManager, device)

		for page in PDFPage.create_pages(doc):
			interpreter.process_page(page)

	return outputString.getValue()

def driver(file):
	data = convertPDFtoString(file)
	res = " ".join(data.split())
	return res

if __name__ == '__main__': sys.exit(driver(sys.argv))