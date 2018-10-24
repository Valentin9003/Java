package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndexOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            int index = 0;
            for (int j = 0; j < alphabet.length; j++) {
                if (input.charAt(i) == alphabet[j]) {
                    index = j;
                }
            }
            System.out.println(input.charAt(i) + " -> " + index);
        }
    }
}
