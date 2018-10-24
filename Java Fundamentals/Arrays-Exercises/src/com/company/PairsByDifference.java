package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PairsByDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] intArray = Arrays.stream(input).mapToInt(i -> Integer.parseInt(i)).toArray();
        int difference = Integer.parseInt(scanner.nextLine());

        System.out.println(FoundCounter(intArray, difference));

    }

    private static int FoundCounter(int[] intArray, int difference) {
        int counter = 0;

        for (int i = 0; i < intArray.length ; i++)
        {
            for (int j = intArray.length - 1; j > i; j--)
            {
                int bufferNumber = Math.abs(intArray[i] - intArray[j]);
                if (bufferNumber == difference)
                {
                    counter++;
                }
            }
        }
        return counter;
    }
}
