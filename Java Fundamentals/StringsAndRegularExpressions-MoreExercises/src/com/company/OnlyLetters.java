package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] inputArr = input.split("\\d+");

        Pattern patternDigit = Pattern.compile("(\\d+)(?:\\D)");
        Matcher matcherDigit = patternDigit.matcher(input);

        Pattern patternLetter = Pattern.compile("(?:\\d+)([A-Za-z])");
        Matcher matcherLetter = patternLetter.matcher(input);

        StringBuffer sb = new StringBuffer();
        sb.append(inputArr[0]);

        int i = 1;
        while (matcherDigit.find() && matcherLetter.find())
        {
            String letter = matcherLetter.group(1);
            sb.append(letter);
            sb.append(inputArr[i]);
            i++;
        }

        Pattern patternEndWithDigit = Pattern.compile("(?:[a-zA-Z])(\\d+\\b)");
        Matcher matcherEWD = patternEndWithDigit.matcher(input);
        if (matcherEWD.find()) {
            sb.append(matcherEWD.group(1));
        }

        System.out.println(sb.toString());
    }
}
