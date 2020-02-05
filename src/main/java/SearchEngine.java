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

    public List<String> search(String pages, String term) {
        List<String> ret = new ArrayList<>();
        List<String> pagesAddresses = processor.loadPagesAddresses(pages);
        for (String address : pagesAddresses) {
            String pageText = processor.getIndex().getPageText(address);
            if (pageText.contains(term.toLowerCase())) {
                ret.add(address);
            }
        }

        return ret;
    }

}
