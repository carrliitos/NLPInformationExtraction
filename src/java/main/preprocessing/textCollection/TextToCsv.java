/**
* This class converts all .txt files that holds all the output .pdf links and 
* and converts them to a .csv file for an easier handling.
*
* @author Benzon Carlitos Salazar
*/

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TextToCsv{
	public static void main(String[] args) {
		String path = "/home/carlitos/Documents/programs/NLPInformationExtraction/src/main/output.txt";
		List<PDFStore> pdfs;

		try{
			pdfs = readFile(path);
		}catch(FileNotFoundException a){
			System.out.println("Error: cannot find file.");
			return;
		}catch(IOException b) {
			System.out.println("Error while reading from file.");
			return;
		}

		try{
			writeFile(pdfs, "/home/carlitos/Documents/programs/NLPInformationExtraction/src/main/output.csv");
			System.out.println("Successfully wrote to file.");
		}catch(IOException c) {
			System.out.println("Error: could not write to file.");
			return;
		}
	}

	/**
	* A class that reads in a file using a String path and stores them in 
	* the {@code PDFStore} as links
	*
	* @param path a {@link String path} text file that holds all the the extracted PDFs
	* @return a {@link List list} of PDFs
	*/
	private static List<PDFStore> readFile(String path) throws FileNotFoundException, IOException {
		// Buffered reader for reading in files
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		// Store data
		ArrayList<PDFStore> pdfs = new ArrayList<>();
		reader.readLine();
		
		// Read in data
		String line;
		while((line = reader.readLine()) != null) {
			String[] columns = line.split(",");
			String articleURL = columns[0];
			String articleTitle = columns[1];

			// Create pdfs
			PDFStore pdf = new PDFStore(articleURL, articleTitle);
			pdfs.add(pdf);
		}

		// close reader
		reader.close();
		return pdfs;
	}

	/**
	* A class that writes all PDF links from text to csv
	*
	* @param pdfs all of the PDFs stored
	* @param path the csv path we want the PDF links stored in
	*/
	private static void writeFile(List<PDFStore> pdfs, String path) throws IOException {
		// Check to see if the file exists first
		File file = new File(path);
		if(!file.exists()) {
			file.createNewFile();
		}

		// Create file with text in it
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));

		// Create header
		writer.write("Link,Article");
		writer.newLine();

		// Print everything in our ArrayList
		for(int i = 0; i < pdfs.size(); i++) {
			PDFStore pdf = pdfs.get(i);
			String articleURL = pdf.getURL();
			String articleTitle = pdf.getTitle();

			String line = String.join(",", articleURL, articleTitle);

			// Write to file
			writer.write(line);
			writer.newLine();
		}

		// close writer
		writer.close();
	}
}