package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("\\b(?<day>\\d{2})([-./])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.println(String.format("Day: %s, Month: %s, Year: %s", day, month, year));
        }
    }
}
