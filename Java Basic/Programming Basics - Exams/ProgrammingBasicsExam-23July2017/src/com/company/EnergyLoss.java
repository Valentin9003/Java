package com.company;

import java.util.Scanner;

public class EnergyLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brTrainingDays = Integer.parseInt(scanner.nextLine());
        int brDancers = Integer.parseInt(scanner.nextLine());
        double avarage = 0.00;

        for (int i = 1; i <= brTrainingDays ; i++) {
            int trainingH = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0 && trainingH % 2 == 0) {
                avarage += brDancers * 68;
            } else if (i % 2 != 0 && trainingH % 2 == 0) {
                avarage += brDancers * 49;
            } else if (i % 2 == 0 && trainingH % 2 != 0) {
                avarage += brDancers * 65;
            } else if (i % 2 != 0 && trainingH % 2 != 0) {
                avarage += brDancers * 30;
            }
        }
        double sumEnergy = 100 * brDancers * brTrainingDays;
        double notWasteEnergyForAllDays = sumEnergy - avarage;
        double notWasteDancerPerDay = notWasteEnergyForAllDays / brDancers / brTrainingDays;

        if (notWasteDancerPerDay > 50) {
            System.out.printf("They feel good! Energy left: %.2f", notWasteDancerPerDay);
        } else {
            System.out.printf("They are wasted! Energy left: %.2f", notWasteDancerPerDay);
        }
    }
}
