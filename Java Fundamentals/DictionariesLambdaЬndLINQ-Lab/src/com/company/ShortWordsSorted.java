package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShortWordsSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Read ArrayList, make all words toLowerCase and split by special chars
        List<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().toLowerCase().split("[\\s:,.;!?'\\[\\]()/]+")));
        //Make new List from MyList and erase all non-unique words
        List<String> newList = (myList.stream().distinct().collect(Collectors.toList()));
        //Sorting newList
        Collections.sort(newList);
        //Make new List for result and add in it all words with length <=4
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < newList.size(); i++) {
            String word = newList.get(i);
            if (word.length() <= 4) {
                resultList.add(word);
            }
        }
        //Print result List
        System.out.println(String.join(", ", resultList));
    }
}

