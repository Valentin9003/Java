package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        FindUniqueSymbols(input.toUpperCase()
        );

        Pattern pattern = Pattern.compile("((\\D+)([0-9]{0,20}))");
        Matcher matcher = pattern.matcher(input.toUpperCase());
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            int repeatCount = Integer.parseInt(matcher.group(3));
            String str = matcher.group(2);

            for (int i = 0; i < repeatCount; i++) {
                sb.append(str);
            }
        }
        System.out.println(sb.toString());
    }

    private static void FindUniqueSymbols(String input)
    {
        Set<String> uniqueSymbols = new HashSet<>();
        Pattern rgx = Pattern.compile("(\\D)");
        Matcher setMatcher = rgx.matcher(input.toUpperCase());

        while (setMatcher.find()) {
            uniqueSymbols.add(setMatcher.group(1));
        }

        System.out.println(String.format("Unique symbols used: %d", uniqueSymbols.size()));
    }
}
