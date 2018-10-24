package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().toLowerCase().split("\\s+")));
        Map<String, Integer> count = new LinkedHashMap<>();

        for (String word : myList)
        {
            if (count.containsKey(word))
            {
                Integer value = count.get(word);
                value++;
                count.put(word, value);
            }
            else {
                Integer value = 1;
                count.put(word, value);
            }
        }

        List<String> result = new ArrayList<>();
        for (String key : count.keySet()) {
            if (count.get(key) % 2 != 0)
            {
                result.add(key);
            }
        }
        System.out.println(String.join(", ", result));
    }
}
