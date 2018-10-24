package com.company;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int roll = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case "Premiere": System.out.printf("%.2f leva",(double)(roll * col * 12)); break;
            case "Normal": System.out.printf("%.2f leva",(double)(roll * col * 7.50)); break;
            case "Discount": System.out.printf("%.2f leva",(double)(roll * col * 5)); break;
        }
    }
}
