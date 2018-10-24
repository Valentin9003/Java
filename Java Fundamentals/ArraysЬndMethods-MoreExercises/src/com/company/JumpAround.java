package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JumpAround {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbersList = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        int step = numbersList.get(0);
        int sum = numbersList.get(0);
        int allListIndexes = numbersList.size() - 1;
        int index = numbersList.indexOf(step);

        while (true) {
            if (index + step <= allListIndexes)
            {
                int newNumberIs = numbersList.get(index + step);
                index += step;
                sum += newNumberIs;
                step = newNumberIs;
            }
            else if (index - step >= 0)
            {
                int newNumberIs = numbersList.get(index - step);
                index -= step;
                sum += newNumberIs;
                step = newNumberIs;
            }
            else
                {
                    System.out.println(sum);
                    return;
                }
        }
    }
}
