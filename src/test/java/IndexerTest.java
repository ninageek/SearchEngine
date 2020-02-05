import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexerTest {

    Indexer indexer = new Indexer();

    @Test
    public void indexerTest() {
        indexer.addPageToIndex(Config.PAGE_ADDRESS);
        String pageText = indexer.getPageText(Config.PAGE_ADDRESS);
        assertEquals(Config.LOWER_CASE_TEXT, pageText);
    }
}
