package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MostFrequentNumber {
    public static void main(String[] args) throws Exception {

        Writer writerInput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inputP01.txt"), "utf-8"));
        {
            writerInput.write("4 1 1 4 2 3 4 4 1 2 4 9 3");
//            writer.write("2 2 2 2 1 2 2 2");
//            writer.write("7 7 7 0 2 2 2 0 10 10 10");
        }
        writerInput.close();

        List<String> inout = Files.readAllLines(Paths.get("inputP01.txt"));

        String[] inputArr = inout.get(0).split(" ");

        int number = 0;
        int count = 0;

        for (int i = 0; i < inputArr.length; i++) {
            int br = 1;
            for (int j = i + 1; j <inputArr.length; j++) {
                if (inputArr[i].equals(inputArr[j]))
                {
                    br++;
                }
            }
            if (br > count) {
                count = br;
                number = Integer.parseInt(inputArr[i]);
            }
        }

        Writer writerOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP01.txt"), "utf-8"));
        {
            writerOutput.write(String.format("The number %d is the most frequent (occurs %d times)", number, count));
        }
        writerOutput.close();
    }
}
