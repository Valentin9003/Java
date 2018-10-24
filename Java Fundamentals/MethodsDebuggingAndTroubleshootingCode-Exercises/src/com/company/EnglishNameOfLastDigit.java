package com.company;

import java.util.Scanner;

public class EnglishNameOfLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        long digitToName = NumbersEnglishName(n);

        for (int i = 0; i <= digitToName; i++)
            if (i == digitToName)
                System.out.println(numbers[i]);
    }

    private static long NumbersEnglishName(long n)
    {
        int lastDigit = (int)Math.abs(n % 10);
        return lastDigit;
    }
}
