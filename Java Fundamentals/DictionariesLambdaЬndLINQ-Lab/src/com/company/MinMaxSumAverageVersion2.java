package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxSumAverageVersion2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            myList.add(Integer.parseInt(reader.readLine()));
        }

        int min = Collections.min(myList);
        int max = Collections.max(myList);
        int sum = myList.stream().mapToInt(Integer::intValue).sum();
        Double average = 1.0d * sum / myList.size();

        System.out.println("Sum = " + sum);
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
        System.out.println("Average = " + average);
    }
}
