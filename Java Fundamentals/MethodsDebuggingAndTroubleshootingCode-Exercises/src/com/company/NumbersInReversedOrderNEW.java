package com.company;

import java.util.Scanner;

public class NumbersInReversedOrderNEW {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        System.out.println(ReverseNumber(number));
    }

    private static String ReverseNumber(String number)
    {
        String result = "";

        for (int i = number.length() - 1; i >= 0 ; i--)
        {
            result += number.charAt(i);
        }

        return result;
    }
}
