package com.company;

import java.io.*;
import java.nio.file.*;


public class Main extends IOException {

    public static void main(String[] args) throws IOException {


        Path dir = Paths.get("files");

        System.out.println("Working Directory = " +
                dir.toAbsolutePath().toString());
        SearchEngine mSearch = new SearchEngine(dir);


    }
}
