package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();

        StringBuilder sb = new StringBuilder(inputLine);
        System.out.println(sb.reverse().toString());
    }
}
