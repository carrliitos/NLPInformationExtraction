import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* Parsing an HTML String into a document object
* Document document = Jsoup.parse(html);
* document = document object representing the HTML DOM
* Jsoup = main class to parse the given HTML String
* html = HTML String
*/

public class JsoupTest {
	public static void main(String[] args) {
		String html = "<html><head><title>Sample Title</title></head>"
         + "<body><p>Sample Content</p></body></html>";
        Document document = Jsoup.parse(html);
        System.out.println(document.title());
        Elements paragraphs = document.getElementsByTag("p");
        for(Element paragraph : paragraphs) {
        	System.out.println(paragraph.text());
        }
	}
}