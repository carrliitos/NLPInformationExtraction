import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFManager {
	public static void main(String[] args) {
		String path = "output.csv";
		ArrayList<PDFStore> pdfs;
		try {
			pdfs = readFile(path);
		}catch(IOException e) {
			System.out.println("Error while reading from file");
			return;
		}

		// Experiment with the data here

		// try{
		// 	String path = "/home/carlitos/Documents/Research/MedicalIntent/CaseReports/CamelBite.pdf";
		// 	FileInputStream inputStream = new FileInputStream(path);
		// 	// Load an existing PDF document
		// 	PDDocument document = PDDocument.load(inputStream);
		// 	// Instantiate PDFTextStripper
		// 	PDFTextStripper textStripper = new PDFTextStripper();
		// 	// Retrieve the text
		// 	String text = textStripper.getText(document);

		// 	System.out.println(text);
		// 	document.close();
		// }catch(IOException e) {
		// 	System.out.println("Error: IO Exception.");
		// 	return;
		// }
	}

	private static ArrayList<PDFStore> readFile(String path) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		ArrayList<PDFStore> pdfs = new ArrayList<>();
		reader.readLine();
		String line;
		while((line = reader.readLine()) != null) {
			String[] columns = line.split(",");
			String url = columns[1];
			// String title = columns[2];

			PDFStore pdfStore = new PDFStore(url);
			pdfs.add(pdfStore);
		}
		reader.close();
		return pdfs;
	}
}