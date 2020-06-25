import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

import java.net.ConnectException;
import java.lang.NullPointerException;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class ReadPDFFromUrl {
	public static void main(String[] args) {
		try {
			URL url1 = new URL("https://pdf.sciencedirectassets.com/311966/1-s2.0-S2352644017X00058/1-s2.0-S2352644017300298/main.pdf?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEBAaCXVzLWVhc3QtMSJHMEUCIQC5pBnUBFS7afeHE9jarORcDfYbrcXFF4mTybnPE%2BaA3AIgQjIJpgFRFb6xl9ZoMyJtEbLLK3a75CsReQ1hHox3G%2BEqvQMImf%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARADGgwwNTkwMDM1NDY4NjUiDMB1EjaoDKuS8araSSqRAxbzioMR5d5NisAR6hokfCc4zcbfy45PSha5xv4%2Bm20sT7elnaH4c9HQ0THMyAQo36SEOhi%2BQepFf5P0NcMv5bpW7AsmYAZ%2FBI9Hgj1Qo89KgYqKn0bPLFaYe5oGe2N9ueG6bNmPr4dq2ibEFC1Q5TGTGT8uXQhglYtosqhpKNBvSOdZ65VHoDtUB%2FI5Wvm520qY8HROAlZe6BDQ0bbPixt6ldw08E3ARM30zh3gi06fKyw%2BWDFA5kMdnLF9i%2BNjofV6N%2F2g66kpa6uDjKtI9aSXxY4H2evnqADMqsaFpR7jeFchYlB7RU5LEaFHA5Cwp3ZqTjma0nNhBugi0tW4jxIWxUsL9SFXRydCqSh6fsJsGyM8KNj42mkaf8%2FVm%2BP2dkpd7GXu5cb8qH3v6MBCm7Lle3j5NFdDXI7fSh4k480AbG2tkfo8vwbjzKOwtnf48XaobKta%2BvL%2FuiKyhH4EttRL0hUeqLB8iZ1ojmBzdKOsrjjEU1WH67aVpM8Mz7C%2FLH2UCrqQuE8H19HMHcISvleoMLXOz%2FcFOusBpmFfpIjjiJpBFk9BElI8KswPQjrgu3JR0lKC1gKhL7st9ZNBogxt%2F4L2RPzVMXdbHjrS2To64Lf6AhxjmdDBgX%2F9ISqcPwnUvgb8r7eM6bTkaCLKCRjYH%2B10H3DYMMb7%2BejGzifqJVO40C%2B5wGCABTVG0sb8wHqi5AnQWJ0aMCZvuOLCTVGp6ihnlZtLLkCgYcKB51%2B6JZX3hJCqsmIfcm7STsExuXdWCGbk5inCyQD2NKjb%2BOaDErGJUaCzkthomtTvJOMkqoo6THOw%2FCrxdd7qZsuJaT4NUA5Cu3kMdxdV0bW7wmhwuVeiFQ%3D%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20200625T003213Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAQ3PHCVTY3VFQNHVR%2F20200625%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=24afa2704fd8f5d49f6db644bc266cab1659705030c67e5317c931ed4b3b1d88&hash=2143052a8ede8f1349932ba6cf1f62b1728af870798b94c54add8b176047748f&host=68042c943591013ac2b2430a89b270f6af2c76d8dfd086a07176afe7c76c2c61&pii=S2352644017300298&tid=spdf-4bc89a38-a219-40fa-bcf4-0282ed471c5d&sid=9533fd7868e01642966ba1d56abf3945a0c3gxrqa&type=client");
			byte[] ba1 = new byte[1024];
			int baLength;
			FileOutputStream outputStream1 = new FileOutputStream("/home/carlitos/Documents/WILL.pdf");

			try {
				// contacting the URL
				System.out.println("Contacting to " + url1.toString() + "...");
				URLConnection urlConn = url1.openConnection();

				// Checking whether the URL contains the PDF
				String contentType = urlConn.getContentType();
				System.out.println("Content type: " + contentType);

				if(!urlConn.getContentType().equalsIgnoreCase("application/pdf")) {
					System.out.println("FAILED. \n[Sorry. This is not a PDF]");
				}else {
					try {
						// Read the PDF from the URL and save to a local file
						InputStream inputStream1 = url1.openStream();
						while( (baLength = inputStream1.read(ba1)) != -1) {
							outputStream1.write(ba1, 0 , baLength);
						}
						outputStream1.flush();
						outputStream1.close();
						inputStream1.close();
						// Load the PDF document and display its page count
						System.out.println("DONE. \nProcessing the PDF...");
						PDDocument document = new PDDocument();
						try {
							File file = new File("/home/carlitos/Documents/WILL.pdf");
							document.load(file);
							System.out.println("DONE. \nNumber of pages in the PDF is: " + document.getNumberOfPages());
							document.close();
						}catch(Exception e) {
							System.out.println("FAILED.\n[" + e.getMessage() + "]");
						}
					}catch(ConnectException ce) {
						System.out.println("FAILED.\n[" + ce.getMessage() + "]\n");
					}
				}
			}catch(NullPointerException npe) {
				System.out.println("FAILED.\n[" + npe.getMessage() + "]\n");
			}
		}catch(MalformedURLException mue) {
			System.out.println("FAILED.\n[" + mue.getMessage() + "]\n");
		}catch(FileNotFoundException fnf) {
			System.out.println("FAILED.\n[" + fnf.getMessage() + "]\n");
		}catch(IOException ioe) {
			System.out.println("FAILED.\n[" + ioe.getMessage() + "]\n");
		}
	}
}