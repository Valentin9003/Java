package com.company.part2TypesOfOperations;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] lowerAndUpper = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int lower = Math.min(lowerAndUpper[0], lowerAndUpper[1]);
        int upper = Math.max(lowerAndUpper[0], lowerAndUpper[1]);
        List<Integer> sequenceOfNumbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        sequenceOfNumbers.stream()
                .filter(x -> x >= lower && x <= upper)
                .forEach(x -> {
                    System.out.print(x + " ");
                });
    }
}
