package com.company;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int stop = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int br = 0;

        for (int i = start; i <= stop ; i++) {
            for (int j = start; j <= stop ; j++) {
                br++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", br,i,j,(i+j));
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", br,magicNumber);
    }
}
