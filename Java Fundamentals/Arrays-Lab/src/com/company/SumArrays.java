package com.company;

import java.util.Scanner;

public class SumArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrFirstLine = scanner.nextLine().split(" ");
        String[] arrSecondLine = scanner.nextLine().split(" ");

        int[] firstArr = new int[arrFirstLine.length];
        for (int i = 0; i < firstArr.length; i++) {
            firstArr[i] = Integer.parseInt(arrFirstLine[i]);
        }
        int[] secondArr = new int[arrSecondLine.length];
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = Integer.parseInt(arrSecondLine[i]);
        }

        int[] newPrintArr = new int[Math.max(firstArr.length, secondArr.length)];
        for (int i = 0; i < newPrintArr.length; i++) {
            newPrintArr[i] = firstArr[i % firstArr.length] + secondArr[i % secondArr.length];
        }

        for (int i = 0; i < newPrintArr.length; i++) {
            System.out.print(newPrintArr[i] + " ");
        }
    }
}
