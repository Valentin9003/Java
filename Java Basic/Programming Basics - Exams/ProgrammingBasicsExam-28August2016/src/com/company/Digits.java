package com.company;

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int row = (number / 100) + (number / 10 - (number / 100) * 10);
        int col = (number / 100) + (number % 10);

        int firstNumber = number / 100;
        int secondNumber = (number / 10 - (number / 100) * 10);
        int thirdNumber = number % 10;

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {

                if ( number % 5 == 0) {
                    number -= firstNumber;
                }
                else if (number % 3 == 0) {
                    number -= secondNumber;
                }
                else {
                    number += thirdNumber;
                }

                System.out.print( number + " " );
            }
            System.out.println();
        }
    }
}
