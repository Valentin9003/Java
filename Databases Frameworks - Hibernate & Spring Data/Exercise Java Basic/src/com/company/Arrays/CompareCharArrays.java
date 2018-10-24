package com.company.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareCharArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] inputArr = reader.readLine().replaceAll(" ", "").toCharArray();
        char[] inputArr2 = reader.readLine().replaceAll(" ", "").toCharArray();

        boolean retval= Arrays.equals(inputArr, inputArr2);

        if (retval)
        {
            if (CompareLetters(inputArr, inputArr2)) {
                for (int i = 0; i < inputArr2.length; i++) {
                    System.out.print(inputArr2[i]);
                }
                System.out.println();
                for (int i = 0; i < inputArr.length; i++) {
                    System.out.print(inputArr[i]);
                }
            }  else {
                for (int i = 0; i < inputArr.length; i++) {
                    System.out.print(inputArr[i]);
                }
                System.out.println();
                for (int i = 0; i < inputArr2.length; i++) {
                    System.out.print(inputArr2[i]);
                }
            }
        }
        else if (inputArr.length > inputArr2.length)
        {
            for (int i = 0; i < inputArr2.length; i++) {
                System.out.print(inputArr2[i]);
            }
            System.out.println();
            for (int i = 0; i < inputArr.length; i++) {
                System.out.print(inputArr[i]);
            }
        }
        else
        {
            for (int i = 0; i < inputArr.length; i++) {
                System.out.print(inputArr[i]);
            }
            System.out.println();
            for (int i = 0; i < inputArr2.length; i++) {
                System.out.print(inputArr2[i]);
            }
        }
    }

    private static boolean CompareLetters(char[] inputArr, char[] inputArr2) {

        boolean isFirst = false;

        for (int i = 0; i < inputArr.length ; i++) {
            if (inputArr[i] <= inputArr2[i]) {
                isFirst = true;
                break;
            }
        }

        return isFirst;
    }
}
