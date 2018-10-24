package com.company;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        short capacity = 255;
        short capacityLeft = capacity;

        for (short i = 0; i < n; i++)
        {
            short litersToPour = Short.parseShort(scanner.nextLine());

            if (capacityLeft - litersToPour >= 0)
            {
                capacityLeft -= litersToPour;
            }
            else
            {
                System.out.println("Insufficient capacity!");
            }
        }

        short filled = (short) (capacity - capacityLeft);
        System.out.println(filled);
    }
}
