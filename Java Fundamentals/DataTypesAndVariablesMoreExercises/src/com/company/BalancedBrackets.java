package com.company;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        String[] newLine = new String[numberOfLines];

        boolean isBalanced = false;
        int counterOpen = 0;
        for (int i = 0; i < newLine.length ; i++) {
             newLine[i] = scanner.nextLine();

             if (newLine[i].equals(")") && counterOpen == 0) {
                 System.out.println("UNBALANCED");
                 return;
             }
            if (newLine[i].equals("(")) {
                counterOpen++;
            }
            if (newLine[i].equals(")")) {
                 counterOpen--;
            }
        }
        if (counterOpen == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
