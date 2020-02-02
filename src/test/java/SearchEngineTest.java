import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void checkSearch(){
        searchEngine.updateIndex(Config.TEST_PAGES);
        List<String> searchResult = searchEngine.search(Config.TEST_PAGES, "war");
        assertTrue(searchResult.contains("https://en.wikipedia.org/wiki/Scipio_Africanus"));
    }
}
