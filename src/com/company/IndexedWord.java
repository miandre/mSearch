package com.company;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Micke on 2016-08-02.
 */
public class IndexedWord {

    String word;
    HashMap<String,Integer> occurencies;
    int totalOccurencies;

    public IndexedWord(String word) {
        this.word = word;
        this.occurencies = new HashMap<>();
        this.totalOccurencies = 1;

    }

    private void addOccurency(String document) {

        occurencies.put(document,occurencies.get(document)+1);
        totalOccurencies++;
    }
}
