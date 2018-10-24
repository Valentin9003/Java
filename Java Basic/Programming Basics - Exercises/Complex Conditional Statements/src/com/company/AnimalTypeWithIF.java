package com.company;

import java.util.Scanner;

public class AnimalTypeWithIF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        if (name.equals("dog")) {
            System.out.println("mammal");
        } else if (name.equals("crocodile") || name.equals("tortoise") || name.equals("snake")) {
            System.out.println("reptile");
        } else {
            System.out.println("unknown");
        }
    }
}
