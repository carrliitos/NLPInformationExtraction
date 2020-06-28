import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtractText {
	public static void main(String[] args) {
		try{
		// load an existing document
		File file = new File("/home/carlitos/Documents/programs/NLPInformationExtraction/src/java/CaseReports/OralCyst.pdf");
		PDDocument doc = PDDocument.load(file);

		// instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();

		// retrieve text from PDF Document
		String text = pdfStripper.getText(doc);
		System.out.println("Text in PDF\n===================================");
		// System.out.println(text);

		// Returns the string which will be used at the end of an article.
		String articleEnd = pdfStripper.getText(doc).getArticleEnd();
		System.out.println("Article Ending.");
		System.out.println(articleEnd);

		// close the document
		doc.close();
		
		}catch(IOException e) {
			System.out.println("FAILED.\n[" + e.getMessage() + "]\n");
		}
	}
}