package com.company;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();


        if (country.equals("England") || country.equals("USA") || country.equals("Spain") || country.equals("Argentina") || country.equals("Mexico")) {
            switch (country) {
                case "USA":
                case "England":
                    System.out.println("English");
                    break;
                case "Spain":
                case "Argentina":
                case "Mexico":
                    System.out.println("Spanish");
                    break;
            }
        } else {
            System.out.println("unknown");
        }
    }
}
