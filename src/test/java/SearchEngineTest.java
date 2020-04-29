import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchEngineTest {
    SearchEngine searchEngine = new SearchEngine();

    @Test
    public void updateIndexTest() {
        searchEngine.updateIndex(Config.TEST_PAGES);
        IndexProcessor processor = searchEngine.getProcessor();
        List<String> pagesAddresses = processor.loadPagesAddresses(Config.TEST_PAGES);
        String pageText = processor.getIndex().getPageText(pagesAddresses.get(0));
        assertFalse(pageText.isEmpty());
    }

    @Test
    public void searchFoundTest() {
        searchEngine.updateIndex(Config.TEST_PAGES);
        List<SearchResult> searchResult = searchEngine.search("code");
        SearchResult searchResultTest = new SearchResult("http://ninageek.com", "I'm learning how to code.");
        assertTrue(searchResult.contains(searchResultTest));
    }

    @Test
    public void searchNotFoundTest() {
        searchEngine.updateIndex(Config.TEST_PAGES);
        List<SearchResult> searchResult = searchEngine.search("knize");
        assertTrue(searchResult.isEmpty());
    }

    @Test
    public void getContextTest() {
        String context = searchEngine.getContext(Config.TEST_PAGE_TEXT, "index");
        assertEquals(Config.TEST_CONTEXT, context);


    }
    @Test
    public void searchFoundCaseSensitiveTest(){
        searchEngine.updateIndex(Config.TEST_PAGES);
        List<SearchResult> searchResult = searchEngine.search("NinaGeek");
        SearchResult searchResultTest = new SearchResult("http://ninageek.com", "inaGeek NinaGeek Welcome to NinaGeek Fuji My name is Nina.");
        assertTrue(searchResult.contains(searchResultTest));
    }
}
