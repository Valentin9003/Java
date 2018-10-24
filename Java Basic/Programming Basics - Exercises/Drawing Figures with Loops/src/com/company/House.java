package com.company;

import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int rowsUp = (n+1) / 2;
        int starsEven = 2;
        int starsOdd = 1;

        if (n % 2 == 0) {
            int lines = (n - starsEven) / 2;
            System.out.printf("%s%s%s%n",
                    print("-", lines),
                    print("*", starsEven),
                    print("-", lines));
        } else if (n %2 != 0){
            int lines = (n - starsOdd) / 2;
            System.out.printf("%s%s%s%n",
                    print("-", lines),
                    print("*", starsOdd),
                    print("-", lines));
        }
        for (int i = 1; i < rowsUp ; i++) {
            if (n % 2 == 0) {
                int stars = starsEven + i * 2;
                int lines = (n - stars) / 2;
                System.out.printf("%s%s%s%n",
                        print("-", lines),
                        print("*", stars),
                        print("-",lines));
            } else {
                int stars = starsOdd + i * 2;
                int lines = (n - stars) / 2;
                System.out.printf("%s%s%s%n",
                        print("-", lines),
                        print("*", stars),
                        print("-",lines));
            }
        }
        for (int i = 0; i < n/2 ; i++) {
            int stars = n - 2;
            System.out.printf("|%s|%n", print("*",stars));
        }

    }
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
}
