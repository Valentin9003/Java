package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EqualSums {
    public static void main(String[] args) throws Exception {

        Writer writeInputFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inputP03"), "utf-8"));
        {
            writeInputFile.write("1 2 3 3");
//            writeInputFile.write("1 2");
//            writeInputFile.write("1");
//            writeInputFile.write("1 2 3");
//            writeInputFile.write("10 5 5 99 3 4 2 5 1 1 4");
        }
        writeInputFile.close();

        List<String> inputList = Files.readAllLines(Paths.get("inputP03"));
        String[] newArr = inputList.get(0).split(" ");

        int resullt = 0;
        if (newArr.length == 1) {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP03.txt"), "utf-8"));
                {
                   writer.write(String.format(inputList.get(0) + " -> at index %d", resullt));
                }
            writer.close();
            return;
        }
        else
            {
                for (int i = 0; i < newArr.length; i++)
                {
                    int leftSum = 0;
                    int rightSum = 0;
                    for (int j = 0; j < i ; j++) {
                        leftSum += Integer.parseInt(newArr[j]);
                    }
                    for (int j = i + 1; j < newArr.length ; j++) {
                        rightSum += Integer.parseInt(newArr[j]);
                    }

                    if (leftSum == rightSum)
                    {
                        resullt = i;
                        break;
                    }
                }
            }
        if (resullt == 0) {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP03.txt"), "utf-8"));
                {
                   writer.write(inputList.get(0) + " -> no");
                }
                writer.close();
        }
        else {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP03.txt"), "utf-8"));
                {
                    writer.write(String.format(inputList.get(0) + " -> at index %d", resullt));
                }
                writer.close();
        }
    }
}
