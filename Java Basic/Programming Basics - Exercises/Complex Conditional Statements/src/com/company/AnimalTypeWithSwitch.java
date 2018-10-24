package com.company;

import java.util.Scanner;

public class AnimalTypeWithSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        switch (name) {
            case "dog":
                System.out.println("mammal"); break;
            case "crocodile":
            case "tortoise":
            case "snake": System.out.println("reptile"); break;
            default: System.out.println("unknown"); break;
        }
    }
}
