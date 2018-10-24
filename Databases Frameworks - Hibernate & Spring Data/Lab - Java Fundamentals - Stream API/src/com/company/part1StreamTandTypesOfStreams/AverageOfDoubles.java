package com.company.part1StreamTandTypesOfStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputLine = Arrays.asList(reader.readLine().split("\\s+"));

        OptionalDouble average =
                inputLine.stream()
                        .filter(x -> !x.isEmpty())
                        .mapToDouble(Double::valueOf)
                        .average();

        if (average.isPresent()) {
            System.out.println(String.format("%.2f", average.getAsDouble()));
        } else {
            System.out.println("No match");
        }
    }
}
