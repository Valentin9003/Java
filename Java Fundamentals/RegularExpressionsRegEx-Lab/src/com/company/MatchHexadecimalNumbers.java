package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchHexadecimalNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String toCheck = reader.readLine();

        Pattern pattern = Pattern.compile("\\b(?:0x)?[0-9A-F]+\\b");
        Matcher matcher = pattern.matcher(toCheck);

        LinkedList<String> result = new LinkedList<>();

        while (matcher.find()) {
            String phoneNumber = matcher.group();
            result.add(phoneNumber.trim());
        }
        System.out.println(String.join(" ", result));
    }
}
