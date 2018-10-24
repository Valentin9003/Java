package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ByteFlip {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> bytesList = new ArrayList<>();
        //Reading String[] from console
        String[] bytes = reader.readLine().split(" ");

        //All elements from String[] with length == 2 ->> add to bytesList
        for (String aByte : bytes) {
            if (aByte.length() == 2) {
                bytesList.add(aByte);
            }
        }

        List<String> resultList = new ArrayList<>();
        //Reverse digits on every element from bytesList and add it to resultList
        for (String hexNumber : bytesList) {
            String reversed = "" + hexNumber.charAt(1) + hexNumber.charAt(0);
            resultList.add(reversed);
        }
        //Reverse resultList
        Collections.reverse(resultList);
        //Print result list ->>>
        for (String codeASCII : resultList) {
            int ival =Integer.parseInt(codeASCII, 16);
            System.out.print((char) ival);
        }
    }
}
