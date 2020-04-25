import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReversedIndexTest {
    ReversedIndex index = new ReversedIndex();

    @Test
    public void indexerTest() {
        index.addPageToIndex(Config.PAGE_ADDRESS);
        String[] words = index.getWordsFromPage(Config.PAGE_ADDRESS);
        for (String word : words) {
            assertTrue(index.getLinks(word).contains(Config.PAGE_ADDRESS));
        }

    }
}
