package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!"end".equals(line = reader.readLine())) {
            if (Pattern.matches("^\\+359([ |-])2\\1\\d{3}\\1\\d{4}$", line)){
                System.out.println(line);
            }
        }
    }
}
