package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertFromBase10ToBaseN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));

        long newBase = Long.parseLong(input.get(0));
        long numberInBase10 = Long.parseLong(input.get(1));

        List<Long> myList=new ArrayList<>();
        long remainder;

        while (numberInBase10 != 0)
        {
            remainder = numberInBase10 % newBase;
            numberInBase10 = numberInBase10 / newBase;

            myList.add(remainder);
        }

        Collections.reverse(myList);

        for (Long number : myList) {
            System.out.print(number);
        }
    }
}
