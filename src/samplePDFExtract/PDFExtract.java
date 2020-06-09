import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PDFExtract {
	public static void main(String[] args) {

		try{
			String url = "https://www.sciencedirect.com/journal/trauma-case-reports/vol/25/";
			Document document = Jsoup.connect(url).get();

			System.out.printf("Fetching %s ...%n", url);
			System.out.printf("Journal Title: %s%n", document.title());
			System.out.println();

			Elements titles = document.getElementsByClass("anchor article-content-title u-margin-xs-top u-margin-s-bottom");
			System.out.printf("Total Case Report Extracted = %d%n", (titles.size() - 1));
			System.out.println();
			int i = 0;
			for(Element title : titles) {
				System.out.printf("Case Report [%d]: %s%n", i, title.text());
				System.out.printf("Links: %s%n", title.attr("abs:href"));
				System.out.println();
				i++;
			}
		}catch(IOException e) {
			System.out.println("IO Exception on this line.");
		}
	}
}