package com.company;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;

public class FixEmails {
    public static void main(String[] args) throws Exception {

        Writer writerInput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inputP06")));
        {
            writerInput.write("Ivan\n");
            writerInput.write("ivanivan@abv.bg\n");
            writerInput.write("Petar Ivanov\n");
            writerInput.write("petartudjarov@abv.bg\n");
            writerInput.write("Mike Tyson\n");
            writerInput.write("myke@gmail.us\n");
            writerInput.write("stop");
        }
        writerInput.close();

        List<String> inputList = Files.readAllLines(Paths.get("inputP06"));
        inputList.remove(inputList.size() - 1);

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < inputList.size(); i += 2) {
            String name = inputList.get(i);
            String mail = inputList.get(i + 1);

            if (IsValideMalim(mail)) {
                result.put(name, mail);
            }
        }

        Writer writerOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP06.txt"), "utf-8"));
            {
                for (String persone : result.keySet()) {
                    writerOutput.write(String.format("%s -> %s%n", persone, result.get(persone)));
                }
            }
            writerOutput.close();
    }

    private static boolean IsValideMalim(String mail)
    {
        boolean isValide = true;
        String substr = mail.substring(mail.length() - 2);
        if (substr.equals("us") || substr.equals("uk")) {
            isValide = false;
        }
        return isValide;
    }
}
