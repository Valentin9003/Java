package com.company;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int BrNumbers = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int sum2 = 0;

        for (int i = 1; i <= BrNumbers ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum = sum + number;
        }
        for (int i = 1; i <= BrNumbers ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum2 = sum2 + number;
        }
        if (sum == sum2) {
            System.out.printf("Yes, sum = %d",sum);
        } else {
            System.out.printf("No, diff = %d",Math.abs(sum-sum2));
        }
    }
}
