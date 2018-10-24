package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndexOfLetters2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i) + " -> " + (input.charAt(i) - 97));
        }
    }
}
