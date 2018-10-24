package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###0.00");

        double hrizantemi = Double.parseDouble(scanner.nextLine());
        double rozi = Double.parseDouble(scanner.nextLine());
        double laleta = Double.parseDouble(scanner.nextLine());
        String seasone = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;
        double priceH = 0;
        double priceR = 0;
        double priceL = 0;
        double br = hrizantemi + rozi + laleta;

        if (day.equals("Y")) {                     // in holliday  price up with 15%

            switch (seasone) {
                case "Spring": priceH += 2.00 + 2.00 * 0.15; priceR += 4.10 + 4.10 * 0.15; priceL += 2.50 + 2.50 * 0.15;
                    if (laleta < 7) {
                        if (br < 20) {
                            price += hrizantemi * priceH + rozi * priceR + laleta * priceL +2;
                        } else {
                            price += (hrizantemi * priceH + rozi * priceR + laleta * priceL);
                            price -=price * 0.2;
                            price += 2;
                        }
                    } else {
                        if (br < 20) {
                            price += hrizantemi * priceH + rozi * priceR + laleta * priceL;
                            price -=price * 0.05;
                            price += 2;
                        } else {
                            price += hrizantemi * priceH + rozi * priceR + laleta * priceL;
                            price -=price * 0.05;
                            price -= price * 0.2;
                            price += 2;
                        }
                    }
                    break;
                case "Summer": priceH += 2.00 + 2.00 * 0.15; priceR += 4.10 + 4.10 * 0.15; priceL += 2.50 + 2.50 * 0.15;
                    if (br < 20) {
                        price += hrizantemi * priceH + rozi * priceR + laleta * priceL +2;
                    }else {
                        price += (hrizantemi * priceH + rozi * priceR + laleta * priceL);
                        price -=price * 0.2;
                        price += 2;
                    }
                    break;
                case "Autumn": priceH += 3.75 + 3.75 * 0.15; priceR += 4.50 + 4.50 * 0.15; priceL += 4.15 + 4.15 * 0.15;
                    if (br < 20) {
                        price += hrizantemi * priceH + rozi * priceR + laleta * priceL +2;
                    }else {
                        price += (hrizantemi * priceH + rozi * priceR + laleta * priceL);
                        price -=price * 0.2;
                        price += 2;
                    }
                    break;
                case "Winter": priceH += 3.75 + 3.75 * 0.15; priceR += 4.50 + 4.50 * 0.15; priceL += 4.15 + 4.15 * 0.15;
                    if (rozi < 10) {
                        if (br < 20) {
                            price += hrizantemi * priceH + rozi * priceR + laleta * priceL +2;
                        } else {
                            price += (hrizantemi * priceH + rozi * priceR + laleta * priceL);
                            price -= price * 0.2;
                            price += 2;
                        }
                    } else {
                        if (br < 20) {
                            price += hrizantemi * priceH + rozi * priceR + laleta * priceL;
                            price -= price * 0.1;
                            price += 2;
                        } else {
                            price += hrizantemi * priceH + rozi * priceR + laleta * priceL;
                            price -= price * 0.1;
                            price -= price * 0.2;
                            price += 2;
                        }
                    }
                    break;
            }

        } else {

            switch (seasone) {
                case "Spring":
                    if (laleta < 7) {
                        if (br < 20) {
                            price += hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50 +2;
                        } else {
                            price += hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50;
                            price -= price * 0.2;
                            price += 2;
                        }
                    } else {
                        if (br < 20) {
                            price += hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50;
                            price -= price * 0.1;
                            price += 2;
                        } else {
                            price += hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50;
                            price -= price * 0.1;
                            price -= price * 0.2;
                            price += 2;
                        }
                    }
                    break;
                case "Summer":

                    if (br < 20) {
                        price += hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50 +2;
                    } else {
                        price += hrizantemi * 2.00 + rozi * 4.10 + laleta * 2.50;
                        price -= price * 0.2;
                        price += 2;
                    }
                    break;
                case "Autumn":
                    if (br < 20) {
                        price += hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15 +2;
                    } else {
                        price += hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15;
                        price -= price * 0.2;
                        price += 2;
                    }
                    break;
                case "Winter":
                    if (rozi < 10) {
                        if (br < 20) {
                            price += hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15 + 2;
                        } else {
                            price += hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15;
                            price -= price * 0.2;
                            price += 2;
                        }
                    } else if (rozi >= 10){
                        if (br < 20) {
                            price += hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15;
                            price -= price * 0.1;
                            price += 2;
                        } else {
                            price += hrizantemi * 3.75 + rozi * 4.50 + laleta * 4.15;
                            price -= price * 0.1;
                            price -= price * 0.2;
                            price += 2;
                        }
                    }
                    break;
            }

        }

        System.out.println(df.format(price));
    }
}

