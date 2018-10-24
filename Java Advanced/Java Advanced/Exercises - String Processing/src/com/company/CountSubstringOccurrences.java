package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String textLine = reader.readLine();
        String searchString = reader.readLine().toLowerCase();

        int counter = 0;
        if (textLine.toLowerCase().contains(searchString)) {
            counter += checkHowMuchTimesContains(searchString, textLine);
        }

        System.out.println(counter);
    }

    private static int checkHowMuchTimesContains(String searchString, String textLine) {
        int counter = 0;
        for (int i = 0; i < textLine.length(); i++) {
            if ((searchString.length() + i) > textLine.length()) {
                break;
            }
            String subStr = textLine.substring(i, (searchString.length() + i));
            if (subStr.equalsIgnoreCase(searchString)) {
                counter++;
            }
        }
        return counter;
    }
}
