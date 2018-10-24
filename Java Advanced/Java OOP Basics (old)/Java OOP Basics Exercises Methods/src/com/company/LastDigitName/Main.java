package com.company.LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputNumber = Integer.valueOf(reader.readLine());
        Number number = new Number(inputNumber);
        number.returnNameOfLastDigit();
    }
}
