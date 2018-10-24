package com.company;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            int sum = i % 10 + i / 10;

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.println(i + "-> True");
            } else {
                System.out.println(i + "-> False");
            }
        }
    }
}
