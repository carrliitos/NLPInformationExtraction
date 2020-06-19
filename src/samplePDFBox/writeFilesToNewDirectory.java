/** 
*	This is a sample class for writing files into a new directory
* 	The idea is that once we're done processing pdf files and convert
* 	them to raw text files, we then transfer each processed files
* 	to a the new directory.
*
* 	Since this is still a test program, we will only transfer pdf files 
* 	from one directory to another.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class writeFilesToNewDirectory {
	public static void main(String[] args) {
		try {
			// // Use scanner for all input files
			// File inputDirectory = new File("/home/carlitos/Documents/Projects/git/NLPInformationExtraction/src/samplePDFBox/sampleDirectory");
			// boolean success = false;

			// // Create the new directory
			// File newDirectory = new File();
			// if(newDirectory.exists()) {
			// 	System.out.println("Directory already exists.");
			// }else {
			// 	System.out.println("Directory does not exist, creating now.");
			// 	// Loop through the files from the old directory
			// 	File[] files = inputDirectory.listFiles();
			// 	for(File file : files) {
			// 		// Store each files to the newDirectory
			// 		if(file.exists()) {
			// 			System.out.println("File already exist... \nMoving on...");
			// 		}else {
			// 			file.createNewFile();
			// 		}
			// 	}
			// 	success = newDirectory.mkdir();
			// }

			// // Create the new directory
			// String dir = "/home/carlitos/Documents/Projects/git/NLPInformationExtraction/src/samplePDFBox/sample1";
			// File newDirectory = new File(dir);
			// if(newDirectory.exists()) {
			// 	System.out.printf("Directory already exists: %n%s%n", dir);
			// }else {
			// 	// create the new directory
			// 	newDirectory.mkdir();
			// 	System.out.printf("Created the new directory: %n%s%n", newDirectory);

			// 	// Store the files from old directory to new one
			// 	File oldDir = new File("/home/carlitos/Documents/Projects/git/NLPInformationExtraction/src/samplePDFBox/sampleDirectory");
			// 	File[] files = oldDir.listFiles();
			// 	// Loop through the old file
			// 	for(File file : files) {
			// 		File createdFile = new File(file);
			// 		BufferedWriter writer = new BufferedWriter(new FileWriter(createdFile));
			// 	}
			// }

			
		}catch(IOException e) {
			System.out.println("IOException while creating new directory");
		}
	}
}