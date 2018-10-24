package com.company;

import java.util.Scanner;

public class DrawRocket {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int weigh = 3 * n;

        if (n >= 4 && n <= 100 && n % 2 == 0) {

            int firstRowPoints = (weigh - 2) / 2;
            int brSpaces = 0;
            for (int i = 0; i < n; i++) {
                System.out.printf("%s/%s\\%s%n",
                        print(".", firstRowPoints),
                        print(" ", brSpaces),
                        print(".", firstRowPoints));
                brSpaces += 2;
                firstRowPoints--;
            }

            int spaces = (weigh - brSpaces) / 2;
            System.out.printf("%s%s%s%n",
                    print(".",spaces),
                    print("*", brSpaces),
                    print(".",spaces));

            int stepHalf = n * 2;
            firstRowPoints = n /2;
            brSpaces = weigh - (n + 2);
            for (int i = 0; i < stepHalf; i++) {
                System.out.printf("%s|%s|%s%n",
                        print(".", firstRowPoints),
                        print("\\",brSpaces),
                        print(".",firstRowPoints));
            }

            stepHalf = n / 2;
            for (int i = 0; i < stepHalf; i++) {
                System.out.printf("%s/%s\\%s%n",
                        print(".", firstRowPoints),
                        print("*", brSpaces),
                        print(".", firstRowPoints));
                firstRowPoints--;
                brSpaces +=2;
            }

        }
    }
}
