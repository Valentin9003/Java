package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmailMe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email = reader.readLine();
        String[] splitedEmail = email.split("@");

        long leftPast = CalculateTheLetters(splitedEmail[0]);
        long rightPast = CalculateTheLetters(splitedEmail[1]);

        if (leftPast - rightPast >= 0) {
            System.out.println("Call her!");
        } else {
            System.out.println("She is not the one.");
        }
    }

    private static long CalculateTheLetters(String str)
    {
        char[] letters = str.toCharArray();
        long result = 0;

        for (int i = 0; i < letters.length; i++) {
            result += letters[i];
        }

        return result;
    }
}
