package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class DifferentIntegersSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            BigInteger number = new BigInteger(input);
            System.out.println(input + " can fit in:");

            if(number.longValue() < Byte.MAX_VALUE && number.longValue() > Byte.MIN_VALUE)
            {
                System.out.println("* byte");
            }
            if(number.longValue() < Short.MAX_VALUE && number.longValue() > Short.MIN_VALUE)
            {
                System.out.println("* short");
            }
            if(number.longValue() < Integer.MAX_VALUE && number.longValue() > Integer.MIN_VALUE)
            {
                System.out.println("* int");
            }
            // If the longValueExact() returns a greater number than the long max value, then it throws an ArithmeticException
            if(number.longValueExact() < Long.MAX_VALUE && number.longValue() > Long.MIN_VALUE)
            {
                System.out.println("* long");
            }
        }
        catch(NumberFormatException | ArithmeticException e)
        {
            System.out.println(input + " * can't fit in any type");
        }

    }
}
