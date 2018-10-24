package com.company;

import java.util.Scanner;

public class DrawFort {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n >= 3 && n <= 1000){

            int insideCol = n / 2;             // visochina -> n reda
            int sizeAll = 2 * n;
            int centerLinesFirstRow = (2 * n) - 2 *(n / 2) - 4;

            System.out.printf("/%s\\%s/%s\\%n",                                    //FIRST ROW
                    print("^",insideCol),
                    print("_",centerLinesFirstRow),
                    print("^",insideCol));

            int brCol = n - 3;
            int spase = (2 * n) - 2;

            for (int i = 0; i < brCol; i++) {                                      //CENTER ROWS
                System.out.printf("|%s|%n", print(" ",spase));
            }

            System.out.printf("|%s%s%s|%n",                                        //LAST CENTER ROW
                    print(" ",insideCol + 1),
                    print("_",centerLinesFirstRow),
                    print(" ",insideCol + 1));

            System.out.printf("\\%s/%s\\%s/%n",                                   //LAST ROW
                    print("_",insideCol),
                    print(" ",centerLinesFirstRow),
                    print("_",insideCol));

        } else {
            System.out.println("Wrong input");
        }
    }
}
