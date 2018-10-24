package com.company;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IndexOfLetters {
    public static void main(String[] args) throws Exception {

        Writer writeInput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inputP02"), "utf-8"));
        {
            writeInput.write("abcz");
//            writeInput.write("softuni");
        }
        writeInput.close();

        List<String> inputList = Files.readAllLines(Paths.get("inputP02"));

        List<Character> bufferList = new ArrayList<>();
        for (int i = 0; i < inputList.get(0).length(); i++) {
            bufferList.add(inputList.get(0).charAt(i));
        }

        Writer writerOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP02.txt"), "utf-8"));
        {
            for (Character character : bufferList) {
                writerOutput.write(String.format(character + " -> %d%n", (int)(character - 97)));
            }
        }
        writerOutput.close();
    }
}
