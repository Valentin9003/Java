package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Censorship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String wordForCensoring = reader.readLine();
        String sentence = reader.readLine();

        String censored = "\\b(" + wordForCensoring + ")\\b";
        Pattern pattern = Pattern.compile(censored);
        Matcher matcher = pattern.matcher(sentence);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordForCensoring.length(); i++) {
            sb.append("*");
        }

        if (matcher.find()) {
            sentence = sentence.replaceAll(matcher.group(), sb.toString());
        }

        System.out.println(sentence);
    }
}
