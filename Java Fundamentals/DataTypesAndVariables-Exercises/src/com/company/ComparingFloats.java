package com.company;

import java.util.Scanner;

public class ComparingFloats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        boolean isTrue = true;

        double compareVarible = 0.000001;

        double equals = Math.abs(a-b);

        if (equals < compareVarible) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        String bool = Boolean.toString(isTrue);
        bool = Character.toString(bool.charAt(0)).toUpperCase()+bool.substring(1);

        System.out.println(bool);
    }
}
