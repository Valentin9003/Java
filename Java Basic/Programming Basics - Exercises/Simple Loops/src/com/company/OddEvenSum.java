package com.company;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0){
                sumEven += number;
            }
            else if (i % 2 != 0){
                sumOdd += number;
            }

        }
        System.out.println(sumEven);
        System.out.println(sumOdd);

        if (sumEven == sumOdd) {
            System.out.printf("Yes Sum = %d",sumEven);
        } else {
            System.out.printf("No Diff = %d", Math.abs(sumEven-sumOdd));
        }
    }
}
