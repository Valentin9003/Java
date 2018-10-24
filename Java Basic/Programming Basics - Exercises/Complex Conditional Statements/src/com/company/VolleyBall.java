package com.company;

import java.util.Scanner;

public class VolleyBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine().toLowerCase();
        int hollidays = Integer.parseInt(scanner.nextLine());
        int travel = Integer.parseInt(scanner.nextLine());

        double stayAtSofia = (double)(48 - travel);
        double weekendsNotAtWork = stayAtSofia * 3 / 4;  // weekends kogato e v Sofiq i ne e na rabota
        double playInHollidays = (double)(hollidays * 2 / 3);   // -> kolko pati igrae prez praznicite
        double countGame = (double) (weekendsNotAtWork + playInHollidays + travel);

        if ("normal".equals(year)) {
            System.out.println(Math.round(countGame));
        } else if ("leap".equals(year)) {
            countGame += (countGame * 0.15);
            System.out.println(Math.round(countGame));
        }
    }
}
