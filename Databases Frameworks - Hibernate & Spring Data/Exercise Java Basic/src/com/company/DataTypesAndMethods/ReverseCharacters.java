package com.company.DataTypesAndMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String letter = reader.readLine();
            sb.append(letter);
        }

        System.out.println(sb.reverse().toString());
    }
}
