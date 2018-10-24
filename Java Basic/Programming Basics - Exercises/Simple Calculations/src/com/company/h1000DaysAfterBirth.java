package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class h1000DaysAfterBirth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String date = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date2=null;

        try {
            date2 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date AddDate1 = addDays(date2, 999);
        System.out.println(sdf.format(AddDate1));

    }
    private static Date addDays(Date d, long days) {
        d.setTime(d.getTime() + days*1000*60*60*24);
        return d;
    }
}
