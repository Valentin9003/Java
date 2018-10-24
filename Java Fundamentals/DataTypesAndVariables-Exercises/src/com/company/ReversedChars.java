package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter1 = scanner.nextLine().charAt(0);
        char letter2 = scanner.nextLine().charAt(0);
        char letter3 = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c", letter3, letter2, letter1);
    }
}
