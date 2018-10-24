package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseCodeUpgraded {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> codesList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\|")));

        StringBuilder sbResult = new StringBuilder();
        for (String code : codesList)
        {
            sbResult.append(DecodingTheSymbol(code));
        }

        System.out.println(sbResult.toString());
    }

    private static char DecodingTheSymbol(String code)
    {
        int tokensSum = CalculateTheSum(code);
        int totalSum = AddSequencesWithEqualDigits(code.trim(), tokensSum);

        return (char)totalSum;
    }

    private static int AddSequencesWithEqualDigits(String code, int tokensSum)
    {
        int equalDigitsCount = 1;
        int totalSum = 0;
        for (int i = 1; i < code.length(); i++) {
            if (code.charAt(i) == code.charAt(i - 1)) {
                equalDigitsCount++;
            } else {
                if (equalDigitsCount > 1) {
                    totalSum += equalDigitsCount;
                    equalDigitsCount = 1;
                } else {
                    equalDigitsCount = 1;
                }
            }
        }
        if (equalDigitsCount > 1) {
            totalSum += equalDigitsCount;
        }

        return (totalSum + tokensSum);
    }

    private static int CalculateTheSum(String code)
    {
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == 48) {
                countZero++;
            }
            else if (code.charAt(i) == 49) {
                countOne++;
            }
        }

        return (countZero * 3 + countOne * 5);
    }
}
