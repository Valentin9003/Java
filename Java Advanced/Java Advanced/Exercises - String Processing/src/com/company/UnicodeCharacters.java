package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append(unicodeEscaped(c));
        }

        System.out.println(result.toString());
    }

    private static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }
}
