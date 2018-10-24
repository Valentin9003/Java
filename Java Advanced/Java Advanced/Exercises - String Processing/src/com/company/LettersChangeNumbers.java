package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        double sum = 0;
        for (String str : myList) {
            sum += CalculateSum(str);
        }

        System.out.println(String.format("%.2f", sum));
    }

    private static double CalculateSum(String stringElement) {
        double sum = 0.0;
        char firstLetter = stringElement.charAt(0);
        char lastLetter = stringElement.charAt(stringElement.length() - 1);
        double number = Long.parseLong(stringElement.substring(1, stringElement.length() - 1));

        double resultSumAfterFirstOperation = CalculateNumberWithFirstLetter(firstLetter, number);
        number = CalculateNumberWithLastLetter(lastLetter, resultSumAfterFirstOperation);

        return sum += number;
    }

    private static double CalculateNumberWithLastLetter(char lastLetter, double resultSumAfterFirstOperation) {
        double buffer = 0.0;
        String letter = String.valueOf(lastLetter);

        //If it's uppercase you subtract its position from the resulted number.
        if (letter.equals(letter.toUpperCase())) {
            double letterPositionInAlphabet = lastLetter - 64;
            buffer += resultSumAfterFirstOperation - letterPositionInAlphabet;
        }
        //If it's lowercase you add its position to the resulted number.
        else {
            double letterPositionInAlphabet = lastLetter - 96;
            buffer += resultSumAfterFirstOperation + letterPositionInAlphabet;
        }

        return buffer;
    }

    private static double CalculateNumberWithFirstLetter(char firstLetter, double number) {
        double buffer = 0;
        String letter = String.valueOf(firstLetter);

        //If it's uppercase you divide the number by the letter&#39;s position in the alphabet
        if (letter.equals(letter.toUpperCase())) {
            double letterPositionInAlphabet = (int)firstLetter - 64;
            buffer += number / letterPositionInAlphabet;
        }
        //If it's lowercase you multiply the number with the letter&#39;s position in the alphabet
        else {
            double letterPositionInAlphabet = (int)firstLetter - 96;
            buffer += number * letterPositionInAlphabet;
        }

        return buffer;
    }
}
