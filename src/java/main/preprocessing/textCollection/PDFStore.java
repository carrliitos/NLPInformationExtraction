/**
* This is a util class used for storing all PDFs extracted in either a .csv
* or .txt format
*
* @author Benzon Carlitos Salazar
*/

public final class PDFStore {
	private final String articleTitle;
	private final String articleURL;

	public PDFStore(String articleURL, String articleTitle) {
		this.articleURL = articleURL;
		this.articleTitle = articleTitle;
	}

	public String getTitle() { return articleTitle; }
	public String getURL() { return articleURL; }

	@Override
	public String toString() {
		return String.format("URL: %s [%s]", articleURL, articleTitle);
	}
}