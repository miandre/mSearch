package com.company;

import java.util.HashMap;

/**
 * Created by Micke on 2016-08-02.
 */
public class IndexedWord {

    String document;
    HashMap<String,Integer> occurencies;
    int totalOccurencies;

    public IndexedWord(String document) {
        this.document = document;
        this.occurencies = new HashMap<>();
        this.totalOccurencies = 1;
        occurencies.put(document,1);
    }

    public void addOccurency(String document) {

        occurencies.put(document,occurencies.get(document)+1);
        totalOccurencies++;
    }
}
