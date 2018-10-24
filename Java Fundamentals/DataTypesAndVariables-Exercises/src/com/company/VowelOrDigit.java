package com.company;

import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);

        if (input == 'a' || input == 'e' || input == 'o' || input == 'u' || input == 'i' || input == 'y') {
            System.out.println("vowel");
        } else if (Character.isDigit(input)) {
            System.out.println("digit");
        } else {
            System.out.println("other");
        }
    }
}
