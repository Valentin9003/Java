package com.company;

import java.util.Scanner;

public class SquareArea {
    public static void main(String[] args) {

        System.out.print("Input side = ");

        Scanner scanner = new Scanner(System.in);

        int side = Integer.parseInt(scanner.nextLine());
//        System.out.println("a= "+side);
        int square = side*side;
        System.out.println("Square = "+square);
    }
}
