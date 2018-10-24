package com.company;

import java.util.Scanner;

public class IntervalOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        int stop = Math.max(number1,number2);
        int start = Math.min(number1,number2);

        for (int i = start; i <= stop ; i++) {
            System.out.println(i);
        }
    }
}
