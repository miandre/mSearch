package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import sun.misc.Regexp;

import javax.print.DocFlavor;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends IOException {

    public static void main(String[] args) throws IOException {


        Path dir = Paths.get("files");

        System.out.println("Working Directory = " +
                dir.toAbsolutePath().toString());



            List<Path> result = new ArrayList<>();

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{txt}")) {
                for (Path entry: stream) {
                    result.add(entry);
                    List<String> allLines = Files.readAllLines(entry);
                    for (String s:allLines
                         ) {
                        System.out.println(s);
                        String[] words = s.trim().split("\\W+");
                        System.out.println(words[0]);

                    }
                }
            } catch (DirectoryIteratorException ex) {
                // I/O error encounted during the iteration, the cause is an IOException
                throw ex.getCause();
            }




    }
}
