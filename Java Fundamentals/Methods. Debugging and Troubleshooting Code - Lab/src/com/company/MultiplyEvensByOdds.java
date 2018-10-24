package com.company;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(GetMultipleOfEvenAndOddDigits(n));

    }

    public static int GetMultipleOfEvenAndOddDigits(int n)
    {
        int sumEven = GetSumOfEvenDigits(n);
        int sumOdd = GetSumOfOddDigits(n);

        return sumEven * sumOdd;
    }

    public static int GetSumOfOddDigits(int n)
    {
        int sum = 0;
        while (n >0) {
            int lastDigit = n % 10;

            if (lastDigit % 2 != 0) {
                sum += lastDigit;
            }
            n /= 10;
        }
        return sum;
    }

    public static int GetSumOfEvenDigits(int n)
    {
        int sum = 0;
        while (n >0) {
            int lastDigit = n % 10;

            if (lastDigit % 2 == 0) {
                sum += lastDigit;
            }
            n /= 10;
        }
        return sum;
    }
}
