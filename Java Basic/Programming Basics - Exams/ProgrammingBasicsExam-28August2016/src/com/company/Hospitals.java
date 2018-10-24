package com.company;

import java.util.Scanner;

public class Hospitals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int brTreated = 0;
        int brUntreated = 0;
        int check = 3;

        for (int i = 1; i <= period; i++) {
            int patients = Integer.parseInt(scanner.nextLine());

            if (i % check == 0 && brUntreated > brTreated) {
                doctors++;
            }
            if (patients < doctors) {
                brTreated += patients;
                brUntreated += 0;
            } else if (patients == doctors) {
                brTreated += patients;
                brUntreated += 0;
            } else {
                brTreated += doctors;
                brUntreated += patients - doctors;
            }
        }

        System.out.println("Treated patients: " + brTreated + ".");
        System.out.println("Untreated patients: " + brUntreated + ".");
    }
}
