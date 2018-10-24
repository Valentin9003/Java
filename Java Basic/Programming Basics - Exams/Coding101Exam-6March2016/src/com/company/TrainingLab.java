package com.company;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double weight = Double.parseDouble(scanner.nextLine());            // dyljina v metri
        double height = Double.parseDouble(scanner.nextLine());            // shirochina v metri

        if (weight <= 100) {
            if (height >= 3 || height <= weight) {
                double tableOnRoll = (int) ((height * 100 - 100) / 70);
                double rolls = (int) ((weight * 100) / (80 + 40));

                System.out.printf("%.0f", (tableOnRoll * rolls - 3));
            }
        }
    }
}
