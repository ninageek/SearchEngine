package com.ninageek;

import com.ninageek.Config;
import com.ninageek.ReversedIndex;
import org.junit.Test;

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
