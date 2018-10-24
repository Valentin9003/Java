package com.company;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row < n; row++) {
            System.out.printf("%s%s%n",print(" ", n-row),print("* ",row));
        }

        System.out.printf("%s%n",print("* ",n));      // center of the figure

        for (int row = 1; row < n ; row++) {
            System.out.printf("%s%s%n",print(" ",row),print("* ",n-row));
        }

    }
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
