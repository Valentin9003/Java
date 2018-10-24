package com.company.lastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        Number number = new Number(num);

        System.out.println(number.getEnglishNameOnLastDigit());
    }
}
