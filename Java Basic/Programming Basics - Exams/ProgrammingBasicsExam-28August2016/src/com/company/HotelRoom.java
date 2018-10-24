package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        BigDecimal nights1 = new BigDecimal(nights);
        BigDecimal studioPrice = new BigDecimal("0.00");
        BigDecimal apartPrice = new BigDecimal("0.00");

        if ((nights >= 0 && nights <= 200) && (month.equalsIgnoreCase("May") || month.equalsIgnoreCase("June")
                || month.equalsIgnoreCase("July") || month.equalsIgnoreCase("August")
                || month.equalsIgnoreCase("September") || month.equalsIgnoreCase("October"))) {

            switch (month) {
                case "May":
                case "October":
                    BigDecimal priceS = new BigDecimal("50.00");
                    BigDecimal priceA = new BigDecimal("65.00");
                    if (nights <= 7) {
                        studioPrice = priceS.multiply(nights1);
                        apartPrice = priceA.multiply(nights1);
                    } else if (nights > 7 && nights <= 14) {
                        BigDecimal ost = new BigDecimal("0.05");
                        studioPrice = (priceS.subtract(priceS.multiply(ost))).multiply(nights1);
                        apartPrice = priceA.multiply(nights1);
                    } else {
                        BigDecimal ostS = new BigDecimal("0.30");
                        BigDecimal ostA = new BigDecimal("0.10");
                        studioPrice = (priceS.subtract(priceS.multiply(ostS))).multiply(nights1);
                        apartPrice = (priceA.subtract(priceA.multiply(ostA))).multiply(nights1);
                    }
                    break;

                case "June":
                case "Septeber":
                    BigDecimal priceSt = new BigDecimal("75.20");
                    BigDecimal priceAp = new BigDecimal("68.70");
                    if (nights <= 14) {
                        studioPrice = priceSt.multiply(nights1);
                        apartPrice = priceAp.multiply(nights1);
                    } else {
                        BigDecimal ostS = new BigDecimal("0.20");
                        BigDecimal ostA = new BigDecimal("0.10");
                        studioPrice = (priceSt.subtract(priceSt.multiply(ostS))).multiply(nights1);
                        apartPrice = priceAp.subtract(priceAp.multiply(ostA)).multiply(nights1);
                    }
                    break;

                case "July":
                case "August":
                    BigDecimal priceStu = new BigDecimal("76.00");
                    BigDecimal priceApa = new BigDecimal("77.00");
                    if (nights <= 14) {
                        studioPrice = priceStu.multiply(nights1);
                        apartPrice = priceApa.multiply(nights1);
                    } else {
                        BigDecimal ostA = new BigDecimal("0.10");
                        studioPrice = priceStu.multiply(nights1);
                        apartPrice = (priceApa.subtract(priceApa.multiply(ostA))).multiply(nights1);
                    }
                    break;
            }
        }

        System.out.println("Apartment: " + apartPrice.setScale(2,BigDecimal.ROUND_HALF_EVEN) + " lv.");
        System.out.println("Studio: " + studioPrice.setScale(2,BigDecimal.ROUND_HALF_EVEN) + " lv.");
    }
}

