package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int digit = 0;
        int maxCount = 0;
        int currentCount = 1;

        for (int i = 1; i < inputArr.length; i++) {
            int number = inputArr[i - 1];

            if (inputArr[i] == number) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                digit = number;
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(digit + " ");
        }
    }
}
