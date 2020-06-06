package com.ninageek;

import com.ninageek.Config;
import com.ninageek.IndexProcessor;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IndexProcessorTest {
    IndexProcessor processor = new IndexProcessor();
    final static private int RES = 2;


    @Test
    public void loadPageAddressesTest() {
        List<String> pagesAddresses = processor.loadPagesAddresses(Config.TEST_PAGES);
        assertEquals(RES, pagesAddresses.size());
    }

    @Test
    public void buildIndexTest() {
        List<String> pagesAddresses = processor.loadPagesAddresses(Config.TEST_PAGES);
        processor.buildIndex(pagesAddresses);
        String pageText = processor.getIndex().getPageText(pagesAddresses.get(0));
        assertFalse(pageText.isEmpty());

    }

}
