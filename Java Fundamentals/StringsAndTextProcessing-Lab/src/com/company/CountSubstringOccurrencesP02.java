package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrencesP02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();
        String pattern = reader.readLine().toLowerCase();

        int counter = 0;
        int index = input.indexOf(pattern);

        while (index != -1) {
            counter++;
            index = input.indexOf(pattern, index + 1);
        }

        System.out.println(counter);
    }
}
