package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        String firstWord = input[0];
        String secondWord = input[1];

        firstWord = "" + DistinctChars(firstWord);
        secondWord = "" + DistinctChars(secondWord);

        System.out.println(isMagic(firstWord, secondWord));
    }

    private static boolean isMagic(String firstWord, String secondWord) {
        return firstWord.length() == secondWord.length();
    }

    private static String DistinctChars(String stringWord) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < stringWord.length(); i++) {
            char current = stringWord.charAt(i);
            if (temp.toString().indexOf(current) < 0) {
                temp.append(current);
            }
        }
        return temp.toString();
    }
}
