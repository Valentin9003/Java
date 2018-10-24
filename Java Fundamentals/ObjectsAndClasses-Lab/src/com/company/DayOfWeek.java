package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayOfWeek {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");

        Date dt1=format1.parse(input);

        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay=format2.format(dt1);

        System.out.println(finalDay);
    }
}
