package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromesP04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().trim().split("[\\s:,.;!?'\\[\\]()/]+");
        List<String> polindroms = new ArrayList<>();

        for (String s : input) {
            int halfPt = s.length() / 2;

            String first;
            String second;
            if (s.length() % 2 == 0) {
                first = s.substring(0, halfPt);
                second = s.substring(halfPt, s.length());
                StringBuilder str = new StringBuilder(String.valueOf(second));
                second = str.reverse().toString();
            } else {
                first = s.substring(0, halfPt);
                second = s.substring(halfPt + 1, s.length());
            }

            if (first.equals(second)) {
                polindroms.add(s);
            }
        }

        Collections.sort(polindroms, Collator.getInstance());
        System.out.println(String.join(", ", polindroms));
    }
}
