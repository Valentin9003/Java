package com.company;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
