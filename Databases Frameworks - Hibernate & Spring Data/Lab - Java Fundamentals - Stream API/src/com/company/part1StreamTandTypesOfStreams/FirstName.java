package com.company.part1StreamTandTypesOfStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputLIne = Arrays.asList(reader.readLine().split("\\s+"));
        Character ch = reader.readLine().toLowerCase().charAt(0);

        Optional<String> result =
                inputLIne.stream()
                        .filter(name -> name.toLowerCase().charAt(0) == ch)
                        .sorted()
                        .findFirst();

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("No match");
        }
    }
}
