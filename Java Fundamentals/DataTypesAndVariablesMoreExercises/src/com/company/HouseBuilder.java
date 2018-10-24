package com.company;

import java.util.Scanner;

public class HouseBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long price1 = Integer.parseInt(scanner.nextLine());
        long price2 = Integer.parseInt(scanner.nextLine());

        CalculateTheMoneyNeededForTheHouse(price1, price2);

    }

    private static void CalculateTheMoneyNeededForTheHouse(long price1, long price2) {
        if (price1 > Byte.MAX_VALUE) {
            System.out.println(price1 * 10 + price2 * 4);
        }
        else {
            System.out.println(price2 * 10 + price1 * 4);
        }
    }
}
