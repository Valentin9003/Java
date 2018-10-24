package com.company;

import java.util.Scanner;

public class DrawSoftUniLogo {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int high = 4 * n - 2;
        int weigh = 12 * n - 5;

        int firstRowPoits = (weigh - 1) / 2;
        int br = 1;
        for (int i = 1; i <= high ; i++) {
            if (br > weigh) {
                break;
            }
            System.out.printf("%s%s%s%n",
                    print(".",firstRowPoits),
                    print("#",br),
                    print(".",firstRowPoits));
            br += 6;
            firstRowPoits -= 3;
        }
        br = 3;
        int thisrowSimbols = weigh - 6;
        for (int i = 1; i <= n-2 ; i++) {
            System.out.printf("|%s%s%s%n",
                    print(".", br - 1),
                    print("#", thisrowSimbols),
                    print(".", br));
            thisrowSimbols -= 6;
            br +=3;
        }

        int step = high - (1 + n*2 + n-2);
        for (int i = 1; i <= step ; i++) {
            System.out.printf("|%s%s%s%n",
                    print(".", br - 1),
                    print("#", thisrowSimbols),
                    print(".", br));
        }
        System.out.printf("@%s%s%s%n",
                print(".", br - 1),
                print("#", thisrowSimbols),
                print(".", br));
    }}
