package com.company;

import java.util.Scanner;

public class MasterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++)
        {
            String num = "" + i;
            if (IsPalindrome(num) && SumOfDigits(num) && ContainsEvenDigit(num))
            {
                System.out.println(i);
            }
        }
    }

    private static boolean IsPalindrome(String num)
    {
        boolean isPalindrome = true;
        for (int i = 0; i < num.length() / 2 ; i++)
        {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i))
            {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    private static boolean SumOfDigits(String num)
    {
        boolean sumOfDigits = true;
        int sum = 0;
        for (int i = 0; i < num.length() ; i++) {
            int digit = Character.digit(num.charAt(i), 10);
            sum += digit;
        }
        if (sum % 7 != 0) {
            sumOfDigits = false;
        }

        return sumOfDigits;
    }

    private static boolean ContainsEvenDigit(String num)
    {
        boolean haveEvenDigit = false;

        for (int i = 0; i < num.length() ; i++) {
            int digit = Character.digit(num.charAt(i), 10);
            if (digit % 2 == 0)
            {
                haveEvenDigit = true;
            }
        }


        return haveEvenDigit;
    }
}
