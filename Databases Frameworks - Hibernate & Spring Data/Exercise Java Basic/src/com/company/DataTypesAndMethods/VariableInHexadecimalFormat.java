package com.company.DataTypesAndMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VariableInHexadecimalFormat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String hexadecimalNumber = reader.readLine();
        int decimalNumber = Integer.parseInt(hexadecimalNumber, 16);
        System.out.println(decimalNumber);
    }
}
