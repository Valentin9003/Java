package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OddFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbersList = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(numbersList);

        for (Integer number : numbersList) {
            if (number % 2 != 0) {
                int index = resultList.indexOf(number);
                resultList.remove(index);
            }
        }

        ConvertRemainingNumbersToOddNumbers(resultList);

        for (Integer integer : resultList) {
            System.out.print(integer + " ");
        }
    }

    private static void ConvertRemainingNumbersToOddNumbers(List<Integer> resultList)
    {
        int averageOnResultList =resultList.stream().reduce(0, (total, number) -> total + number) / resultList.size();
        List<Integer> bufferList = new ArrayList<>();

        for (Integer number : resultList) {
            if (number <= averageOnResultList) {
                int num = number - 1;
                bufferList.add(num);
            } else {
                int num = number + 1;
                bufferList.add(num);
            }
        }
        resultList.clear();
        resultList.addAll(bufferList);
    }
}
