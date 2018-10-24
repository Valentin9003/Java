package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TakeSkipRope {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputList.add(String.valueOf(input.charAt(i)));
        }

        List<String> digitsList = new ArrayList<>();
        //Take every digit from the inputList and store it in digitsList
        for (String s : inputList) {
            if (s.chars().allMatch(Character::isDigit)) {
                digitsList.add(s);
            }
        }
        //After that remove all the digits from the inputList
        for (String number : digitsList) {
            if (inputList.contains(number)) {
                inputList.remove(number);
            }
        }

        List<String> takeList = new ArrayList<>();
        List<String> skipList = new ArrayList<>();
        //Take every digit in the digitsList and split it up into a takeList and a skipList, depending on whether the digit is in an even or an odd index
        for (int i = 0; i < digitsList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(digitsList.get(i));
            } else {
                skipList.add(digitsList.get(i));
            }
        }

        List<String> resultString = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < skipList.size(); i++) {
            int skip = Integer.parseInt(skipList.get(i));
            int take = Integer.parseInt(takeList.get(i));
            String buffer = "";

            inputList.stream().skip(total).limit(take).forEach(resultString::add);

            total += (skip + take);
        }

        System.out.println(String.join("", resultString));
    }
}
