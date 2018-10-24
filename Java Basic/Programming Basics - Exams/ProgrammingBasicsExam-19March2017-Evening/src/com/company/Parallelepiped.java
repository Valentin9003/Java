package com.company;

import java.util.Scanner;

public class Parallelepiped {
    private static String print(String element, int count) {                           //  Метод
        return new String(new char[count]).replace("\0", element);                     //  Метод
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int hight = 4 * n + 4;
        int weigh = 3 * n + 1;

        int simbols = n - 2;
        int firstRowPoints = weigh - n;
        System.out.printf("+%s+%s%n",
                print("~", simbols),
                print(".", firstRowPoints));

        int step = (hight - 2) / 2;
        int thisRowPoints = weigh - (n + 1);
        for (int i = 0; i < step; i++) {
            System.out.printf("|%s\\%s\\%s%n",
                    print(".", i),
                    print("~", simbols),
                    print(".", thisRowPoints));
            thisRowPoints--;
        }
        int points = weigh - (n + 1);
        for (int i = 0; i < step; i++) {
            System.out.printf("%s\\%s|%s|%n",
                    print(".", i),
                    print(".", points),
                    print("~", simbols));
            points--;
        }

        System.out.printf("%s+%s+%n",
                print(".", firstRowPoints),
                print("~", simbols));
    }
}
