package com.company;

import java.util.Scanner;

public class RotateTheSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int rotateTimes = Integer.parseInt(scanner.nextLine());

        int[] normalArr = new int[arr.length];
        for (int i = 0; i < normalArr.length ; i++) {
            normalArr[i] = Integer.parseInt(arr[i]);
        }

//        int[] printArr = new int[normalArr.length];
        int[] sumArr = new int[normalArr.length];

        for (int i = 1; i <= rotateTimes ; i++)
        {
           int[] printArr = RotatingArrays(normalArr, i);
            for (int j = 0; j < sumArr.length; j++)
            {
                sumArr[j] += printArr[j];
            }

        }

        for (int i = 0; i < sumArr.length; i++)
        {
            System.out.print(sumArr[i] + " ");
        }

    }

    private static int[] RotatingArrays(int[] normalArr, int i) {

        int[] rotatedArr = new int[normalArr.length];

        for (int j = 0; j < rotatedArr.length; j++) {
            rotatedArr[(j + i) % normalArr.length] = normalArr[j];
        }
        return rotatedArr;
    }
}
