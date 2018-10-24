/*
    *Valid Usernames
You are part of the back-end development team of the next Facebook.
You are given a line of usernames, separated by one of the following symbols: “ ”, “/”, “\”, “(“, “)”.
First you have to export all valid usernames. A valid username starts with a letter and can only contain letters, digits
and underscores “_”. It cannot be less than 3 or more than 25 symbols long.
Your task is to sum the length of every 2 consecutive valid usernames and print the 2 valid usernames with biggest
sum of their lengths, on the console, each on a separate line.
-Input
The input comes from the console. One line will hold all the data. It will hold usernames, divided by the symbols: “ “, “/”, “\”, “(“, “)”.
The input data will always be valid and in the format described. There is no need to check it explicitly.
-Output
Print the 2 consecutive valid usernames with the biggest sum of their lengths on the console, each on a separate line.
If there are 2 or more couples of usernames with the same sum of their lengths, print the left most.
-Constraints
 The input line will hold characters in the range [0 … 9999].
 The usernames should start with a letter and can contain only letters, digits and “_”.
 The username cannot be less than 3 or more than 25 symbols long.
 Time limit: 0.5 sec. Memory limit: 16 MB.
 */
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("[\\s/\\\\()]")));

        List<String> sortedList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\b[A-Za-z][\\w+]{2,24}\\b)");

        for (String s : myList) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()) {
                sortedList.add(s);
            }
        }

        int lengthCounter = 0;
        for (int i = 1; i < sortedList.size(); i++) {
            int momentLength = sortedList.get(i).length() + sortedList.get(i - 1).length();

            if (momentLength > lengthCounter) {
                lengthCounter = momentLength;
                myList.clear();
                myList.add(sortedList.get(i - 1));
                myList.add(sortedList.get(i));
            }
        }

        for (String userName : myList) {
            System.out.println(userName);
        }
    }
}
