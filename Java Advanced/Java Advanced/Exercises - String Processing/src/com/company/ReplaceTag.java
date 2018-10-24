package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder str = new StringBuilder();

        while (!input.equals("END")) {
            str.append(input).append(System.lineSeparator());
            input = reader.readLine();
        }

        String text = str.toString();

        Pattern htmlPattern = Pattern.compile("(<a)\\s+href[^>]+(>)\\s*.*?(</a>)");
        Matcher htmlMatcher = htmlPattern.matcher(text);

        while (htmlMatcher.find()) {
            String entireGroups = htmlMatcher.group(0);
            String openATag = htmlMatcher.group(1);
            String closeOpenATag = htmlMatcher.group(2);
            String closeATag = htmlMatcher.group(3);

            String replacement = entireGroups.replaceFirst(openATag, "[URL");
            replacement = replacement.replaceFirst(closeOpenATag, "]");
            replacement = replacement.replaceFirst(closeATag, "[/URL]");

            text = text.replace(entireGroups, replacement);
        }

        System.out.println(text);

    }
}
