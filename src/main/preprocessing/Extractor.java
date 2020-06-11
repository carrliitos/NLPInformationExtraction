import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extractor{
	public static void main(String[] args) {
		try{
			String link = "https://www.sciencedirect.com/science/article/pii/S2352644020300261";
			Document document = Jsoup.connect(link).get();

			Element content = document.getElementById("body");
			Elements paragraphs = document.getElementsByTag("h2");
			for(Element paragraph : paragraphs) {
				System.out.printf("Text: %s%nID: %s%n", paragraph.text(), paragraph.id());
				System.out.println();
			}
		}catch(IOException e){
			System.out.println("IOException on Extractor");
			return;
		}
	}
}