package com.company;

import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilterP03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] badWords = reader.readLine().trim().split(",\\s+");
        String text = reader.readLine();

        for (String badWord : badWords) {

            StringBuilder bdWordReplacer = new StringBuilder();
            for (int idx = 0; idx != badWord.length(); ++idx)
                bdWordReplacer.append("*");

            if (text.contains(badWord)) {
                text = text.replaceAll(badWord, bdWordReplacer.toString());
            }
        }
        System.out.println(text);
    }
}
