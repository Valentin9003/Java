package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringP01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = reader.readLine().toCharArray();

        StringBuilder str = new StringBuilder(String.valueOf(input));

        System.out.println(str.reverse());

    }
}
