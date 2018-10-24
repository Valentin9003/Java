package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int[] boomber = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int number = boomber[0];
        int power = boomber[1];

        for (int i = 0; i < numbers.size(); i++)
        {
            
        }

//        System.out.println(numbers);
        System.out.println(numbers.stream().mapToInt(Integer::valueOf).sum());
    }
}
