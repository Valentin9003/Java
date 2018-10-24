package com.company;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to Rectangle Area Calculator");
        System.out.println();

        System.out.print("Input a=");
        int a = Integer.parseInt(console.nextLine());

        System.out.print("Input b=");
        int b = Integer.parseInt(console.nextLine());

        System.out.print("Rectangle Area =");
        System.out.println(a*b);
    }
}
