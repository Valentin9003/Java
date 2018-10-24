package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (String word : bannedWords) {
            String replacementStr = createReplacementString(word);

            if (text.contains(word)) {
                text = text.replaceAll(word, replacementStr);
            }
        }

        System.out.println(text);
    }

    private static String createReplacementString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
