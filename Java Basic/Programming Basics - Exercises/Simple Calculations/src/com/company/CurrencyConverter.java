package com.company;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amout = Double.parseDouble(scanner.nextLine());
        String inCurrency = scanner.nextLine();
        String outCurrency = scanner.nextLine();

        double kurs = 0;
        double kursToBgn = 0;

        switch (inCurrency) {
            case "BGN": kursToBgn = 1; break;
            case "USD": kursToBgn = 1.79549; break;
            case "EUR": kursToBgn = 1.95583; break;
            case "GBR": kursToBgn = 2.53405; break;
        }
        switch (outCurrency) {
            case "BGN": kurs = 1; break;
            case "USD": kurs = 1.79549; break;
            case "EUR": kurs = 1.95583; break;
            case "GBR": kurs = 2.53405; break;
        }
        double sum = amout * kursToBgn / kurs;
        System.out.printf("%.2f %s",sum,outCurrency);
    }
}
