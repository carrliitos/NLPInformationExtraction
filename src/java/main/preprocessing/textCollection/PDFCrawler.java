/**
* 
* @author BC Salazar
* This PDF Crawler is for extracting all the pdf articles and their links
* 	for further research purposes
*/

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
				// Trauma Case Reports -- uncomment to extract all desired cases
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/10/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/11/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/12/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/13/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/14/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/15/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/16/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/17/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/18/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/19/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/20/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/21/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/22/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/23/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/24/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/25/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/26/",
				"https://www.sciencedirect.com/journal/trauma-case-reports/vol/27/",
			};
			PDFCrawler(links);
		}catch(IOException e) {
			System.out.println("IO Exception on PDFCrawler.");
			return;
		}
	}

	private static String[] PDFCrawler(String[] links) throws IOException{
		String[] urls = links;
		System.out.println("Link,Title");
		for(String url : urls){
			Document document = Jsoup.connect(url).get();
			Elements articles = document.getElementsByClass("js-article article-content");
			for(Element article : articles) {
				Elements pdfLinks = article.getElementsByClass("anchor pdf-download u-margin-l-right text-s");
				Elements titles = article.select("h3");				
				System.out.printf(("%s,%s%n"), pdfLinks.attr("abs:href"), titles.text());
			}
		}
		return links;
	}
}