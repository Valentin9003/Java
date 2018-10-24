package com.company;

import java.util.Scanner;

public class DrawCup {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int weigh = 5 * n;
        // first rows are = n/2.
        if (n >= 6 && n <= 100) {                                       // -> next rows are = (n + 2) - firstRows - 1.

            int firstRows = n / 2;
            int brSimbolsFRow = n * 3;
            int brPointsFRow = (weigh - brSimbolsFRow) / 2;
            for (int i = 0; i < firstRows; i++) {
                System.out.printf("%s%s%s%n",
                        print(".", brPointsFRow),
                        print("#", brSimbolsFRow),
                        print(".", brPointsFRow));
                brPointsFRow++;
                brSimbolsFRow -= 2;
            }
            int secondRows = (n + 2) - (firstRows + 1);
            int brPointsSRow = brSimbolsFRow - 2;
            for (int i = 0; i < secondRows; i++) {
                System.out.printf("%s#%s#%s%n",
                        print(".", brPointsFRow),
                        print(".", brPointsSRow),
                        print(".", brPointsFRow));
                brPointsFRow++;
                brPointsSRow -= 2;
            }
            System.out.printf("%s%s%s%n",
                    print(".", (brPointsFRow - 1)),
                    print("#", (brPointsSRow + 4)),
                    print(".", (brPointsFRow - 1)));

            int lastRows = n + 2;
            int lastSimbols = brPointsSRow + 8;
            int lastPoints = (weigh - lastSimbols) / 2;
            int specialRow = (n + 2) / 2;
            String dance = "D^A^N^C^E^";
            int specialPoints = (weigh - dance.length()) / 2;
            for (int i = 1; i <= lastRows; i++) {
                if (i == specialRow) {
                    System.out.printf("%s%s%s%n",
                            print(".", specialPoints),
                            dance ,
                            print(".", specialPoints));
                } else {
                    System.out.printf("%s%s%s%n",
                            print(".", lastPoints),
                            print("#", lastSimbols),
                            print(".", lastPoints));
                }
            }
        }
    }
}
