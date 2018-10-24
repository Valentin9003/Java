package com.company;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();                       //- “Winter”, “Spring” или “Summer”;
        String typeGroup = scanner.nextLine().toLowerCase();     //“boys”, “girls” или “mixed”;
        int brStudents = Integer.parseInt(scanner.nextLine());
        int brNights = Integer.parseInt(scanner.nextLine());
        String sport = "";
        double price = 0.0;

        switch (season){
            case "Winter":
                switch (typeGroup) {
                    case "boys": sport = "Judo"; price += brStudents * 9.6 * brNights;
                        break;
                    case "girls": sport = "Gymnastics"; price += brStudents * 9.6 * brNights;
                        break;
                    case "mixed": sport = "Ski"; price += brStudents * 10 * brNights;
                        break;
                }
                break;
            case "Spring":
                switch (typeGroup) {
                    case "boys": sport = "Tennis"; price += brStudents * 7.2 * brNights;
                        break;
                    case "girls": sport = "Athletics"; price += brStudents * 7.2 * brNights;
                        break;
                    case "mixed": sport = "Cycling"; price += brStudents * 9.5 * brNights;
                        break;
                }
                break;
            case "Summer":
                switch (typeGroup) {
                    case "boys": sport = "Football"; price += brStudents * 15 * brNights;
                        break;
                    case "girls": sport = "Volleyball"; price += brStudents * 15 * brNights;
                        break;
                    case "mixed": sport = "Swimming"; price += brStudents * 20 * brNights;
                        break;
                }
                break;
        }
        if (brStudents >= 50) {
            price -= price * 0.5;
        } else if (brStudents >= 20 && brStudents < 50) {
            price -= price * 0.15;
        } else  if (brStudents >= 10 && brStudents < 20) {
            price -= price * 0.05;
        }

        System.out.printf("%s %.2f lv.", sport, price);
    }
}
