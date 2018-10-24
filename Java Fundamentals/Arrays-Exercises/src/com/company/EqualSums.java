package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] intArray = Arrays.stream(input).mapToInt(i -> Integer.parseInt(i)).toArray();

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
