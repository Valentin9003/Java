package com.company;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hExamp = Integer.parseInt(scanner.nextLine());
        int mExamp = Integer.parseInt(scanner.nextLine());
        int hArive = Integer.parseInt(scanner.nextLine());
        int mArive = Integer.parseInt(scanner.nextLine());

        int exampInMin = hExamp * 60 + mExamp;
        int ariveInMin = hArive * 60 + mArive;

        if ((hExamp >=0 && hExamp <= 23) && (hArive >=0 && hArive <=23)                  // Proverka za korektni danni
                && (mExamp >= 0 && mExamp <=59) && (mArive >= 0 && mArive <=59)) {

            if (ariveInMin > exampInMin) {
                System.out.println("Late");
            } else if ((ariveInMin == exampInMin) || ((exampInMin - ariveInMin) <= 30)) {
                System.out.println("On time");
            } else if ((exampInMin - ariveInMin) > 30) {
                System.out.println("Early");
            }

            if (ariveInMin - exampInMin != 0) {
                if ((exampInMin - ariveInMin) < 60 && (exampInMin - ariveInMin) > 0) {
                    System.out.println((exampInMin - ariveInMin) + " minutes before the start");
                } else if ((exampInMin - ariveInMin) >= 60) {
                    int h = (exampInMin - ariveInMin) / 60;
                    int min = (exampInMin - ariveInMin) % 60;
                    if (min >= 10) {
                        System.out.println(h + ":" + min + " hours before the start");
                    } else {
                        System.out.printf("%d:0%d hours before the start", h, min);
                        System.out.println();
                    }
                } else if ((ariveInMin - exampInMin) < 60 && (ariveInMin - exampInMin) > 0) {
                    System.out.println((ariveInMin - exampInMin) + " minutes after the start");
                } else if ((ariveInMin - exampInMin) >= 60) {
                    int h = (ariveInMin - exampInMin) / 60;
                    int min = (ariveInMin - exampInMin) % 60;
                    if (min >= 10) {
                        System.out.println(h + ":" + min + " hours after the start");
                    } else {
                        System.out.printf("%d:0%d hours after the start", h, min);
                        System.out.println();
                    }
                }
            }
        }
    }
}
