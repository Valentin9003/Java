package com.company;

import java.util.Scanner;

public class WorldRecordOnSwiming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double sizeInMeters = Double.parseDouble(scanner.nextLine());
        double timePerOneMeter = Double.parseDouble(scanner.nextLine());

        double needTime = sizeInMeters * timePerOneMeter;
        double inTime = Math.floor((sizeInMeters / 15)) * 12.5;
        double time = needTime + inTime;

        if (time >= record) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", time - record);
        } else {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        }
    }
}
