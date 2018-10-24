package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Choreography {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##0.00");

        double brSteps = Double.parseDouble(scanner.nextLine());
        double brDancer = Double.parseDouble(scanner.nextLine());
        double daysForStudy = Double.parseDouble(scanner.nextLine());

        double stepsPerDay = (brSteps / daysForStudy) / brSteps * 100;
        double steps = Math.ceil(stepsPerDay);
        double stepsForEveryoneDancer = steps / brDancer;

        if (steps <= 13) {
            System.out.println("Yes, they will succeed in that goal! " + df.format(stepsForEveryoneDancer) + "%.");
        } else {
            System.out.println("No, They will not succeed in that goal! Required " + df.format(stepsForEveryoneDancer) + "% steps to be learned per day.");
        }
    }
}
