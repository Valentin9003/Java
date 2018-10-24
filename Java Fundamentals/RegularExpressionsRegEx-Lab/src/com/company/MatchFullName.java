package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String toCheck = reader.readLine();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(toCheck);

        while (matcher.find()) {
            String fullName = matcher.group();
            System.out.print(fullName + " ");
        }

    }
}
