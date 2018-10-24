package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###0.00");

        double saveMoney = Double.parseDouble(scanner.nextLine());
        double weighFloor = Double.parseDouble(scanner.nextLine());
        double hightFloor = Double.parseDouble(scanner.nextLine());
        double aTriangle = Double.parseDouble(scanner.nextLine());
        double hTriangle = Double.parseDouble(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double priceMaster = Double.parseDouble(scanner.nextLine());

        double floorArea = weighFloor * hightFloor;
        double areaTriangle = aTriangle * hTriangle / 2;

        double need = Math.ceil(floorArea / areaTriangle) + 5;
        need *= price;
        need += priceMaster;

        if (need <= saveMoney) {
            saveMoney -= need;
            System.out.println(df.format(saveMoney) + " lv left.");
        } else {
            need -= saveMoney;
            System.out.println("You'll need " + df.format(need) + " lv more.");
        }
    }
}
