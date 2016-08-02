package com.company;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Micke on 2016-08-02.
 */
public class SearchEngine {

    HashMap<String, IndexedWord> index;
    Path dir;

    public SearchEngine(Path dir) throws IOException {
        this.index =new HashMap<>();
        this.dir = dir;
        indexFiles();
    }

    private void indexFiles() throws IOException {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{txt}")) {
            for (Path entry: stream) {
                List<String> allLines = Files.readAllLines(entry);
                String filename = entry.toString().split("\\W+")[1];
                for (String s:allLines
                        ) {
                    String[] words = s.trim().split("\\W+");
                    if(words.length>0) {

                        for (int i = 0; i<words.length; i++)
                            addWord(words[i],filename);
                    }
                }
            }
        } catch (DirectoryIteratorException ex) {
            // I/O error encounted during the iteration, the cause is an IOException
            throw ex.getCause();
        }

    }

    private void addWord(String word, String filename) {

        if (!index.containsKey(word)) {
            index.put(word, new IndexedWord(filename));
            System.out.println("Indexing word / document: " + word+ " / " + index.get(word).document);
            System.out.println("Occurencies in document: " + index.get(word).occurencies.get(filename));
        }else {
            index.get(word).addOccurency(filename);
            System.out.println("Occurencies of "+word+ " : " + index.get(word).occurencies.get(filename));
        }
    }

}
