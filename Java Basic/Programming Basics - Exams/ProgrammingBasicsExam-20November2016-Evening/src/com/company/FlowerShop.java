package com.company;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolii = Integer.parseInt(scanner.nextLine());
        int ziumbil = Integer.parseInt(scanner.nextLine());
        int rozi = Integer.parseInt(scanner.nextLine());
        int kaktus = Integer.parseInt(scanner.nextLine());
        double priceReward = Double.parseDouble(scanner.nextLine());

        double price = magnolii * 3.25 + ziumbil * 4 + rozi * 3.5 + kaktus * 8;
        price -= price * 0.05;

        if (priceReward > price) {
            priceReward -= price;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(priceReward));
        } else {
            price -= priceReward;
            System.out.printf("She is left with %.0f leva.", Math.floor(price));
        }
    }
}
