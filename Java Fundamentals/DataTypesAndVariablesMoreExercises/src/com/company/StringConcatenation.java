package com.company;

import java.util.Scanner;

public class StringConcatenation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String simbol = scanner.nextLine();
        String evenOrOdd = scanner.nextLine();
        int numberLines = Integer.parseInt(scanner.nextLine());

        String resultEven = "";
        String resultOdd = "";

        for (int i = 1; i <= numberLines ; i++) {
            if (i % 2 == 0) {
                resultEven += scanner.nextLine() + simbol;
            } else {
                resultOdd += scanner.nextLine() + simbol;
            }
        }

        if (evenOrOdd.equals("even")) {
            System.out.println(resultEven.substring(0, resultEven.length() - 1));
        } else {
            System.out.println(resultOdd.substring(0, resultOdd.length() - 1));
        }
    }
}
