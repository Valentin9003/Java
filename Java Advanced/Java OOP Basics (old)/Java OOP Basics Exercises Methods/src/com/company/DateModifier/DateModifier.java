package com.company.DateModifier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateModifier {

    private String firstDate;
    private String secondDate;

    public DateModifier(String firstDate, String secondDate) {
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    public void getDifferenceDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date1 = LocalDate.parse(firstDate, formatter);
        LocalDate date2 = LocalDate.parse(secondDate, formatter);

        long days = ChronoUnit.DAYS.between(date1, date2);
        System.out.println(Math.abs(days));
    }
}
