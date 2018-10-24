package com.company;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long number = Long.parseLong(scanner.nextLine());

        if (PrimeNumberChecker(number)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean PrimeNumberChecker(long number)
    {
        boolean prime = true;

        if (number % 2 == 0 && number != 2 || number < 2) {
            prime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        return prime;
    }
}
