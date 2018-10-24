package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = new BigInteger(scanner.nextLine());

        System.out.println(CalculateFactorial(n));
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
