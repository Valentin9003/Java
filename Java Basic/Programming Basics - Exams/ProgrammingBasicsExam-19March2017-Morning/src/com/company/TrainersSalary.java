package com.company;

import java.util.Scanner;

public class TrainersSalary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lessons = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double moneyPerLesson = budget / lessons;
        double br1 = 0;
        double br2 = 0;
        double br3 = 0;
        double br4 = 0;
        double br5 = 0;
        double br6 = 0;

        for (int i = 0; i < lessons; i++) {
            String name = scanner.nextLine();
            if ("Jelev".equalsIgnoreCase(name)) {
                br1++;
            } else if ("RoYaL".equalsIgnoreCase(name)) {
                br2++;
            } else if ("Roli".equalsIgnoreCase(name)) {
                br3++;
            } else if ("Trofon".equalsIgnoreCase(name)) {
                br4++;
            } else if ("Sino".equalsIgnoreCase(name)) {
                br5++;
            } else {
                br6++;
            }
        }
        System.out.printf("Jelev salary: %.2f lv%n",br1*moneyPerLesson );
        System.out.printf("RoYaL salary: %.2f lv%n",br2*moneyPerLesson );
        System.out.printf("Roli salary: %.2f lv%n",br3*moneyPerLesson );
        System.out.printf("Trofon salary: %.2f lv%n",br4*moneyPerLesson );
        System.out.printf("Sino salary: %.2f lv%n",br5*moneyPerLesson );
        System.out.printf("Others salary: %.2f lv",br6*moneyPerLesson );
    }
}
