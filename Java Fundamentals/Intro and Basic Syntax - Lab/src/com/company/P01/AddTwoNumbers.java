package com.company.P01;

import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int sum = a + b;

        System.out.println(a + " + " + b + " = " + sum );
//        System.out.printf("%d + %d = %d", a,b,sum);
    }
}
