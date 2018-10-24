package com.company.part2TypesOfOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputLine = Arrays.asList(reader.readLine().split("\\s+"));

        Optional<Integer> sumOfIntegers =
                inputLine.stream()
                .filter(x -> isNumber(x))
                .map(Integer::valueOf)
                .reduce((x,y) -> x + y);

        if (sumOfIntegers.isPresent()) {
            System.out.println(sumOfIntegers.get());
        } else {
            System.out.println("No match");
        }

    }

    private static boolean isNumber(String x) {
        try {
            int num = Integer.parseInt(x);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
