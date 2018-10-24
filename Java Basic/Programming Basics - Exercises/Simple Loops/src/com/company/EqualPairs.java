package com.company;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int momentSum = 0;
        int sum = 0;
        int sum2 = 0;
        int diff = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            momentSum = number + number2;


            if (i >= 1) {
                diff = Math.abs(sum - momentSum);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
            if (i == 0 ) {
                sum2 = momentSum;
            }
            sum = momentSum;
        }
        if (n == 1) {
            System.out.println("Yes, value=" + sum2);
        }
        if (maxDiff == 0) {
            System.out.println("Yes, value=" + sum);
        } else {
            System.out.println("No, maxdiff=" + maxDiff);
        }
    }
}
