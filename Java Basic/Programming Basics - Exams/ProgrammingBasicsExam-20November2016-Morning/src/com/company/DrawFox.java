package com.company;

import java.util.Scanner;

public class DrawFox {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int weigh = 2 * n + 3;

        if (n >= 7 && n <= 57 && n % 2 != 0) {

            int lines = weigh - 4;
            for (int i = 1; i <= n; i++) {
                System.out.printf("%s\\%s/%s%n",
                        print("*", i),
                        print("-", lines),
                        print("*", i));
                lines -=2;
            }
            int stepHalfPast = n / 3;
            int starsCenter = n;
            int starsLeftRight = (weigh - (n + 4)) / 2;
            for (int i = 0; i < stepHalfPast; i++) {
                System.out.printf("|%s\\%s/%s|%n",
                        print("*", starsLeftRight),
                        print("*", starsCenter),
                        print("*", starsLeftRight));
                starsLeftRight++;
                starsCenter -= 2;
            }
            int starsLastPast = weigh - 4;
            for (int i = 1; i <= n; i++) {
                System.out.printf("%s\\%s/%s%n",
                        print("-", i),
                        print("*", starsLastPast),
                        print("-", i));
                starsLastPast -=2;
            }
        }
    }
}
