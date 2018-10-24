package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] inputArr = scanner.nextLine().replaceAll(" ", "").toCharArray();
        char[] inputArr2 = scanner.nextLine().replaceAll(" ", "").toCharArray();

        boolean retval=Arrays.equals(inputArr, inputArr2);

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
