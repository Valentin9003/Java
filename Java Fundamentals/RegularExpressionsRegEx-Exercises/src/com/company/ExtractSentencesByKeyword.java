/*
Write a program that extracts all sentences that contain a particular word from a string (case-sensitive).
 Assume that the sentences are separated from each other by the character '.' or '!' or '?'.
 The words are separated by a non-letter character.
 Note that a substring is different than a word. The sentence “I am a fan of Motorhead” does not contain the
word “to”. It contains the substring “to”, which is not what we need.
 Print the result text without the separators between the sentences ("." or "!" or "?").
 */
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractSentencesByKeyword {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine().toLowerCase();
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("[.?!]")));

        for (int i = 0; i < myList.size(); i++)
        {
            List<String> result = new ArrayList<>(Arrays.asList(myList.get(i).split("[\\s:,.;!?'\\[\\]()/\\\\]+")));
            if (result.contains(word)) {
                System.out.println(myList.get(i).trim());
            }
        }
    }
}

//*****Example Input******
//to
//Welcome to SoftUni! You will learn programming, algorithms, problem solving and software technologies. You need to allocate for study 20-30 hours weekly. Good luck!I am fan of Motorhead. To be or not to be - that is the question. TO DO OR NOT?