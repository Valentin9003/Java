package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> resultSet = new TreeSet<>();

        String[] text = reader.readLine().split("[ ,.?!]+");
        for (String str : text) {
            if (isPalindrom(str))
                resultSet.add(str);
        }
        System.out.println(resultSet);
    }

    private static boolean isPalindrom(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str));

        return str.equals(sb.reverse().toString());
    }
}
