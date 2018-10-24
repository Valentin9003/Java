package com.company.P01;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}

