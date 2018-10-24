package com.company;

import java.util.Scanner;

public class ControlNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int controlNumber = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int br = 0;

        for (int i = 1; i <= firstNumber ; i++) {
            for (int j = secondNumber; j >= 1 ; j--) {
                sum += i * 2 + j * 3;
                br++;

                if (sum >= controlNumber) {
                    System.out.println(br + " moves");
                    System.out.println("Score: " + sum + " >= " + controlNumber);
                    return;
                }
            }
        }
        System.out.println(br + " moves");
    }
}
