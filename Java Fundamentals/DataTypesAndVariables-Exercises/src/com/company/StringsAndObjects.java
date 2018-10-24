package com.company;

import java.util.Scanner;

public class StringsAndObjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();

        System.out.printf("%s %s", first, second);
    }
}
