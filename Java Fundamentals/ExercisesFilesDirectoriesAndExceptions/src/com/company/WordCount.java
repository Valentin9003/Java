package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordCount {
    public static void main(String[] args) throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = Files.readAllLines(Paths.get("words.txt"));
        List<String> text = Files.readAllLines(Paths.get("text.txt"));



    }
}
