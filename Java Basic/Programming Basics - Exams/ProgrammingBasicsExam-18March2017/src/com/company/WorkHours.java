package com.company;

import java.util.Scanner;

public class WorkHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int needHours = Integer.parseInt(scanner.nextLine());
        int brWorkers = Integer.parseInt(scanner.nextLine());
        int workDays = Integer.parseInt(scanner.nextLine());

        int allTime = brWorkers * workDays * 8;

        if (allTime >= needHours) {
            System.out.println((allTime - needHours) + " hours left");
        } else {
            System.out.println((needHours - allTime) + " overtime ");
            System.out.println("Penalties: " + ((needHours - allTime)*workDays));
        }
    }
}
