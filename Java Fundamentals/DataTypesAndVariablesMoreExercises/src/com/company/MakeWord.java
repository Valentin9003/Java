package com.company;

import java.util.Scanner;

public class MakeWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] word = new String[n];

        for (int i = 0; i < word.length ; i++) {
            word[i] = scanner.nextLine();
        }

        System.out.print("The word is: ");
        for (int i = 0; i < word.length ; i++) {
            System.out.print(word[i]);
        }
    }
}
