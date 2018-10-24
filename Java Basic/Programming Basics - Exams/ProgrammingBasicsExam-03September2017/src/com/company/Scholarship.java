package com.company;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salary = Double.parseDouble(scanner.nextLine());
        double avarage = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());

        double socScholarship = minSalary * 0.35;
        double exScholarship = avarage * 25;

        if (salary < minSalary) {
            if (avarage >= 5.50) {

                if (exScholarship > socScholarship) {
                    System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(exScholarship));
                } else {
                    System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socScholarship));
                }

            }  else if (avarage >= 4.5 && avarage < 5.5) {
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socScholarship));
            } else {
                System.out.println("You cannot get a scholarship!");
            }


        } else {
            if (avarage >= 5.50) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(exScholarship));
            }
            else {
                System.out.println("You cannot get a scholarship!");
            }
        }
    }}
