package com.company;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number > max) {
                max = number;
            }
        }
        if (max * 2 == sum) {
            System.out.printf("Yes Sum = %d",max);
        } else {
            int diff = Math.abs(max - (sum - max));
            System.out.printf("No Diff = %d",diff);
        }
    }
}
