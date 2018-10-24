package com.company;

import java.util.Scanner;

public class PracticeCharsAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstRow = scanner.nextLine();
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        char thirdChar = scanner.nextLine().charAt(0);
        String lastRow = scanner.nextLine();

        System.out.println(firstRow);
        System.out.println(firstChar);
        System.out.println(secondChar);
        System.out.println(thirdChar);
        System.out.println(lastRow);
    }
}
