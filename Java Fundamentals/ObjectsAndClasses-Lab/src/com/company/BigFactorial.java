package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        BigInteger factorial = BigInteger.valueOf(1);

        for(int i=2; i<=number; i++)
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }
}
