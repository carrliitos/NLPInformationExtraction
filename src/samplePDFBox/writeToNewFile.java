import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class writeToNewFile {
	public static void main(String[] args) {
		try {
			String dir = "/home/carlitos/Documents/Projects/git/NLPInformationExtraction/src/samplePDFBox/";
			boolean success = false;

			// Create a new directory, if it doesn't exist
			File directory = new File(dir);
			if(directory.exists()) {
				System.out.println("Directory alreay exists... ");
			}else {
				System.out.println("Directory does not exist, creating now.");

				success = directory.mkdir();
				if(success) {
					System.out.printf("Successfully created new directory: %s%n", dir);
				}else {
					System.out.printf("Failed to create new directory: %s%n", dir);
				}
			}

			// Create a new file, if it does not exist
			String filename = "temp.txt";
			File file = new File(filename);
			if(file.exists()) {
				System.out.println("File already exists."); 
			}else {
				System.out.println("No such file exists, creating now.");

				success = file.createNewFile();
				if(success) {
					System.out.printf("Successfully created new file: %s%n", file);
				}else {
					System.out.printf("Failed to create new file: %s%n", file);
				}
			}
		}catch(IOException e) {
			System.out.println("IOException on writing.");
			return;
		}
	}
}