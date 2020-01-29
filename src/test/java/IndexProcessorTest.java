import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IndexProcessorTest {
    IndexProcessor processor = new IndexProcessor();
    final static private int RES = 10;


    @Test
    public void checkIndexProcessor() {
        List<String> result = processor.loadPagesAddresses("Pages.txt");
        assertEquals(result.size(), RES);
    }
}
