package com.company;

import java.util.Scanner;

public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        int[] newArr = new int[input.length];

        for (int i = 0; i <input.length ; i++) {
            newArr[i] = (int)input[i];

            System.out.println(input[i] + " -> " + (newArr[i] - 97));
        }
    }
}
