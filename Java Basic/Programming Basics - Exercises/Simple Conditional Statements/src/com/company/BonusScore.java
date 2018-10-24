package com.company;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = 0;
        double number = Integer.parseInt(scanner.nextLine());

        if (number <= 100) {
            a += 5;
        } else if (number > 100 && number <=1000) {
            a = number * 0.2;
        } else if (number > 1000) {
            a = number * 0.1;
        }

        if (number % 2 == 0) {
            a=a+1;
        }
        if (number%10 == 5) {
            a = a+2;
        }

        System.out.println(a);
        System.out.println(number+a);

    }
}
