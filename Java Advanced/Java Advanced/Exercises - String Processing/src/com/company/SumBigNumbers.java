package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = correctNumber(reader.readLine());
        String secondNumber = correctNumber(reader.readLine());

        String result = calculateResult(firstNumber, secondNumber);

        System.out.println(result);
    }

    private static String calculateResult(String firstNumber, String secondNumber) {
        String biggestNum = reverseNumber(firstNumber);
        String smallNumber = reverseNumber(secondNumber);

        if (firstNumber.length() != secondNumber.length()) {
            biggestNum = getBiggestNumber(firstNumber, secondNumber);
            smallNumber = getSmallNumber(firstNumber, secondNumber);
        }

        StringBuilder newNumber = new StringBuilder();
        int bufferNum = 0;
        for (int i = 0; i < biggestNum.length(); i++) {
            int newDig = 0;

            int firstDigit = Integer.parseInt(String.valueOf(biggestNum.charAt(i)));
            int secondDigit = 0;
            if (smallNumber.length() > i) {
                secondDigit = Integer.parseInt(String.valueOf(smallNumber.charAt(i)));
            }

            int sum = firstDigit + secondDigit + bufferNum;
            newDig += sum % 10;
            bufferNum = sum / 10;

            newNumber.append(newDig);
        }

        if (bufferNum != 0) {
            newNumber.append(bufferNum);
        }

        return newNumber.reverse().toString();
    }

    private static String reverseNumber(String number) {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        return sb.reverse().toString();
    }

    private static String getSmallNumber(String firstNumber, String secondNumber) {
        StringBuilder sb = new StringBuilder();
        if (firstNumber.length() < secondNumber.length()) {
            return sb.append(firstNumber).reverse().toString();
        } else {
            return sb.append(secondNumber).reverse().toString();
        }
    }

    private static String getBiggestNumber(String firstNumber, String secondNumber) {
        StringBuilder sb = new StringBuilder();
        if (firstNumber.length() > secondNumber.length()) {
            return sb.append(firstNumber).reverse().toString();
        } else {
            return sb.append(secondNumber).reverse().toString();
        }
    }

    private static String correctNumber(String number) {
        /**
         * If the number starting with 0 (zero), then repair it
         *  EXAMPLE:
         *      1) inputString = "123456789" ->
         *          that is correct number, so just return it.
         *      2) inputString = "000123456789" ->
         *          that is incorrect number, so we need to delete all zeroes in front
         *          and in the end will return correctString = "123456789"
         ***/
        if (!number.startsWith("0")) {
            return number;
        }
        StringBuilder correctNumber = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (correctNumber.toString().isEmpty() && number.charAt(i) == '0') {
                continue;
            }
            correctNumber.append(number.charAt(i));
        }

        return correctNumber.toString();
    }
}
