package com.ninageek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReversedIndex {
    Map<String, Set<String>> reversedIndexMap = new HashMap<>();
    WebCrawler webCrawler = new WebCrawler();
    HtmlParser htmlParser = new HtmlParser();


    public String[] getWordsFromPage(String pageAddress) {
        String pageText = webCrawler.getPageText(pageAddress);
        String parsedText = htmlParser.parseHtml(pageText);
        return parsedText.toLowerCase().replaceAll("[.!?]", " ").split(" ");
    }

    public void addPageToIndex(String pageAddress) {
        String[] words = getWordsFromPage(pageAddress);
        for (String originalWord : words) {
            String word = originalWord.toLowerCase();
            if (!reversedIndexMap.containsKey(word)) {
                reversedIndexMap.put(word, new HashSet<>());

            }
            reversedIndexMap.get(word).add(pageAddress);
        }
    }

    public Set<String> getLinks(String word) {
        return reversedIndexMap.get(word);
    }
}
