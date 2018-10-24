package com.company;

import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.printf("+ %s+%n",print("- ",n-2));

        for (int i = 1; i <= n-2 ; i++) {
            System.out.printf("| %s| %n",print("- ",n-2));
        }

        System.out.printf("+ %s+%n",print("- ",n-2));

    }

    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
