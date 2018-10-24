package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####0.00");

        String season = scanner.nextLine();    //"Spring", "Summer", "Autumn" или "Winter"
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double salaray = 0;

        if (kmPerMonth <= 5000) {
            switch (season){
                case "Spring":
                case "Autumn":
                    salaray += (kmPerMonth * 0.75 * 4) - ((kmPerMonth * 0.75 * 4) * 0.1);
                    break;
                case "Summer":
                    salaray += (kmPerMonth * 0.9 * 4) - ((kmPerMonth * 0.9 * 4) * 0.1);
                    break;
                case "Winter":
                    salaray += (kmPerMonth * 1.05 * 4) - ((kmPerMonth * 1.05 * 4) * 0.1);
                    break;
            }
        } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
            switch (season){
                case "Spring":
                case "Autumn":
                    salaray += (kmPerMonth * 0.95 * 4) - ((kmPerMonth * 0.95 * 4) * 0.1);
                    break;
                case "Summer":
                    salaray += (kmPerMonth * 1.1 * 4) - ((kmPerMonth * 1.1 * 4) * 0.1);
                    break;
                case "Winter":
                    salaray += (kmPerMonth * 1.25 * 4) - ((kmPerMonth * 1.25 * 4) * 0.1);
                    break;
            }
        } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
            salaray += (kmPerMonth * 1.45 * 4) - ((kmPerMonth * 1.45 * 4) * 0.1);
        }
        System.out.println(df.format(salaray));
    }
}
