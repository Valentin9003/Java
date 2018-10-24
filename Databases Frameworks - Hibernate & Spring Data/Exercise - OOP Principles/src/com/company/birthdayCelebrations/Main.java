package com.company.birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Societies> societyList = new LinkedList<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("End")) {
            String[] tokens = inputLine.split("\\s+");
            addToScietyList(tokens, societyList);
            inputLine = reader.readLine();
        }

        String year = reader.readLine();
        printDetainedId(societyList, year);
    }

    private static void printDetainedId(List<Societies> societyList, String year) {
        societyList
                .stream()
                .filter(x -> x.getBirthday() != null && x.getBirthday().endsWith(year))
                .forEach(d -> System.out.println(d.getBirthday()));
    }

    private static void addToScietyList(String[] tokens, List<Societies> societyList) {
        Societies society = null;
        String id;
        String birthday;
        String name;
        switch (tokens[0]) {
            case "Robot":
                String model = tokens[1];
                id = tokens[2];
                society = new Robots(model, id);
                break;
            case "Citizen":
                name = tokens[1];
                Integer age = Integer.parseInt(tokens[2]);
                id = tokens[3];
                birthday = tokens[4];
                society = new Citizens(name, age, id, birthday);
                break;
            case "Pet":
                name = tokens[1];
                birthday = tokens[2];
                society = new Pet(name, birthday);
        }
        societyList.add(society);
    }
}
