import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {

    IndexProcessor processor = new IndexProcessor();


    public IndexProcessor getProcessor() {
        return processor;
    }

    public void updateIndex(String pages) {
        List<String> pagesAddresses = processor.loadPagesAddresses(pages);
        processor.buildIndex(pagesAddresses);
    }

    public List<SearchResult> search(String term) {
        List<SearchResult> ret = new ArrayList<>();
        Set<String> pagesAddresses = processor.getReversedIndex().getLinks(term.toLowerCase());
        if (pagesAddresses == null || pagesAddresses.isEmpty()) {
            return ret;
        }


        String regex = " (" + term.toLowerCase() + ")[^a-z]";
        Pattern pattern = Pattern.compile(regex);

        for (String address : pagesAddresses) {
            String pageText = processor.getIndex().getPageText(address);
            Matcher matcher = pattern.matcher(pageText.toLowerCase());

            if (matcher.find()) {

                String context = getContext(pageText, term);
                SearchResult searchResult = new SearchResult(address, context);
                ret.add(searchResult);


            }
        }

        return ret;
    }

    public String getContext(String pageText, String term) {
        int positionOfTerm = -1;
        String regex = " (" + term.toLowerCase() + ")[^a-z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pageText.toLowerCase());

        if (matcher.find()) {
            positionOfTerm = matcher.start();
        }

        if (positionOfTerm == -1) {
            return "";
        }

        int currentBeginIndex = positionOfTerm;
        int currentEndIndex = positionOfTerm;

        while (pageText.charAt(currentBeginIndex) != '.') {
            if (currentBeginIndex == 0) {
                break;
            }

            currentBeginIndex--;


        }
        while (pageText.charAt(currentEndIndex) != '.') {
            if (currentEndIndex < pageText.length() - 1) {
                currentEndIndex++;
            }

        }

        return pageText.substring(currentBeginIndex + 1, currentEndIndex + 1);
    }

}
