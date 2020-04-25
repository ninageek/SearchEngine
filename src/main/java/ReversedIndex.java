import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReversedIndex {
    Map<String, List<String>> reversedIndex = new HashMap<>();
    WebCrawler webCrawler = new WebCrawler();
    HtmlParser htmlParser = new HtmlParser();

    public String[] getWordsFromPage(String pageAddress) {
        String pageText = webCrawler.getPageText(pageAddress);
        String parsedText = htmlParser.parseHtml(pageText);
        return parsedText.toLowerCase().split(" ");
    }

    public void addPageToIndex(String pageAddress) {
        String[] words = getWordsFromPage(pageAddress);
        for (String word : words) {
            if (!reversedIndex.containsKey(word)) {
                reversedIndex.put(word, new ArrayList<>());

            }
            reversedIndex.get(word).add(pageAddress);
        }
    }

    public List getLinks(String word) {
        return reversedIndex.get(word);
    }
}
