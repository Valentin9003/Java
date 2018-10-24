package com.company;

import java.util.Scanner;

public class ChristmasHat {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int weigh = 4 * n + 1;
        int high = 2 * n + 5;

        if (n >= 3 && n <= 100) {

            int firstPoints = (weigh - 3) / 2;
            System.out.printf("%s/|\\%s%n",
                    print(".", firstPoints),
                    print(".", firstPoints));
            System.out.printf("%s\\|/%s%n",
                    print(".", firstPoints),
                    print(".", firstPoints));

            int step = high - 5;
            for (int i = 0; i < step; i++) {
                System.out.printf("%s*%s*%s*%s%n",
                        print(".", firstPoints),
                        print("-", i),
                        print("-", i),
                        print(".", firstPoints));
                firstPoints--;
            }
            System.out.printf("%s%n", print("*", weigh));
            System.out.printf("%s*%n", print("*.", weigh/2));
            System.out.printf("%s%n", print("*", weigh));
        }
    }
}
