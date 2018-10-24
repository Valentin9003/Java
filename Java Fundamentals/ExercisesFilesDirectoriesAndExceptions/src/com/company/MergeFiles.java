package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeFiles {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input1 = Files.readAllLines(Paths.get("input1.txt"));
        List<String> input2 = Files.readAllLines(Paths.get("input2.txt"));

        List<String> myList = new ArrayList<>();
        myList.addAll(input1);
        myList.addAll(input2);
        Collections.sort(myList);

        FileWriter fr = new FileWriter("Output.txt");
        for (int i = 0; i < myList.size(); i++) {
            fr.write(myList.get(i) + "\r\n");
        }
        fr.close();

    }
}
