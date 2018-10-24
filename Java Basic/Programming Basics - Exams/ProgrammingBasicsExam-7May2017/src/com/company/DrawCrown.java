package com.company;

import java.util.Scanner;

public class DrawCrown {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int weigh = (2 * n) - 1;
        int hight = (n / 2) + 4;
        int firstRowSpace = (weigh - 3) / 2;

        if ((n >= 8) && (n <= 50) && (n % 2 == 0)) {

            System.out.printf("@%s@%s@%n",
                    print(" ", firstRowSpace),
                    print(" ", firstRowSpace));

            System.out.printf("**%s*%s**%n",
                    print(" ", firstRowSpace - 1),
                    print(" ", firstRowSpace - 1));

            int pointsLeftRight = 1;
            int brPt = 1;
            int nextSpace = firstRowSpace - 3;
            int step = hight - 6;
            for (int i = 1; i <= step; i++) {
                System.out.printf("*%s*%s*%s*%s*%s*%n",
                        print(".", i),
                        print(" ", nextSpace),
                        print(".", brPt),
                        print(" ", nextSpace),
                        print(".", i));
                brPt +=2;
                nextSpace -= 2;
                pointsLeftRight++;
            }

            int starsCenter = 1;
            for (int i = 1; i <= 2 ; i++) {
                System.out.printf("*%s%s%s%s%s*%n",
                        print(".", pointsLeftRight),
                        print("*", starsCenter),
                        print(".", brPt),
                        print("*", starsCenter),
                        print(".", pointsLeftRight));
                brPt = 1;
                pointsLeftRight++;
                starsCenter = step;
            }
            int lastStep = hight - (step + 4);
            for (int i = 0; i < lastStep; i++) {
                System.out.printf("%s%n", print("*", weigh));
            }
        }
    }
}
