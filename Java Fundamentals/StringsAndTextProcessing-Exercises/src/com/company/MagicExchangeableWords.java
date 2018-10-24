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

        boolean isMagic = false;
        if (firstWord.length() == secondWord.length())
        {
            isMagic = true;
        }

        System.out.println(isMagic);
    }

    private static String DistinctChars(String stringWord)
    {
        String temp = "";
        for (int i = 0; i < stringWord.length(); i++){
            char current = stringWord.charAt(i);
            if (temp.indexOf(current) < 0){
                temp = temp + current;
            }
        }
        return temp;
    }
}
