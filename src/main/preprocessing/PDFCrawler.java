import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PDFCrawler{
	public static void main(String[] args) {
		try{
			String[] links = {
				// Trauma Case Reports
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/10/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/11/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/12/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/13/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/14/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/15/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/16/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/17/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/18/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/19/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/20/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/21/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/22/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/23/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/24/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/25/",
				// "https://www.sciencedirect.com/journal/trauma-case-reports/vol/26/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/27/",
			};
			PDFCrawler(links);
		}catch(IOException e) {
			System.out.println("IO Exception on PDFCrawler.");
			return;
		}
	}

	private static void PDFCrawler(String[] links) throws IOException{
		String[] urls = links;
		System.out.println("Link,Title");
		for(String url : urls){
			Document document = Jsoup.connect(url).get();
			Elements titles = document.getElementsByClass("anchor article-content-title u-margin-xs-top u-margin-s-bottom");
			for(Element title : titles) {
				System.out.printf("%s,%s%n", title.attr("abs:href"), title.text());
			}
		}
	}
}