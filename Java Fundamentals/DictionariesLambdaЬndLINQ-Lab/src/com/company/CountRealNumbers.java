package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(reader.readLine().split("\\s+")));

        Map<String, Integer> count = new TreeMap<>();

        for (String num : myList)
        {
            if (count.containsKey(num))
            {
                Integer value = count.get(num);
                value++;
                count.put(num, value);
            }
            else {
                Integer value = 0;
                value++;
                count.put(num, value);
            }
        }

        for (String key : count.keySet()) {
            System.out.println(key + " -> " + count.get(key));
        }
    }
}
