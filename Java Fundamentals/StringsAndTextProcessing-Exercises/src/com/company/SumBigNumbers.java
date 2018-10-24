package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();

        String result = AddIntegers(firstNumber, secondNumber);
        System.out.println(result.trim());

    }

    private static String AddIntegers(String number1, String number2) throws Exception {
        char[] num1char = number1.toCharArray();
        char[] num2char = number2.toCharArray();

        if (num1char.length > num2char.length) {
            num2char = FormatToSameLength(num1char, num2char);
        }
        else if (num1char.length < num2char.length) {
            num1char = FormatToSameLength(num2char, num1char);
        }

        char[] addition = new char[num1char.length + 1];
        char carrry = '0';
        for (int i = num1char.length - 1; i >= 0; i--)
        {
            int sum = Character.getNumericValue(num1char[i]) + Character.getNumericValue(num2char[i]) + Character.getNumericValue(carrry);
            char[] csum = String.valueOf(sum).toCharArray();
            carrry = '0';
            if (csum.length > 1 && i == 0) {
                addition[i + 1] = csum[1];
                addition[0] = csum[0];
            }
            else if (csum.length > 1) {
                carrry = csum[0];
                addition[i + 1] = csum[1];
            }
            else {
                addition[i + 1] = csum[0];
            }
        }

        return String.valueOf(addition);
    }

    private static char[] FormatToSameLength(char[] num1char, char[] num2char) {
        int diff = num1char.length - num2char.length;
        char[] num = new char[num1char.length];

        for (int i = 0; i < diff; i++) {
            num[i] = '0';
        }
        for (int i = 0; i < num2char.length; i++) {
            num[diff + i] = num2char[i];
        }

        return num;
    }
}
