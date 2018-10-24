package com.company;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < min) {
                min = number;
            }
        }
        System.out.println(min);
    }
}
