package com.company;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bitCoin = Double.parseDouble(scanner.nextLine());
        double china = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());

//•	1 биткойн = 1168 лева.
//•	1 китайски юан = 0.15 долара.
//•	1 долар = 1.76 лева.
//•	1 евро = 1.95 лева.
//На конзолата да се отпечата 1 число - резултатът от обмяната на валутите. Не е нужно резултатът да се закръгля.
        if (bitCoin >= 0 || bitCoin <= 20) {
            if (china >= 0.00 || china <= 50000.00) {
                if (tax >= 0.00 || tax <= 5.00) {
                    double bCoinToBgn = bitCoin * 1168;
                    double chinaToUsd = china * 0.15;
                    double usdToBgn = chinaToUsd * 1.76;
                    double euro = (bCoinToBgn + usdToBgn) / 1.95;
                    System.out.printf("%.2f",euro - (euro * tax / 100));
                }
            }
        }
    }
}
