package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class PracticeFloatingPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = new BigDecimal(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());
        BigDecimal num3 = new BigDecimal(scanner.nextLine());

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
