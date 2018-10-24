package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TheaThePhotographer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("00");
        DecimalFormat df2 = new DecimalFormat("#0");

        long numberOfPictures = Long.parseLong(scanner.nextLine());
        long filterTime = Long.parseLong(scanner.nextLine());
        long filterPercent = Long.parseLong(scanner.nextLine());
        long uploadedTime = Long.parseLong(scanner.nextLine());

        long filtredPictures = (long)Math.ceil(numberOfPictures * filterPercent / 100);
        long totalPicturesTime = numberOfPictures * filterTime;                // in sec
        long uploadTimeFiltredPictures = filtredPictures * uploadedTime;       // in sec
        long totalTime = totalPicturesTime + uploadTimeFiltredPictures;        // in sec

        long secounds = totalTime % 60;
        totalTime = totalTime - secounds;
        long hours = totalTime / 3600;
        long minutes = totalTime / 60 - hours * 60;
        long days = hours / 24;
        hours = totalTime / 3600 - days * 24;

        System.out.printf("%s:%s:%s:%s", df2.format(days), df.format(hours), df.format(minutes), df.format(secounds));
    }
}