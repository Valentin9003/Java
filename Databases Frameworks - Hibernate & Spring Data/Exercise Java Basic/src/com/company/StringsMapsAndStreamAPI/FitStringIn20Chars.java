package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitStringIn20Chars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = reader.readLine();

        StringBuilder sb = new StringBuilder();
        if (inputStr.length() < 20) {
            sb.append(inputStr);
            for (int i = inputStr.length() + 1; i <= 20; i++) {
                sb.append("*");
            }
        } else if (inputStr.length() == 20) {
            System.out.println(inputStr);
        } else {
            sb.append(inputStr, 0, 20);
        }

        System.out.println(sb.toString());
    }
}
