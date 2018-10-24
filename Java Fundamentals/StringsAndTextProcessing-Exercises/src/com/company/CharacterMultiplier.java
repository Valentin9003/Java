package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        String first = input[0];
        String second = input[1];

        BigInteger sum = BigInteger.ZERO;
        if (first.length() == second.length())
        {
            for (int i = 0; i < first.length(); i++) {
                sum = sum.add(BigInteger.valueOf(first.charAt(i)).multiply(BigInteger.valueOf(second.charAt(i))));
            }
        }
        else
            {
                if (Math.min(first.length(), second.length()) == 1) {
                    for (int i = 0; i < first.length(); i++) {
                        sum = sum.add(BigInteger.valueOf(first.charAt(i)).multiply(BigInteger.valueOf(second.charAt(i))));
                    }
                    for (int i = first.length(); i < second.length(); i++) {
                        sum = sum.add(BigInteger.valueOf(second.charAt(i)));
                    }
                } else {
                    for (int i = 0; i < second.length(); i++) {
                        sum = sum.add(BigInteger.valueOf(first.charAt(i)).multiply(BigInteger.valueOf(second.charAt(i))));
                    }
                    for (int i = second.length(); i < first.length(); i++) {
                        sum = sum.add(BigInteger.valueOf(first.charAt(i)));
                    }
                }
            }

        System.out.println(sum);
    }
}
