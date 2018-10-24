package com.company.part1StreamTandTypesOfStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputLine = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        inputLine.stream()
                .map(String::toUpperCase)
                .forEach(x -> System.out.print(x + " "));
    }
}
