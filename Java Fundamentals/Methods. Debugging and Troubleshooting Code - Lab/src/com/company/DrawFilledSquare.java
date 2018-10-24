package com.company;

import java.util.Scanner;

public class DrawFilledSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        DrowHeaderAndFooter(n);

        for (int i = 1; i <= n - 2 ; i++) {
            DrowBody(n);
        }

        DrowHeaderAndFooter(n);
    }

    private static void DrowHeaderAndFooter(int n)
    {
        System.out.printf("%s%n", print("-", n * 2));
    }

    private static void DrowBody(int n)
    {
            System.out.printf("-%s-%n", print("\\/", n - 1));
    }

    private static String print(String element, int count)
    {
        return new String(new char[count]).replace("\0", element);
    }
}
