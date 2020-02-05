import java.util.HashMap;
import java.util.Map;

public class Indexer {
    Map<String, String> index = new HashMap<>();
    WebCrawler webCrawler = new WebCrawler();
    HtmlParser htmlParser = new HtmlParser();

    public void addPageToIndex(String pageAddress) {
        String pageText = webCrawler.getPageText(pageAddress);
        String parsedText = htmlParser.parseHtml(pageText);
        index.put(pageAddress, parsedText.toLowerCase());
    }

    public String getPageText(String pageAddress) {
        return index.get(pageAddress);
    }

}
