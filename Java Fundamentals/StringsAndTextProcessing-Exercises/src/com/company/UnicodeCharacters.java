package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++)
        {
            String hex = String.format("%04x", (int) input.charAt(i));
            System.out.print("\\u" + hex);
        }

    }
}
