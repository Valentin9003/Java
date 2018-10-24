package com.company.DataTypesAndMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelOrDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if(Character.isDigit(input.charAt(0))) {
            System.out.println("digit");
        }
        else if (isVowel(input)) {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }

    private static boolean isVowel(String input) {
        boolean isVowel = false;
        if (input.equalsIgnoreCase("A")
                || input.equalsIgnoreCase("E")
                || input.equalsIgnoreCase("I")
                || input.equalsIgnoreCase("O")
                || input.equalsIgnoreCase("U")) {
            isVowel = true;
        }
        return isVowel;
    }
}
