package com.company;

import java.util.Scanner;

public class DrawSnowFlake {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int height = 2 * n + 1;
        int width = 2 * n + 3;

        int br = 0;
        int pointsCenterUp = (width - 3) / 2;

        for (int i = 0; i < (n - 1); i++) {
            System.out.printf("%s*%s*%s*%s%n" ,
                    print(".", i),
                    print(".", pointsCenterUp),
                    print(".", pointsCenterUp),
                    print(".", i));
            pointsCenterUp--;
            br++;
        }
        System.out.printf("%s*****%s%n",
                print(".", br),
                print(".", br));

        System.out.printf("%s%n", print("*", width));

        System.out.printf("%s*****%s%n",
                print(".", br),
                print(".", br));

        int pointsDown = 2;
        br--;
        for (int i = 0; i < (n - 1); i++) {
            System.out.printf("%s*%s*%s*%s%n" ,
                    print(".", br),
                    print(".", pointsDown),
                    print(".", pointsDown),
                    print(".", br));
            pointsDown++;
            br--;
        }
    }
}
