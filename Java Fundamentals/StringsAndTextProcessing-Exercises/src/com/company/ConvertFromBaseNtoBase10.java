package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertFromBaseNtoBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        BigInteger curentBase = new BigInteger(inputList.get(0));
        char[] numbers = inputList.get(1).toCharArray();

        int pow = 0;
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = numbers.length - 1; i >= 0 ; i--) {

            int n = numbers[i] - 48;

            BigInteger num = BigInteger.valueOf(n);
            sum = sum.add(num.multiply(curentBase.pow(pow)));

            pow++;
        }

        System.out.println(sum);
    }
}
