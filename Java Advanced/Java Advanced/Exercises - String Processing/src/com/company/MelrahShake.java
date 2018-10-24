package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String pattern = reader.readLine();

        while (true) {
            int firstIndex = input.indexOf(pattern);
            int lastIndex = input.lastIndexOf(pattern);

            if (firstIndex > -1 && lastIndex > -1 && pattern.length() > 0) {
                StringBuilder sb = new StringBuilder(input);

                sb.replace(firstIndex, pattern.length() + firstIndex, "");
                sb.replace(lastIndex - pattern.length(), pattern.length() + (lastIndex - pattern.length()), "");

                input = sb.toString();
                System.out.println("Shaked it.");
                sb = new StringBuilder(pattern);

                sb.deleteCharAt(pattern.length() / 2);
                pattern = sb.toString();
            } else {
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
        }
    }
}
