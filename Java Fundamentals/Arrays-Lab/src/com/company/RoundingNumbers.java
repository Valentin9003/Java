package com.company;

import java.util.Scanner;

public class RoundingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");

        double[] doubleArray = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            doubleArray[i] = Double.parseDouble(arr[i]);
        }

        for (int i = 0; i < doubleArray.length; i++) {
            if (doubleArray[i] > 0) {
                System.out.println(doubleArray[i] + " => " + Math.round(doubleArray[i]));
            }
        }

    }
}
