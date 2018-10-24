package com.company;

import java.util.Scanner;

public class NumbersInReversedOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Long.parseLong(scanner.nextLine());

        long revNumber = ReverseDigits(number);
        System.out.println(revNumber);
    }

    private static long ReverseDigits(long number)
    {
        long backup = number;
        long count = 0;

        if (number < 10) {
            System.out.println(number);
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }
        number = backup;
        long sum = 0;
        for (long i = count; i > 0; i--) {
            int sum10 = 1;
            long last = number % 10;

            for (int j = 1; j < i; j++) {
                sum10 = sum10 * 10;
            }

            sum = sum + (last * sum10);
            number = number / 10;
        }
        return sum;
    }
}
