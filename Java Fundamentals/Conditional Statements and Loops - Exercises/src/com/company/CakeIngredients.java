package com.company;

import java.util.Scanner;

public class CakeIngredients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int br = 0;

        while (!input.equals("Bake!")) {
            System.out.printf("Adding ingredient %s.%n", input);
            input = scanner.nextLine();
            br++;
        }
        System.out.printf("Preparing cake with %d ingredients.", br);
    }
}
