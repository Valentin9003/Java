package com.company;

import java.util.Scanner;

public class RectangleOf10x10Stars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println(print("*",10));
        }
    }

    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
