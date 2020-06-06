package com.ninageek;

import java.util.*;

public class ReversedIndex {
    Map<String, Set<String>> reversedIndex = new HashMap<>();
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
            if (!reversedIndex.containsKey(word)) {
                reversedIndex.put(word, new HashSet<>());

            }
            reversedIndex.get(word).add(pageAddress);
        }
    }

    public Set<String> getLinks(String word) {
        return reversedIndex.get(word);
    }
}
