package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] intArray = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isFindEqualSum = false;

        for (int i = 0; i < intArray.length; i++)
        {
            int[] leftSum = Arrays.stream(intArray).limit(i).toArray();
            int[] rightSum = Arrays.stream(intArray).skip(i+1).toArray();

            int sumLeft = IntStream.of(leftSum).sum();
            int sumRight = IntStream.of(rightSum).sum();

            if ( sumLeft == sumRight)
            {
                System.out.println(i);
                isFindEqualSum = true;
                break;
            }
        }

        if (!isFindEqualSum)
        {
            System.out.println("no");
        }
    }
}
