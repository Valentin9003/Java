package com.company.DataTypesAndMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseCharacters2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] letters = new String[3];
        for (int i = 0; i < 3; i++) {
            letters[i] = reader.readLine();
        }

        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i]);
        }
    }
}
