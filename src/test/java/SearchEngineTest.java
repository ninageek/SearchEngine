import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class SearchEngineTest {
    SearchEngine searchEngine = new SearchEngine();

    @Test
    public void checkUpdateIndex(){
        searchEngine.updateIndex(Config.TEST_PAGES);
        IndexProcessor processor = searchEngine.getProcessor();
        List<String> pagesAddresses = processor.loadPagesAddresses(Config.TEST_PAGES);
        String pageText = processor.getIndexer().getPageText(pagesAddresses.get(0));
        assertFalse(pageText.isEmpty());
    }
}
