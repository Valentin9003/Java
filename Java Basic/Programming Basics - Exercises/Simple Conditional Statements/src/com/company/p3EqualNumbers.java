package com.company;

import java.util.Scanner;

public class p3EqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        if (a == b && a == c) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
