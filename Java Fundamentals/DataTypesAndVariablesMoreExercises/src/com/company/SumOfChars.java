package com.company;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLetters = Integer.parseInt(scanner.nextLine());
        char[] lettersArr = new char[numberOfLetters];

        int result = 0;
        for (int i = 0; i < lettersArr.length ; i++) {
            lettersArr[i] = scanner.nextLine().charAt(0);
            result += lettersArr[i];
        }

        System.out.println("The sum equals: " + result);
    }
}
