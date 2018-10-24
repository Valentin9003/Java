package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] intArray = Arrays.stream(input).mapToInt(i -> Integer.parseInt(i)).toArray();

        System.out.println(FindMostFrequentNumber(intArray));
    }

    private static int FindMostFrequentNumber(int[] intArray) {
        int counter = 0;
        int number = 0;

        for (int i = 0; i < intArray.length ; i++)
        {
            int br = 0;

            for (int j = 0; j < intArray.length ; j++)
            {
                if (intArray[i] == intArray[j])
                {
                    br++;
                }
            }
            if (br > counter) {
                number = intArray[i];
                counter = br;
            }
        }

        return number;
    }
}
