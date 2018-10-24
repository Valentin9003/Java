package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DailyWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#####.00");

        int workDays = Integer.parseInt(scanner.nextLine());              //работни дни в месеца. Цяло число в интервала [5…30]
        double winDailyMoney = Double.parseDouble(scanner.nextLine());    //изкарани пари на ден. Реално число в интервала [10.00… 2000.00]
        double lvForUsd = Double.parseDouble(scanner.nextLine());          //курсът на долара спрямо  лева /1 долар = X лева/. Реално число в интервала [0.99… 1.99]

        if ((workDays >= 5 && workDays <= 30)
                && (winDailyMoney >= 10.00 && winDailyMoney <= 2000.00)
                && (lvForUsd >= 0.99 && lvForUsd <= 1.99)) {

            double monthlyWin = winDailyMoney * workDays;
            double winForYear = monthlyWin * 12 + monthlyWin * 2.5;
            double clearSalary =  winForYear - (winForYear * 25 / 100);
            clearSalary *= lvForUsd;
            winDailyMoney = clearSalary / 365;

            System.out.println(df.format(winDailyMoney));

        }
    }
}
