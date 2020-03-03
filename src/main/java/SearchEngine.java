import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    IndexProcessor processor = new IndexProcessor();


    public IndexProcessor getProcessor() {
        return processor;
    }

    public void updateIndex(String pages) {
        List<String> pagesAddresses = processor.loadPagesAddresses(pages);
        processor.buildIndex(pagesAddresses);
    }

    public List<SearchResult> search(String pages, String term) {
        List<SearchResult> ret = new ArrayList<>();
        List<String> pagesAddresses = processor.loadPagesAddresses(pages);

        SearchEngine searchEngine = new SearchEngine();
        for (String address : pagesAddresses) {
            String pageText = processor.getIndex().getPageText(address);
            if (pageText.contains(term.toLowerCase())) {

                String context = searchEngine.getContext(pageText, term);
                SearchResult searchResult = new SearchResult(address, context);
                ret.add(searchResult);


            }
        }

        return ret;
    }

    public String getContext(String pageText, String term) {
        String searchTerm = " " + term + " ";
        int positionOfTerm = pageText.indexOf(searchTerm);
        int currentBeginIndex = positionOfTerm;
        int currentEndIndex = positionOfTerm;

        while (pageText.charAt(currentBeginIndex) != '.') {
            if(currentBeginIndex >= 1){
                currentBeginIndex--;
            }

        }
        while (pageText.charAt(currentEndIndex) != '.') {
            if(currentEndIndex < pageText.length() - 1){
                currentEndIndex++;
            }

        }

        return pageText.substring(currentBeginIndex + 1, currentEndIndex + 1);
    }

}
