package com.ninageek;

import java.util.HashMap;
import java.util.Map;

public class Index {
    Map<String, String> indexMap = new HashMap<>();
    WebCrawler webCrawler = new WebCrawler();
    HtmlParser htmlParser = new HtmlParser();

    public void addPageToIndex(String pageAddress) {
        String pageText = webCrawler.getPageText(pageAddress);
        String parsedText = htmlParser.parseHtml(pageText);
        indexMap.put(pageAddress, parsedText);
    }

    public String getPageText(String pageAddress) {
        return indexMap.get(pageAddress);
    }

}
