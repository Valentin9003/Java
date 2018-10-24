package com.company;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int firstNumber = 1;
        int secondNumber = 1;

        if (n < 2 ){
            System.out.println(firstNumber);
            return;
        }

        for (int i = 2; i <= n ; i++) {
            int thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
        }
        System.out.println(secondNumber);
    }
}
