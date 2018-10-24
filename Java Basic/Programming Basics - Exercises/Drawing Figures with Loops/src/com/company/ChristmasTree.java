package com.company;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int space = n;
        String center = " | ";

        System.out.printf("%s%s %n",print(" ",n),center);

        for (int i = 1; i <= n  ; i++) {
            System.out.printf("%s%s%s%s %n",
                    print(" ",n-i),
                    print("*",i),
                    center,
                    print("*",i));
        }
    }
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
