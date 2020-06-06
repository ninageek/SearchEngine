package com.ninageek;

import com.ninageek.Config;
import com.ninageek.Index;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IndexTest {

    Index index = new Index();

    @Test
    public void indexerTest() {
        index.addPageToIndex(Config.PAGE_ADDRESS);
        String pageText = index.getPageText(Config.PAGE_ADDRESS);
        assertEquals(Config.TEXT, pageText);
    }
}
