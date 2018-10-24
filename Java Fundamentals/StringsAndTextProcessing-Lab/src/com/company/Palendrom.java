package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

public class Palendrom {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().trim().split("[\\s:,.;!?'\\[\\]()/]+");
        List<String> palindromsList = new ArrayList<>();

        for (String str : input) {
            if (IsPalindrom(str))
            {
                palindromsList.add(str);
            }
        }
        palindromsList.sort(Collator.getInstance());
        System.out.println(String.join(", ", palindromsList));
    }

    private static boolean IsPalindrom(String str)
    {
        boolean isPalendrom = false;
        StringBuilder sb = new StringBuilder(String.valueOf(str));

        if (str.equals(sb.reverse().toString())) {
            isPalendrom = true;
        }

        return isPalendrom;
    }
}
