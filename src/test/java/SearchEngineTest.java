import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchEngineTest {
    SearchEngine searchEngine = new SearchEngine();

    @Test
    public void updateIndexTest(){
        searchEngine.updateIndex(Config.TEST_PAGES);
        IndexProcessor processor = searchEngine.getProcessor();
        List<String> pagesAddresses = processor.loadPagesAddresses(Config.TEST_PAGES);
        String pageText = processor.getIndexer().getPageText(pagesAddresses.get(0));
        assertFalse(pageText.isEmpty());
    }

    @Test
    public void searchFoundTest(){
        searchEngine.updateIndex(Config.TEST_PAGES);
        List<String> searchResult = searchEngine.search(Config.TEST_PAGES, "war");
        assertTrue(searchResult.contains(Config.SCIPIO));
    }

    @Test
    public void searchNotFoundTest(){
        searchEngine.updateIndex(Config.TEST_PAGES);
        List<String> searchResult = searchEngine.search(Config.TEST_PAGES, "knize");
        assertFalse(searchResult.contains(Config.SCIPIO));
    }
}
