package com.company;

import java.util.Scanner;

public class X {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int height = n;

        if (n % 2 != 0 && n >= 3 && n <= 99) {

            int stepUpside = n / 2;
            int centerSpace = n - 2;

            for (int i = 0; i < stepUpside ; i++) {
                System.out.printf("%sx%sx%s%n",
                        print(" ", i),
                        print(" ", centerSpace),
                        print(" ", i));
                centerSpace -= 2;
            }
            int centerHalfSpace = (n - 1) / 2;
            System.out.printf("%sx%s%n",
                    print(" ", centerHalfSpace),
                    print(" ", centerHalfSpace));


            int spaseDownPast = (n - 3) / 2;
            int spaceCenterDownPast = 1;

            for (int i = 0; i < stepUpside ; i++) {
                System.out.printf("%sx%sx%s%n",
                        print(" ", spaseDownPast),
                        print(" ", spaceCenterDownPast),
                        print(" ", spaseDownPast));
                spaseDownPast--;
                spaceCenterDownPast +=2;
            }
        }
    }
}