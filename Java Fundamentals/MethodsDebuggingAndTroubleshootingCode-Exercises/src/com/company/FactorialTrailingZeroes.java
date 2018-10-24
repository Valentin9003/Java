package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = new BigInteger(scanner.nextLine());

        System.out.println(CalculateFactorialTrailingZeroes(n));
    }

    private static int CalculateFactorialTrailingZeroes(BigInteger n) {
        BigInteger sum = CalculateFactorial(n);
        String nToString = sum.toString();
        int counter = 0;

        for (int i = nToString.length() - 1; i >= 0; i--)
        {
            int digit = Character.digit(nToString.charAt(i), 10);
            if (digit != 0) {
                break;
            }
            else if (digit == 0)
            {
                counter++;
            }
        }

        return counter;
    }

    private static BigInteger CalculateFactorial(BigInteger n) {
        BigInteger sum = BigInteger.valueOf(1);
        String nToString = n.toString();
        int step = Integer.parseInt(nToString);


        for (int i = step; i > 1 ; i--)
        {
            sum = sum.multiply(n);
            n = n.subtract(BigInteger.valueOf(1));
        }

        return sum;
    }
}
