package com.company;

import java.util.Scanner;

public class HelloName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.println(PrintName(name));
    }

    private static String PrintName(String name)
    {
        String output = "Hello, " + name + "!";
        return output;
    }
}
