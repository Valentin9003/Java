package com.company;

import java.util.Scanner;

public class ThreeBrothers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstBrother = Double.parseDouble(scanner.nextLine());
        double secondBrother = Double.parseDouble(scanner.nextLine());
        double thirdBrother = Double.parseDouble(scanner.nextLine());
        double fishingTime = Double.parseDouble(scanner.nextLine());

        double allTime = (1 / (1 / firstBrother + 1 / secondBrother + 1 / thirdBrother)) ;
        double timeWithPause = allTime + allTime * 0.15;

        System.out.printf("Cleaning time: %.2f%n", timeWithPause);

        if (fishingTime >= timeWithPause) {
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.", Math.floor(fishingTime - timeWithPause));
        } else {
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.", Math.ceil(timeWithPause - fishingTime));
        }
    }
}
