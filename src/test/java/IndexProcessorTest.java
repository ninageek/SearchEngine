import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IndexProcessorTest {
    IndexProcessor processor = new IndexProcessor();
    final static private int RES = 10;


    @Test
    public void checkIndexProcessor() {
        List<String> pagesAddresses = processor.loadPagesAddresses("Pages.txt");
        assertEquals(pagesAddresses.size(), RES);
    }

    @Test
    public void checkBuildIndex() {
        List<String> pagesAddresses = processor.loadPagesAddresses("Pages.txt");
        processor.buildIndex(pagesAddresses);
        String pageText = processor.getIndexer().getPageText(pagesAddresses.get(0));
        assertFalse(pageText.isEmpty());

    }

}
