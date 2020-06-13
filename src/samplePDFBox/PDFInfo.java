/**
* @author BC Salazar
* Sample use of PDFBox for extracting information out of PDFs
*/

import java.io.IOException;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class PDFInfo {
	public static void main(String[] args) {
		String path = "/home/carlitos/Documents/Research/MedicalIntent/CaseReports/CamelBite.pdf";
		File file = new File(path);

		try{
			// Load the pdf file
			PDDocument document = new PDDocument();
			document = PDDocument.load(file);

			// Get the PDDocumentInformation object from the PDDocument created
			PDDocumentInformation information = document.getDocumentInformation();

			String title = information.getTitle();
			String author = information.getAuthor();
			String subject = information.getSubject();
			String producer = information.getProducer();
			String trapped = information.getTrapped();
			
			System.out.printf("Title: %s%nAuthor: %s%nSubject: %s%nProducer: %s%nTrapped: %s%n", title, author, subject, producer,trapped);
		}catch(IOException e) {
			System.out.println("IOException on PDFInfo sample");
			return;
		}
	}
}