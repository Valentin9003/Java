package com.company.part1StreamTandTypesOfStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers =
                Arrays.stream(reader.readLine()
                        .split("\\s+"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());

        numbers.stream()
                .distinct()
                .filter(x -> 10 <= x && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));

    }
}
