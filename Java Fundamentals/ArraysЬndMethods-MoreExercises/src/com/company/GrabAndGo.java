package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class GrabAndGo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Long::valueOf).collect(Collectors.toList());
        long num = Long.parseLong(reader.readLine());

        if (!numbers.contains(num)) {
            System.out.println("No occurrences were found!");
        } else {

            int lastIndexOf = numbers.lastIndexOf(num);
            List<Long> myList = new ArrayList<>();

            for (int i = 0; i < lastIndexOf; i++) {
                myList.add(numbers.get(i));
            }

            System.out.println(myList.stream().mapToLong(Long::valueOf).sum());
        }
    }
}
