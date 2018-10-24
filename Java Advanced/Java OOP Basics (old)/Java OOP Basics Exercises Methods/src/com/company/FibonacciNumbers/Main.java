package com.company.FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int startPosition = Integer.valueOf(reader.readLine());
        int endPosition = Integer.valueOf(reader.readLine());

        Fibonacci fibonacci = new Fibonacci(startPosition, endPosition);
        fibonacci.fillFibonacciList();
        fibonacci.printPartOfSequence();
    }
}
