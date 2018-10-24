package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#####.00");

        double priceSkumriq = Double.parseDouble(scanner.nextLine());
        double priceCaca = Double.parseDouble(scanner.nextLine());
        double kgPalamud = Double.parseDouble(scanner.nextLine());
        double kgSafrid = Double.parseDouble(scanner.nextLine());
        double kgMidi = Double.parseDouble(scanner.nextLine());

        double pricePalamud = priceSkumriq + (priceSkumriq * 0.6);
        double priceSafrid = priceCaca + (priceCaca * 0.8);
        double priceMidi = 7.50;

        double check = kgMidi * priceMidi + kgPalamud * pricePalamud + kgSafrid * priceSafrid;

        System.out.println(df.format(check));
    }
}
