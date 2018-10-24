package com.company;

import java.util.Scanner;

public class ButterflyDraw {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());           // [3...1000]

        if (n >= 3 && n <= 1000) {

            int width = 2 * n - 1;               // cols
            int height = 2 * (n - 2) + 1;        // rows
            int leftAndRightWidth = n - 1;

            for (int i = 1; i <= (n - 2); i++) {                          // UP PAST
                if (i % 2 == 0) {
                    System.out.printf("%s\\ /%s%n",
                            print("-", (n - 2)),
                            print("-", (n - 2)));
                } else {
                    System.out.printf("%s\\ /%s%n",
                            print("*", (n - 2)),
                            print("*", (n - 2)));
                }
            }

            int spaseCenter = n - 1;
            System.out.printf("%s@%n", print(" ", spaseCenter));      // CENTER

            for (int i = 1; i <= (n - 2); i++) {                          // DOWN PAST
                if (i % 2 == 0) {
                    System.out.printf("%s/ \\%s%n",
                            print("-", (n - 2)),
                            print("-", (n - 2)));
                } else {
                    System.out.printf("%s/ \\%s%n",
                            print("*", (n - 2)),
                            print("*", (n - 2)));
                }
            }
        } else {
            System.out.println("Wrong input!!!");
        }
    }
}
