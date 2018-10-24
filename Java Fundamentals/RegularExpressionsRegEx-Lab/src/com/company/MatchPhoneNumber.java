package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("[+359]{4}(-|\\s)[2]\\1[0-9]{3}\\1[0-9]{4}\\b");

        List<String> resultList = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            resultList.add(matcher.group());
        }

        System.out.println(String.join(", ", resultList));
    }
}
//*****input******
//+359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 +359-2-222-2222
//
//****True Answer*****
//+359 2 222 2222, +359-2-222-2222