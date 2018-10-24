package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> persons = new ArrayList<>();

        Pattern pattern = Pattern.compile(".*(@gmail.com)");

        String inputLine = reader.readLine();
        while (!inputLine.equals("END")) {
            Matcher matcher = pattern.matcher(inputLine);
            if (matcher.find()) {
                String[] tokens = inputLine.split(" ");
                String fName = tokens[0];
                String lName = tokens[1];

                persons.add(String.format("%s %s", fName, lName));
            }

            inputLine = reader.readLine();
        }

        persons.forEach(System.out::println);
    }
}
