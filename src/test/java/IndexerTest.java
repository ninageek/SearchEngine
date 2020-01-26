import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class IndexerTest {
    private static final String TEXT = "NinaGeek NinaGeek Welcome to NinaGeek Fuji My name is Nina.I'm learning how to code. My projects my projects My GitHub The new one The old one Contact me Telegram E-mail";

    Indexer indexer = new Indexer();

    @Test
    public void indexerTest() {
        indexer.addPageToIndex("http://ninageek.com");
        String addPage = indexer.getPageText("http://ninageek.com");
        assertEquals(TEXT, addPage);
    }
}
