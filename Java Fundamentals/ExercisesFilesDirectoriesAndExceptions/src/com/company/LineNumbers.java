package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = Files.readAllLines(Paths.get("OddLines.txt"));

        FileWriter fr = new FileWriter("LineNumbersOfOddLines.txt");
        for (int i = 0; i < lines.size(); i++) {
            fr.write((i + 1) + ". " + lines.get(i) + "\r\n");
        }
        fr.close();
    }
}
