package com.company.BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicMathMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        while (!tokens[0].equals("End")) {
            String command = tokens[0];
            double firstNumber = Double.parseDouble(tokens[1]);
            double secondNumber = Double.parseDouble(tokens[2]);

            MathUtil calculator = new MathUtil(command, firstNumber, secondNumber);

            tokens = reader.readLine().split("\\s+");
        }
    }
}
