package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomizeWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] wordsArr = reader.readLine().split( " ");
        Random rand = new Random();

        for (int i = 0; i < wordsArr.length; i++) {
            int firstWord = rand.nextInt(wordsArr.length);
            int secondWord = rand.nextInt(wordsArr.length);

            String changer = wordsArr[firstWord];
            wordsArr[firstWord] = wordsArr[secondWord];
            wordsArr[secondWord] = changer;
        }
        System.out.println(String.join("\n", wordsArr));
    }
}

