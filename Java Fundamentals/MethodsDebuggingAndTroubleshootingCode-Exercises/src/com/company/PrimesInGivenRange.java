package com.company;

import java.util.Scanner;

public class PrimesInGivenRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int stopNumber = Integer.parseInt(scanner.nextLine());
        int br = 0 ;

        for (int index = startNumber; index <= stopNumber; index++) {
            if (PrimeNumberChecker(index)) {
                br ++;
                if (br == 1) {
                System.out.print(index);
                } else {
                    System.out.print(", " + index);
                }
            }
        }
    }

    private static boolean PrimeNumberChecker(int number) {
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
