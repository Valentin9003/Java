package com.company;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        min = min + 30;

        if (min > 59) {
            min = min - 60;
            hour++;
            if (hour > 23) {
                hour = 0;
            }
        }
        if (min < 10) {
            System.out.printf("%d:%02d", hour,min);
        } else {
            System.out.printf("%d:%d", hour,min);
        }
    }
}
