package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BeverageLabels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#####0.####");

        String name = scanner.nextLine();
        double volume = Integer.parseInt(scanner.nextLine());
        double energyContent = Integer.parseInt(scanner.nextLine());
        double sugarContent = Integer.parseInt(scanner.nextLine());

        double energySum = (volume / 100) * energyContent;
        double sugarSum = (volume / 100) * sugarContent;

        System.out.printf("%.0fml %s:%n", volume,name);
        System.out.println(df.format(energySum) + "kcal, " + df.format(sugarSum) + "g sugars");
    }
}
