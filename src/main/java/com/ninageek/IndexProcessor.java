package com.ninageek;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndexProcessor {

    Index index = new Index();
    ReversedIndex reversedIndex = new ReversedIndex();

    public ReversedIndex getReversedIndex() {
        return reversedIndex;
    }

    public Index getIndex() {
        return index;
    }

    public List<String> loadPagesAddresses(String myFile) {
        List<String> pagesAddress = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(myFile);
        if (stream != null) {
            Scanner pageReader = new Scanner(stream);
            while (pageReader.hasNextLine()) {
                pagesAddress.add(pageReader.nextLine());
            }
            pageReader.close();
        }
        return pagesAddress;
    }

    public void buildIndex(List<String> pagesAddress) {

        for (String address : pagesAddress) {
            index.addPageToIndex(address);
            reversedIndex.addPageToIndex(address);
        }


    }


}

