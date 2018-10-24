package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] myArr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        double average = 1.0;

        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] < min) {
                min = myArr[i];
            }
            if (myArr[i] > max) {
                max = myArr[i];
            }
            sum += myArr[i];
            average = (double) sum / (double) myArr.length;
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
