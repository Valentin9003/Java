package com.company;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        for (int index = number1; index <= number2 ; index++) {

            System.out.print((char)index + " ");
        }
    }
}
