package com.company;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number < 2 ) {
            System.out.println(1);
            return;
        }
        else {
            System.out.println(FibonacciNumber(number));
        }
    }

    private static int FibonacciNumber(int number)
    {
        int firstNumber = 1;
        int secondNumber = 1;

        for (int i = 2; i <= number ; i++) {
            int thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
        }

        return secondNumber;
    }
}
