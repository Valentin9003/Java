package com.company;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = Integer.parseInt(scanner.nextLine());

        if (startNumber > 10) {
            int sum = number * startNumber;
            System.out.printf("%d X %d = %d%n", number, startNumber, sum);
            return;
        }

        for (int i = startNumber; i <= 10 ; i++) {
            int sum = number * i;
            System.out.printf("%d X %d = %d%n", number, i, sum);
        }
    }
}
