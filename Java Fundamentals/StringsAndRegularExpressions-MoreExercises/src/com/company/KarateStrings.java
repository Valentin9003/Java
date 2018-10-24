package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KarateStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputList = new ArrayList<>(Arrays.asList(reader.readLine().split(">")));

        StringBuilder sb = new StringBuilder();
        sb.append(inputList.get(0));

        Pattern pattern = Pattern.compile("(\\b\\d+)(?:\\w+)?");
        int buffPunch = 0;
        for (int i = 1; i < inputList.size(); i++)
        {
            Matcher matcher = pattern.matcher(inputList.get(i));

            int punchPower = 0;
            if (matcher.find()) {
                punchPower += Integer.parseInt(matcher.group(1));
            }

            int fullPower = punchPower + buffPunch;
            if (fullPower <= inputList.get(i).length()) {
                String subStr = inputList.get(i).substring(fullPower, inputList.get(i).length());
                sb.append(">" + subStr);
                buffPunch = 0;
            } else {
                buffPunch = Math.abs(inputList.get(i).length() - fullPower);
                sb.append(">");
            }
        }

        System.out.println(sb.toString());
    }
}
