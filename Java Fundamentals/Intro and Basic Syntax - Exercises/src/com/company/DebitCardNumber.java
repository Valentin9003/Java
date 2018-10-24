package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DebitCardNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0000");

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());

        System.out.print(df.format(a) + " " + df.format(b) + " " + df.format(c) + " " + df.format(d));
    }
}
