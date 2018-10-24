package com.company;

import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String hex = Integer.toHexString(number);
        String binary = Integer.toBinaryString(number);

        System.out.println(hex.toUpperCase());
        System.out.println(binary);
    }
}
