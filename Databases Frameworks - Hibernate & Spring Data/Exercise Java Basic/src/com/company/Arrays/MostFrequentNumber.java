package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MostFrequentNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] intArr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(FindMostFrequentNumber(intArr));
    }

    private static int FindMostFrequentNumber(int[] intArr) {
        int counter = 0;
        int number = 0;

        for (int i = 0; i < intArr.length ; i++) {
            int br = 0;
            for (int j = 0; j < intArr.length ; j++) {
                if (intArr[i] == intArr[j]) {
                    br++;
                }
            }
            if (br > counter) {
                number = intArr[i];
                counter = br;
            }
        }
        return number;
    }
}
