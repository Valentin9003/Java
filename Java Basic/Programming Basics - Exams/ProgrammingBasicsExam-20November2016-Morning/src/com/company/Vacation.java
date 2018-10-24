package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("######.00");

        int brOldPpl = Integer.parseInt(scanner.nextLine());       //броят възрастни хора. Цяло число в интервала [1…100]
        int brStudents = Integer.parseInt(scanner.nextLine());     //броят ученици. Цяло число в интервала [1… 100]
        int brNights = Integer.parseInt(scanner.nextLine());       //броят нощувки. Цяло число в интервала [1 ... 60]
        String transport = scanner.nextLine();                     //вид транспорт – “train”, “bus”, “boat” или “airplane”

        double sumTransport = 0;

        switch (transport) {
            case "train" :
                if ((brOldPpl + brStudents) >= 50) {
                    sumTransport = ((brOldPpl * 24.99 + brStudents * 14.99) * 0.5) * 2;
                } else {
                    sumTransport = (brOldPpl * 24.99 + brStudents * 14.99) *2;
                }
                break;
            case "bus" :
                sumTransport = (brOldPpl * 32.5 + brStudents * 28.5) * 2;
                break;
            case "boat" :
                sumTransport = (brOldPpl * 42.99 + brStudents * 39.99) * 2;
                break;
            case "airplane" :
                sumTransport = (brOldPpl * 70.00 + brStudents * 50.00) * 2;
                break;
        }
        double sumNights = brNights * 82.99;
        double allSum = sumTransport + sumNights + ((sumTransport + sumNights) * 0.1);

        System.out.println(df.format(allSum));
    }
}
