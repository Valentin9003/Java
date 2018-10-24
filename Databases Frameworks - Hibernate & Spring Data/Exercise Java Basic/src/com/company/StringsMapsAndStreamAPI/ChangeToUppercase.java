package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeToUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputText = reader.readLine();

        int startPos = inputText.indexOf("<upcase>");
        int endPos = inputText.indexOf("</upcase>");

        while (inputText.contains("<upcase>")) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputText, 0, startPos);
            sb.append(inputText.toUpperCase(), startPos + 8, endPos);
            sb.append(inputText, endPos + 9, inputText.length());

            inputText = sb.toString();
            startPos = inputText.indexOf("<upcase>");
            endPos = inputText.indexOf("</upcase>");
        }

        System.out.println(inputText);
    }
}
