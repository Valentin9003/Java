package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");

        String line;
        while (!"end".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println(line);
            }
        }
    }
}
