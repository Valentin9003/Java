package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyWord = reader.readLine();
        String text = reader.readLine();

        Pattern sentencePattern = Pattern.compile("[A-Z][\\w+\\s’–,]+[.?!]");
        Pattern keyWordPattern = Pattern.compile("\\b(" + keyWord + ")\\b");

        Matcher sentenceMatcher = sentencePattern.matcher(text);

        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();

            Matcher keyWordMatcher = keyWordPattern.matcher(sentence);
            if (keyWordMatcher.find()) {
                System.out.println(sentence);
            }
        }
    }
}
