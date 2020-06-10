import java.io.IOException;
import java.net.URISyntaxException;

import java.io.File;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupTest {
	public static void main(String[] args) {
		/* Parsing an HTML String into a document object
		* Document document = Jsoup.parse(html);
		* document = document object representing the HTML DOM
		* Jsoup = main class to parse the given HTML String
		* html = HTML String

		String html = "<html><head><title>Sample Title</title></head>"
         + "<body><p>Sample Content</p></body></html>";
        Document document = Jsoup.parse(html);
        System.out.println(document.title());
        Elements paragraphs = document.getElementsByTag("p");
        for(Element paragraph : paragraphs) {
        	System.out.println(paragraph.text());
        }
		*/

		/* The connect(url) method makes a connection to the url and get() method return the html of the requested url.
		try{
			String url = "http://www.facebook.com";
			Document document = Jsoup.connect(url).get();
			System.out.println("Title: " + document.title());
		}catch(IOException e) {
			System.out.println("IO Exception on first try.");
		}
		*/

		/* Showcase fetching an HTML from the disk using a file and then find its data.
		* String url = "http://www.google.com";
		* Document document = Jsoup.connect(url).get();
		* document = document object representing the HTML DOM
		* Jsoup = main class to parse the given HTML String
		* url = url of the html page to load
		*/

		try{
			URL path = ClassLoader.getSystemResource("test.html");
			File input = new File(path.toURI());
			Document document = Jsoup.parse(input, "UTF-8");
			System.out.println("Title of document: " + document.title());
		}catch(IOException e) {
			System.out.println("IO exception on try with URL path for test.html");
		}catch(URISyntaxException f){
			System.out.println("URI Syntax Exception here");
		}

		/*
		* Following example will showcase use of DOM like methods after parsing an HTML String into a Document object
		* document = document object represents the HTML DOM
		* Jsoup = main class to parse the given HTML String
		* html = HTML String
		* sampleDiv = Element object represent the html node element identified by id "sampleDiv".
		* links = Elements object represents the multiple node elements identified by tag "a".
		* 
		* The parse(String html) method parses the input HTML into a new Document. This document object can be used to traverse and get details of the html dom.
		*/

		String html = "<html><head><title>Sample Title</title></head>"
						+ "<body>"
						+ "<p>Sample Content</p>"
						+ "<div id='sampleDiv'><a href='www.google.com'>Google</a></div>"
						+"</body></html>";
		Document document = Jsoup.parse(html);
		System.out.println("Title: " + document.title());
		Elements paragraphs = document.getElementsByTag("p");
		for(Element paragraph : paragraphs) {
			System.out.println("Paragraphs: " + paragraph.text());
		}

		Element sampleDiv = document.getElementById("sampleDiv");
		System.out.println("Data: " + sampleDiv.text());
		Elements links = sampleDiv.getElementsByTag("a");
		for (Element link : links) {
			System.out.println("Href: " + link.attr("href"));
			System.out.println("Text: " + link.text());
		}		
	}
}