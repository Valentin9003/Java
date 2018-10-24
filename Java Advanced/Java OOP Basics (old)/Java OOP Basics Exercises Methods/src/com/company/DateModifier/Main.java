package com.company.DateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstDate = reader.readLine();
        String secondDate = reader.readLine();

        DateModifier dm = new DateModifier(firstDate, secondDate);
        dm.getDifferenceDays();
    }
}
