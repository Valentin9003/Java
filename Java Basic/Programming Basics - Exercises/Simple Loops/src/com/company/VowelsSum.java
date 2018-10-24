package com.company;

import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        int counter = 0;
        int points = 0;

        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a': counter += 1;  break;
                case 'e': counter += 2; break;
                case 'i': counter += 3; break;
                case 'o': counter += 4; break;
                case 'u': counter += 5; break;
            }
        }
        System.out.println(counter);
    }
}
