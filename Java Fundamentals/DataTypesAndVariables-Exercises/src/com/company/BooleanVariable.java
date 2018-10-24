package com.company;

import java.util.Scanner;

public class BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String readThis = scanner.nextLine();
        Boolean transfer = Boolean.valueOf(readThis);

        if (transfer) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
