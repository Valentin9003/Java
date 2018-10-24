package com.company;

import java.util.Scanner;

public class Triangle {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());    //[2..50]
        int weigh = 4 * n + 1;
        int hight = 2 * n + 1;

        if (n >= 2 && n <= 50) {

            System.out.printf("%s%n", print("#", weigh));

            int brSimbols = (weigh - 3) / 2;
            int brSpace = 1;
            int specialRow = n / 2 + 1;
            for (int i = 1; i <= n; i++) {
                if (i == specialRow) {
                    int spaces = (brSpace - 3) / 2;
                    System.out.printf("%s%s%s(@)%s%s%s%n",
                            print(".", i),
                            print("#", brSimbols),
                            print(" ", spaces),
                            print(" ", spaces),
                            print("#", brSimbols),
                            print(".", i));
                    brSpace += 2;
                    brSimbols -= 2;
                } else {
                    System.out.printf("%s%s%s%s%s%n",
                            print(".", i),
                            print("#", brSimbols),
                            print(" ", brSpace),
                            print("#", brSimbols),
                            print(".", i));
                    brSpace += 2;
                    brSimbols -= 2;
                }
            }
            int stepLastPast = hight - (n + 1);
            int newSimbols = n * 2 - 1;
            int lastPoints = (weigh - newSimbols) / 2;
            for (int i = 0; i < stepLastPast; i++) {
                System.out.printf("%s%s%s%n",
                        print(".", lastPoints),
                        print("#", newSimbols),
                        print(".", lastPoints));
                lastPoints++;
                newSimbols -= 2;
            }
        }
    }
}
