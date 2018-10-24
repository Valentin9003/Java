package com.company.part2TypesOfOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputNumbers = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalDouble smallestEvenNumber =
                inputNumbers.stream()
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .min();

        if (smallestEvenNumber.isPresent()) {
            System.out.println(String.format("%.2f", smallestEvenNumber.getAsDouble()));
        } else {
            System.out.println("No match");
        }
    }
}
