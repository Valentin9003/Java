package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CensorEmailAddress {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String email = reader.readLine();
        String text = reader.readLine();

        String[] mailArr = email.split("@");
        int len = mailArr[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        sb.append("@");
        sb.append(mailArr[1]);
        String censoredEmail = sb.toString();

        System.out.println(text.replaceAll(email, censoredEmail));
    }
}
