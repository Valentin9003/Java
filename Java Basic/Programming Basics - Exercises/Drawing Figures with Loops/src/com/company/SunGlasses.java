package com.company;

import java.util.Scanner;

public class SunGlasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int rowLength = n * 4 + 1;
        int firstRowStars = n *2;
        int firstRowSpaces = n;

        System.out.printf("%s%s%s%n",
                print("*",firstRowStars),
                print(" ",firstRowSpaces),
                print("*",firstRowStars) );

        int lines = firstRowStars - 2;
        int specialRow = (n-1) / 2 - 1;

        for (int i = 0; i < n-2 ; i++) {
            if (i == specialRow) {
                System.out.printf("*%s*%s*%s*%n",
                        print("/",lines),
                        print("|",firstRowSpaces),
                        print("/",lines));
            } else {
                System.out.printf("*%s*%s*%s*%n",
                        print("/", lines),
                        print(" ", firstRowSpaces),
                        print("/", lines));
            }
        }

        System.out.printf("%s%s%s%n",
                print("*",firstRowStars),
                print(" ",firstRowSpaces),
                print("*",firstRowStars) );

    }
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
