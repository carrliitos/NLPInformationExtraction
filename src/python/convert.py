import sys
from pdfminer.pdfdocument import PDFDocument
from pdfminer.pdfparser import PDFParser
from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.pdfpage import PDFPage
from pdfminer.converter import TextConverter
from pdfminer.cmapdb import CMapDB
from pdfminer.layout import LAParams

def main(argv):
	debug = 1
	password = b''
	pagenos = set()
	maxpages = 0
	outfile = None
	outtype = "text"
	imageWriter = None
	rotation = 0
	stripcontrol = False
	layoutmode = 'normal'
	encoding = 'utf-8'
	pageno = 1
	scale = 1
	caching = True
	showpageno = True
	laparams = LAParams()
	#
	PDFDocument.debug = debug
	PDFParser.debug = debug
	CMapDB.debug = debug
	PDFPageInterpreter.debug = debug
	#
	resourceManager = PDFResourceManager(caching=caching)
	outfp = sys.stdout
	device = TextConverter(resourceManager, outfp, laparams=laparams,
							imagewriter=imageWriter)
	#
	fname = argv
	with open(fname, 'rb') as fp:
		interpreter = PDFPageInterpreter(resourceManager, device)
		for page in PDFPage.get_pages(fp, pagenos,
									   maxpages=maxpages, password=password,
									   caching=caching, check_extractable=True):
			page.rotate = (page.rotate+rotation) % 360
			interpreter.process_page(page)
	device.close()
	outfp.close()
	return

if __name__ == '__main__': sys.exit(main(sys.argv[1]))