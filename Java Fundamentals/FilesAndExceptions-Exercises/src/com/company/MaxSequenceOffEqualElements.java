package com.company;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MaxSequenceOffEqualElements {
    public static void main(String[] args) throws Exception {

        Writer writerInput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inputP04.txt"), "utf-8"));
            {
               writerInput.write("3 4 4 5 5 5 2 2");
//               writerInput.write("7 7 4 4 5 5 3 3");
//               writerInput.write("1 2 3 3");
            }
            writerInput.close();

        List<String> inputList = Files.readAllLines(Paths.get("inputP04.txt"));
        String[] inputArr = inputList.get(0).split(" ");

        int count = 0;
        int number = 0;
        for (int i = 0; i < inputArr.length; i++) {
            int bufferNumber = Integer.parseInt(inputArr[i]);
            int bufferCount = 1;
            for (int j = i + 1; j < inputArr.length; j++) {
                int num = Integer.parseInt(inputArr[j]);
                if (num == bufferNumber) {
                    bufferCount++;
                }
            }
            if (bufferCount > count) {
                count = bufferCount;
                number = bufferNumber;
            }
        }

        Writer writerOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP04.txt"), "utf-8"));
            {
                for (int i = 0; i < count; i++) {
                    writerOutput.write(String.format("%d ", number));
                }
            }
        writerOutput.close();
    }
}
