package com.company;

import java.util.Scanner;

public class NumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int specialNumber = Integer.parseInt(scanner.nextLine());
        int controlNumber = Integer.parseInt(scanner.nextLine());

        boolean reached = true;

        for (int i = firstNumber; i >= 1; i--) {
            for (int j = secondNumber; j >= 1; j--) {
                for (int k = thirdNumber; k >= 1; k--) {

                    int allnumber = i * 100 + j * 10 + k;
                    int br = 0;

                    if (specialNumber >= controlNumber) {
                        reached = false;
                        break;
                    }
                    if (allnumber % 3 == 0) {
                        specialNumber += 5;
                        br++;
                    }
                    if (allnumber % 10 == 5 && br == 0) {
                        specialNumber -= 2;
                        br++;
                    }
                    if (allnumber % 2 == 0 && br == 0) {
                        specialNumber *= 2;
                        br++;
                    }
                }
            }
        }
        if (reached) {
            System.out.printf("No! %d is the last reached special number.", specialNumber);
        } else {
            System.out.printf("Yes! Control number was reached! Current special number is %d.", specialNumber);
        }
    }
}
