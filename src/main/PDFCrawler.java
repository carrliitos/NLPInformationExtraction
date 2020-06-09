import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PDFCrawler{
	public static void main(String[] args) {
		try{
			String[] urls = {
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/20/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/21/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/22/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/23/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/24/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/25/",
			};
			int pdfTotal = 0;
			int urlCount = 0;
			for(String url : urls){
				Document document = Jsoup.connect(url).get();
				urlCount++;
				System.out.println("===========================================");
				System.out.printf("Fetching %s ...%n", url);
				System.out.printf("Journal Title: %s%n", document.title());
				System.out.println();

				Elements titles = document.getElementsByClass("anchor article-content-title u-margin-xs-top u-margin-s-bottom");
				System.out.printf("Total Case Report Extracted = %d%n", (titles.size() - 1));
				System.out.println();
				int j = 0;
				for(Element title : titles) {
					System.out.printf("Case Report [%d]: %s%n", j, title.text());
					System.out.printf("PDF Link: %s%n", title.attr("abs:href"));
					System.out.println();
					j++;
					pdfTotal++;
				}
			}
			System.out.printf("Total PDFs extracted: %d%n", pdfTotal);
			System.out.printf("Total URLs crawled: %d%n", urlCount);

		}catch(IOException e) {
			System.out.println("IO Exception on this line.");
		}
	}
}