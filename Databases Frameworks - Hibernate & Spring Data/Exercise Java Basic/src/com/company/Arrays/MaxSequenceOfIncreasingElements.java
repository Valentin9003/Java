package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxStart = 0;
        int maxLen = 1;
        int currentStart = 0;
        int currentLen = 1;

        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i] > inputArr[i - 1])
            {
                currentLen++;
                if (currentLen > maxLen)
                {
                    maxLen = currentLen;
                    maxStart = currentStart;
                }
            }
            else
            {
                currentLen = 1;
                currentStart = i;
            }
        }

        for (int i = maxStart; i < maxStart + maxLen; i++)
            System.out.print(inputArr[i] + " ");
    }
}
