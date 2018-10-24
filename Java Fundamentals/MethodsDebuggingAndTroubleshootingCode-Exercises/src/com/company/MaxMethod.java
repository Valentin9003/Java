package com.company;

import java.util.Scanner;

public class MaxMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        int maxNumber = Math.max(number1, number2);

        System.out.println(GetMax(number3, maxNumber));
    }

    private static int GetMax(int number3, int maxNumber)
    {
        return Math.max(number3, maxNumber);
    }
}
