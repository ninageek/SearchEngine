import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class IndexerTest {

    Indexer indexer = new Indexer();

    @Test
    public void indexerTest() {
        indexer.addPageToIndex(Config.PAGE_ADDRESS);
        String addPage = indexer.getPageText(Config.PAGE_ADDRESS);
        assertEquals(Config.TEXT, addPage);
    }
}
