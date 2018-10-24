package com.company;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println(Math.max(a,b));
    }
}
