/**
*
* @author BC Salazar
* This program is for converting the .txt files that holds
* 	all of the extracted .pdf files to a .csv file for a more
* 	easier way of handling data.
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

		// Read the file
		try{
			pdfs = readFile(path);
		}catch(FileNotFoundException a){
			System.out.println("Error: cannot find file.");
			return;
		}catch(IOException b) {
			System.out.println("Error while reading from file.");
			return;
		}

		// Write to a new file
		try{
			writeFile(pdfs, "/home/carlitos/Documents/programs/NLPInformationExtraction/src/main/output.csv");
			System.out.println("Successfully wrote to file.");
		}catch(IOException c) {
			System.out.println("Error: could not write to file.");
			return;
		}
	}

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

	private static void writeFile(List<PDFStore> pdfs, String path) throws IOException {
		// Check to see if the file exists first
		File file = new File(path);
		if(!file.exists()) {
			file.createNewFile();
		}

		// Create file with text in it
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));

		// Create heade
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