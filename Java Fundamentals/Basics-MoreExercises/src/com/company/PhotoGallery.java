package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PhotoGallery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat fPicsNumber = new DecimalFormat("0000");
        DecimalFormat fTime = new DecimalFormat("00");
        DecimalFormat fBytes = new DecimalFormat("#####.#");

        int numbersPhotos = Integer.parseInt(scanner.nextLine());
        byte date = Byte.parseByte(scanner.nextLine());
        byte month = Byte.parseByte(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());
        byte hour = Byte.parseByte(scanner.nextLine());
        byte min = Byte.parseByte(scanner.nextLine());
        double bytes = Double.parseDouble(scanner.nextLine());
        int resolutionWidth = Integer.parseInt(scanner.nextLine());
        int resolutionHeight = Integer.parseInt(scanner.nextLine());


        System.out.println("Name: DSC_" + fPicsNumber.format(numbersPhotos) + ".jpg");
        System.out.printf("Date Taken: %s/%s/%d %s:%s%n", fTime.format(date), fTime.format(month), year, fTime.format(hour), fTime.format(min));

        if (bytes >= 1000000) {
            bytes /= 1000000;
            System.out.println("Size: " + fBytes.format(bytes) + "MB");
        } else if (bytes < 1000) {
            System.out.println("Size: " + fBytes.format(bytes) + "B");
        } else {
            bytes /= 1000;
            System.out.println("Size: " + fBytes.format(bytes) + "KB");
        }

        if (resolutionHeight == resolutionWidth) {
            System.out.printf("Resolution: %dx%d (square)%n", resolutionWidth, resolutionHeight);
        } else if (resolutionWidth < resolutionHeight) {
            System.out.printf("Resolution: %dx%d (portrait)%n", resolutionWidth, resolutionHeight);
        } else {
            System.out.printf("Resolution: %dx%d (landscape)%n", resolutionWidth, resolutionHeight);
        }
    }
}
