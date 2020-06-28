/**
* @author BC Salazar
* Sample use of PDFBox for extracting information out of PDFs
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.cos.COSDocument;

public class PDFInfo {
	public static void main(String[] args) {
		String path = "/home/carlitos/Documents/NLPInformationExtraction/src/java/CaseReports/OralCyst.pdf";
		// File file = new File(path);
		PDDocument pdd = null;

		// try{
		// 	// Load the pdf file
		// 	// PDDocument document = new PDDocument();
		// 	// document = PDDocument.load(file);

		// 	// Parse and read the document
		// 	PDFParser parser = new PDFParser(inputStream);
		// 	parser.parse();
		// 	COSDocument cosDoc = parser.getDocument();
		// 	PDDocument pdDoc = new PDDocument(cosDoc);

		// 	// Get the PDDocumentInformation object from the PDDocument created
		// 	PDDocumentInformation information = document.getDocumentInformation();

		// 	// PDFTextStripper
		// 	PDFTextStripper stripper = new PDFTextStripper(cosDoc);

		// 	String title = information.getTitle();
		// 	String author = information.getAuthor();
		// 	String subject = information.getSubject();
		// 	String producer = information.getProducer();
		// 	String trapped = information.getTrapped();
		// 	String keywords = information.getKeywords();

		// 	text = stripper.getText(pdDoc);
			
		// 	// System.out.printf("Title: %s%nAuthor: %s%nSubject: %s%nProducer: %s%nTrapped: %s%n", title, author, subject, producer,trapped);
		// 	// System.out.printf("Keywords: %s%n", keywords);
		// 	System.out.println("Text: " + text);
		try{
			FileInputStream inputStream = new FileInputStream(path);
			pdd = PDDocument.load(inputStream);
			PDFTextStripper textStripper = new PDFTextStripper();
			// String pageStart = textStripper.getPageStart();
			// System.out.printf("Start: %s%n", pageStart);
			// System.out.println("Paragraph end: " + textStripper.getParagraphEnd());
			System.out.println("Text of Document: " + textStripper.getText(pdd));

			inputStream.close();
		}catch(IOException e) {
			System.out.println("IOException on PDFInfo sample");
		}
	}
}