package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> personPhoneNumber = new LinkedHashMap<>();

        String[] inputLine = reader.readLine().split("\\s+");
        while (!inputLine[0].equals("END")) {
            String name = String.format("%s %s", inputLine[0], inputLine[1]);
            String phone = inputLine[2];
            personPhoneNumber.putIfAbsent(name, phone);
            inputLine = reader.readLine().split("\\s+");
        }

        personPhoneNumber
                .entrySet()
                .stream()
                .filter(x ->
                        x.getValue().startsWith("02")
                                || x.getValue().startsWith("+3592"))
                .forEach(x -> {
                    System.out.println(x.getKey());
                });
    }
}
