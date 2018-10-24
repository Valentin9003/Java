package com.company;

import java.util.Scanner;

public class DrawSheriff {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int width = 3 * n;
        int hight = 2 * n + 8;

        int firstPoints = (width - 1) / 2;

        System.out.printf("%sx%s%n",
                print(".", firstPoints),
                print(".", firstPoints));
        firstPoints--;
        System.out.printf("%s/x\\%s%n",
                print(".", firstPoints),
                print(".", firstPoints ));

        System.out.printf("%sx|x%s%n",
                print(".", firstPoints),
                print(".", firstPoints ));

        int simbols = n;
        int poitsCenerUp = n/2;

        for (int i = 0; i < n ; i++) {
            System.out.printf("%s%s|%s%s%n",
                    print(".", poitsCenerUp),
                    print("x", simbols),
                    print("x", simbols),
                    print(".", poitsCenerUp));

            poitsCenerUp --;
            simbols++;

            if (poitsCenerUp < 0 ) {
                break;
            }
        }
        for (int i = 1; i <= n/2 ; i++) {
            System.out.printf("%s%s|%s%s%n",
                    print(".", i),
                    print("x", simbols-2),
                    print("x", simbols-2),
                    print(".", i));

            simbols--;
        }
        int poitsCenter = (width - 3) / 2;
        System.out.printf("%s/x\\%s%n",
                print(".", poitsCenter),
                print(".", poitsCenter));
        System.out.printf("%s\\x/%s%n",
                print(".", poitsCenter),
                print(".", poitsCenter));


        int simbolsDown = n;
        int poitsCenerDown = n/2;

        for (int i = 0; i < n ; i++) {
            System.out.printf("%s%s|%s%s%n",
                    print(".", poitsCenerDown),
                    print("x", simbolsDown),
                    print("x", simbolsDown),
                    print(".", poitsCenerDown));

            poitsCenerDown --;
            simbolsDown++;

            if (poitsCenerDown < 0 ) {
                break;
            }
        }
        for (int i = 1; i <= n/2 ; i++) {
            System.out.printf("%s%s|%s%s%n",
                    print(".", i),
                    print("x", simbolsDown-2),
                    print("x", simbolsDown-2),
                    print(".", i));

            simbolsDown--;
        }

        System.out.printf("%sx|x%s%n",
                print(".", firstPoints),
                print(".", firstPoints ));
        System.out.printf("%s\\x/%s%n",
                print(".", firstPoints),
                print(".", firstPoints ));
        System.out.printf("%sx%s%n",
                print(".", firstPoints + 1),
                print(".", firstPoints + 1));
    }
}


