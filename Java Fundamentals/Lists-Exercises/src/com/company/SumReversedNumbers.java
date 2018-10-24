package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumReversedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long result = Arrays.stream(reader.readLine().split("\\s+")) // read one row, split by space =>
                .map(text -> new StringBuilder(text).reverse().toString()) // get every String/text, make StringBuilder from this text, reverse chars ang again make it to String =>
                .mapToInt(Integer::parseInt)                               // get every number and make it ParseInt =>
                .sum();                                                    // sum all elements / numbers.

        System.out.println(result);
    }
}
